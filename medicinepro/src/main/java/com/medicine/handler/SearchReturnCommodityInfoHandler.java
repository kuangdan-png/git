package com.medicine.handler;

import com.medicine.pojo.*;
import com.medicine.service.inter.ReturnCommodityManageServiceInter;
import com.medicine.service.inter.SaleCommodityManageServiceInter;
import com.medicine.util.CommandMethod;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Auther:龚成
 * DATE: 2019-11-27 10:29:41
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
@Controller
public class SearchReturnCommodityInfoHandler {
    //依赖注入业务逻辑层
    @Resource(name = "returnCommodityManageServiceImpl")
    private ReturnCommodityManageServiceInter ReturnCommodityManageServiceImpl;
    public void setReturnCommodityManageServiceImpl(ReturnCommodityManageServiceInter returnCommodityManageServiceImpl) {
        ReturnCommodityManageServiceImpl =returnCommodityManageServiceImpl;
    }
    //依赖注入编号类
    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;
    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 查询最新退货单号
     * @return
     */
    @RequestMapping(value = "/getReturnOddNumber.action")
    public @ResponseBody Receipts newReturnOddNumber(){
        //调用通用方法查询最大退货
        MaxNo maxNo =new MaxNo("receipts",8);
        //创建对象 并返回
        Receipts receipts=new Receipts();
        receipts.setRecOdd(commandMethod.getOddMaxNo(maxNo));
        return receipts;
    }
    /**
     * 查询客户下拉列表
     * @return
     */
    @RequestMapping(value = "/searchAllReturnSupplierName.action")
    public @ResponseBody List<Client> clientNameList(){
        List<Client> ClientList =ReturnCommodityManageServiceImpl.clientNameList();
        return ClientList;
    }

    /**
     * 查询仓库下拉列表
     * @return
     */
    @RequestMapping(value = "/searchreturnAllwarHName.action")
    public @ResponseBody List<Warehouse> allwarHName(){
        List<Warehouse> warehouse =ReturnCommodityManageServiceImpl.allwarHName();
        return warehouse;
    }


    /**
     * 根据客户名称查询 单据下拉列表(此单据中仅有一条商品 则该商品可退的数量必须大于0 否则不查询)
     * @param cliID
     * @return
     */
    @RequestMapping(value = "/searchreturnNumByCliID.action")
    public @ResponseBody List<ReceiptsDetailed> searchReturnNumByCliID(@RequestParam("cliID") String cliID){
        List<ReceiptsDetailed> selectNumList =ReturnCommodityManageServiceImpl.searchReturnNumByCliID(cliID);
        return selectNumList;
    }

    /**
     * 根据商品ID或者名称和客户ID与单据号模糊查询可退货商品
     * @return
     */
    @RequestMapping(value = "/getReturnCommodityByNameOrId.action")
    public @ResponseBody List<Commodity> returncommodityByNameOrId(@RequestParam("val") String val,@RequestParam("cliID") String cliID,@RequestParam("oddNum") String oddNum){
        List<Commodity> commodityList =ReturnCommodityManageServiceImpl.returncommodityByNameOrId(val,cliID,oddNum);
        return commodityList;
    }
    /**
     * 查询所编辑的商品退货数量是否大于销售数量（销售单据）
     * @param comId
     * @return
     */
    //保存当前操作的单据号(更改可退数量用)
    String oddNum1="";
    @RequestMapping(value = "/IfReturnNumBigRepertory.action")
    @ResponseBody
    public String ifNumBigRepertory(@RequestParam("comId") String comId,@RequestParam("oddNum") String oddNum) {
        String fh = "";
        //根据商品ID查询库存
        int repNumber = ReturnCommodityManageServiceImpl.ifNumBigRepertory(comId,oddNum);
        fh = String.valueOf(repNumber);
        oddNum1=oddNum;
        return fh;
    }
    /**
     * 新增退货主表信息
     * @return
     */
    //仓库主键
    String redDepotNo="";
    @RequestMapping(value = "/ReturnFormInfo.action")
    @ResponseBody
    public int insertReturnFormInfo(@RequestBody Receipts receipts){
        //保存出货仓库
        redDepotNo=receipts.getRedDepotNo();
        int fh=ReturnCommodityManageServiceImpl.insertReturnFormInfo(receipts);
        //更改退货单据普通ID
        MaxNo maxNo1=new MaxNo("receipts",receipts.getRecNo(),0);
        int fh1=commandMethod.updateMax(maxNo1);
        return fh;
    }

    /**
     * 新增退货单据明细表
     * @param data
     * @return
     */
    @RequestMapping(value = "/ReturnComTableInfo.action")
    @ResponseBody
    public int insertReturnComTableInfo(String data){
        //将数据表格json格式转换为list集合
        List<Commodity> commoditylist = JSONArray.toList(JSONArray.fromObject(data), new Commodity(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
        //List作为集合传入新增退货明细
        int fh2=ReturnCommodityManageServiceImpl.insertReturnTableInfo(commoditylist);
        //更新可退货数量 根据销售单据号
        int fh=ReturnCommodityManageServiceImpl.updateCanReturnNum(commoditylist,oddNum1);
        //保存退货单据的商品ID代入相应出货仓库表更新库存
        if(fh+fh2!=0){
            int fh1=ReturnCommodityManageServiceImpl.updateWoreHouse(commoditylist,redDepotNo);
        }
        return fh+fh2;
    }


}
