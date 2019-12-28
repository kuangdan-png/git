package com.medicine.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.medicine.pojo.*;
import com.medicine.service.inter.SaleCommodityManageServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.LayuiTree;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
/**
 * Auther:龚成
 * DATE: 2019-11-27 10:29:41
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
@Controller
public class SearchSaleCommodityInfoHandler {
    //依赖注入业务逻辑层
    @Resource(name = "saleCommodityManageServiceImpl")
    private SaleCommodityManageServiceInter SaleCommodityManageServiceImpl;
    public void setSaleCommodityManageServiceImpl(SaleCommodityManageServiceInter saleCommodityManageServiceImpl) {
        SaleCommodityManageServiceImpl = saleCommodityManageServiceImpl;
    }
    //依赖注入最大单号类
    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;
    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 查询代售商品
     * @return
     */
    @RequestMapping(value = "/getSaleCommodityInfo.action")
    //返回对象集合转换为Json格式
    public @ResponseBody List<Commodity> saleCommodityInfo(@RequestParam("limit") String limit,@RequestParam("page") String page){
        //获取数据表格的当前页面 与每页条数并保存在pageation对象中
        int page1 =Integer.parseInt(page);
        int limit1 =Integer.parseInt(limit);
        Pagegation pagegation =new Pagegation(page1-1,limit1);
        //调用业务逻辑层 pageation做参数查询
        List<Commodity> commodityList =SaleCommodityManageServiceImpl.saleCommodityInfo(pagegation);
        return commodityList;
    }

    /**
     * 查询最新销售单号
     * @return
     */
    @RequestMapping(value = "/getSaleOddNumber.action")
    public @ResponseBody Receipts newSaleOddNumber(){
        //调用通用方法 查询销售单据醉倒单据
        MaxNo maxNo =new MaxNo("receipts",6);
        //为对象赋值 并返回
        Receipts receipts=new Receipts();
        receipts.setRecOdd(commandMethod.getOddMaxNo(maxNo));
        return receipts;
    }

    /**
     * 根据商品ID或者名称和所在仓库模糊查询商品信息
     * @return
     */
    @RequestMapping(value = "/getCommodityByNameOrId.action")
    public @ResponseBody List<Commodity> commodityByNameOrId(@RequestParam("val") String val,@RequestParam("warID") String warID){
        List<Commodity> commodityList =SaleCommodityManageServiceImpl.commodityByNameOrId(val,warID);
        return commodityList;
    }
    /**
     * 查询商品类别
     * @return
     */
    @RequestMapping(value="/searchCommodityParentType.action")
    public @ResponseBody List<LayuiTree<Category>>  searchCommodityParentType() {
        List<LayuiTree<Category>> layuiTreeList=layuiTreeList=new ArrayList<LayuiTree<Category>>();
        /*假如seniorSeclct为空则证明是页面初始化时的类别查询*/
        /*获取所有商品类别父类别*/
        List<Category> categoryList= SaleCommodityManageServiceImpl.searchCommodityType();
        for (Category category :categoryList){
            /*根据商品父类别查找商品子类别*/
            List<Category> categoryList1=SaleCommodityManageServiceImpl.searchCommodity(category.getCatId());
            /*将父类别和子类别存入layuiTree实例中使传入前台的数据时树形结构能够解析的json格式*/
            LayuiTree<Category> layuiTree=new LayuiTree<Category>(category.getTitle(), category.getCatId(), categoryList1);
            layuiTreeList.add(layuiTree);
        }
        return layuiTreeList;
    }

    /**
     * 根据点击获取类型ID查询商品信息
     * @return
     */
    @RequestMapping(value = "/searchInfoByClick.action")
    public @ResponseBody List<Commodity> infoByClick(@RequestParam("catid") String typeId,@RequestParam("warID") String warID){
        //根据点击商品类型 仓库ID
        List<Commodity> commodityList =SaleCommodityManageServiceImpl.infoByClick(typeId,warID);
        return commodityList;
    }

    /**
     * 查询客户下拉列表
     * @return
     */
    @RequestMapping(value = "/searchAllSupplierName.action")
    public @ResponseBody List<Client> clientNameList(){
        List<Client> ClientList =SaleCommodityManageServiceImpl.clientNameList();
        return ClientList;
    }

    /**
     * 查询仓库下拉列表
     * @return
     */
    @RequestMapping(value = "/searchAllwarHName.action")
    public @ResponseBody List<Warehouse> allwarHName(){
        List<Warehouse> warehouse =SaleCommodityManageServiceImpl.allwarHName();
        return warehouse;
    }

    /**
     * 查询经办人下拉列表
     * @return
     */
    @RequestMapping(value = "/searchAllEmployessName.action")
    public @ResponseBody List<Employees> allEmployessName(){
        List<Employees> employessName =SaleCommodityManageServiceImpl.allEmployessName();
        return employessName;
    }
    /**
     * 新增销售主表信息
     * @return
     */
    //保存销售出货仓库主键(销售明细表取值)
    String redDepotNo="";
    @RequestMapping(value = "/saleFormInfo.action")
    @ResponseBody
    public int insertFormInfo(@RequestBody Receipts receipts){
        //保存出货仓库
        redDepotNo=receipts.getRecWareNo();
        int fh=SaleCommodityManageServiceImpl.insertFormInfo(receipts);
        //更改销售单据普通ID
        MaxNo maxNo1=new MaxNo("receipts",receipts.getRecNo(),0);
        int fh1=commandMethod.updateMax(maxNo1);
        return fh;
    }

    /**
     * 新增销售单据明细表
     * @param data
     * @return
     */
    @RequestMapping(value = "/saleComTableInfo.action")
    @ResponseBody
    public int insertSaleComTableInfo(String data){
        //将数据表格json格式转换为list集合
        List<Commodity> commoditylist = JSONArray.toList(JSONArray.fromObject(data), new Commodity(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
        //List作为集合传入新增销售明细
        int fh2=SaleCommodityManageServiceImpl.insertTableInfo(commoditylist);
        //保持销售单据的商品ID代入相应出货仓库表更新库存
        int fh1=SaleCommodityManageServiceImpl.updateWoreHouse(commoditylist,redDepotNo);
        return fh1+fh2;
    }

    /**
     * 查询所编辑的商品数量是否大于库存
     * @param comId
     * @return
     */
    @RequestMapping(value = "/IfNumBigRepertory.action")
    @ResponseBody
    public String ifNumBigRepertory(@RequestParam("comId") String comId,@RequestParam("warID") String warID) {
        String fh = "";
        //根据商品ID与仓库ID查询库存 转换string类型返回
        int repNumber = SaleCommodityManageServiceImpl.ifNumBigRepertory(comId,warID);
        fh = String.valueOf(repNumber);
        return fh;
    }
}
