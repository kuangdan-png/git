package com.medicine.service.impl;

import com.medicine.dao.impl.ReturnCommodityManageDaoImpl;
import com.medicine.dao.inter.ReturnCommodityManageDaoInter;
import com.medicine.pojo.*;
import com.medicine.service.inter.ReturnCommodityManageServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.GetUUID;
import net.sf.ehcache.search.aggregator.Max;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Auther:龚成
 * DATE: 2019-11-27 10:29:41
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
@Service("returnCommodityManageServiceImpl")
public class ReturnCommodityManageServiceImpl implements ReturnCommodityManageServiceInter {
    //依赖注入数据访问层
    @Resource(name = "returnCommodityManageDaoImpl")
    private ReturnCommodityManageDaoInter returnCommodityManageDaoImpl;
    public void setSaleCommodityManageDaoImpl(ReturnCommodityManageDaoImpl returnCommodityManageDaoImpl) {
        returnCommodityManageDaoImpl = returnCommodityManageDaoImpl;
    }
    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    //销售单号
    private String redOdd="";
    //收货仓库主键
    private String recWareNo="";
    //备注
    private String redComment="";
    //单据表主键
    private String recNo="";
    //客户主键
    private String cliID="";
    //实退金额
    private double duo4=0.0;
    /**
     * 查询仓库下拉列表
     * @return
     */
    @Override
    public List<Warehouse> allwarHName() {
        List<Warehouse> warehouse=returnCommodityManageDaoImpl.allwarHName();
        return warehouse;
    }

    /**
     * 客户名称下拉列表
     * @return
     */
    @Override
    public List<Client> clientNameList() {
        List<Client> clientList=returnCommodityManageDaoImpl.clientNameList();
        return clientList;
    }

    /**
     * 根据客户名称查询 单据下拉列表(此单据中仅有一条商品 则该商品可退的数量必须大于0 否则不查询)
     * @param cliID
     * @return
     */
    @Override
    public List<ReceiptsDetailed> searchReturnNumByCliID(String cliID) {
        return returnCommodityManageDaoImpl.searchReturnNumByCliID(cliID);
    }

    /**
     * 根据商品ID或者名称和客户ID与单据号模糊查询可退货商品
     * @param val
     * @param cliID
     * @param oddNum
     * @return
     */
    @Override
    public List<Commodity> returncommodityByNameOrId(String val, String cliID, String oddNum) {
        return returnCommodityManageDaoImpl.returncommodityByNameOrId(val,cliID,oddNum);
    }

    /**
     * 查询所编辑的商品退货数量是否大于销售数量（销售单据）
     * @param comId
     * @param oddNum
     * @return
     */
    @Override
    public int ifNumBigRepertory(String comId, String oddNum) {
        return returnCommodityManageDaoImpl.ifNumBigRepertory(comId,oddNum);
    }

    /**
     * 新增退货主表信息
     * @param receipts
     * @return
     */
    @Override
    @Transactional(propagation=REQUIRED,readOnly = false)
    public int insertReturnFormInfo(Receipts receipts) {
        //获取普通主键ID
        MaxNo maxNo =new MaxNo("receipts",0);
        String recNo1=commandMethod.getPuMaxNo(maxNo);
        receipts.setRecNo(recNo1);
        receipts.setRecDocumentTypes("RN00006");
        //退货单号(明细表用)
        redOdd=receipts.getRecOdd();
        //仓库ID(明细表用)
        recWareNo=receipts.getRedDepotNo();
        //备注(明细表用)
        redComment=receipts.getRecRemark();
        //销售单据表普通主键ID(明细表用)
        recNo=receipts.getRecNo();
        //客户ID(明细表用)
        cliID=receipts.getDuo2();
        //收收金额 (明细表用)
        duo4=Double.parseDouble(receipts.getDuo4());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(String.valueOf(receipts.getRecDateSale()));
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date);
            Calendar now = Calendar.getInstance();
            // 将时分秒,毫秒域清零 将当前系统时分秒拼接
            cal1.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY));
            cal1.set(Calendar.MINUTE, now.get(Calendar.MINUTE));
            cal1.set(Calendar.SECOND, now.get(Calendar.SECOND));
            //set为销售日期赋值
            receipts.setRecDateSale(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal1.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int fh=returnCommodityManageDaoImpl.insertReturnFormInfo(receipts);
        //更改退货单据最大单据号
        MaxNo maxNo2=new MaxNo("receipts",receipts.getRecOdd(),8);
        int fh2=commandMethod.updateMax(maxNo2);
        return fh;
    }

    /**
     * 新增退货单据明细表
     * @param commoditylist
     * @return
     */
    @Override
    @Transactional(propagation=REQUIRED,readOnly = false)
    public int insertReturnTableInfo(List<Commodity> commoditylist) {
        int fh=0;
        for (int i=0;i<commoditylist.size();i++){
            //获取退货单据明细表 普通主键ID
            MaxNo maxNo =new MaxNo("receipts_detailed",0);
            String redNo=commandMethod.getPuMaxNo(maxNo);
            maxNo.setManSort(redNo);
            //获取退货商品对象
            Commodity commodity =commoditylist.get(i);
            //创建明细表对象 构造方法赋值新增数据 （redOdd——与销售单据主表单据号对应）
            ReceiptsDetailed receiptsDetailed1=new ReceiptsDetailed(redNo,redOdd,
                    commodity.getComId(),commodity.getComName(),commodity.getComUnit(),
                    commodity.getComProduct(),commodity.getComApproval(),
                    commodity.getComPrice(),Integer.parseInt(commodity.getDuo1()),recWareNo,redComment,
                    commodity.getComTypeId(),recNo,cliID,duo4);

            //执行新增
            fh=returnCommodityManageDaoImpl.insertReturnTableInfo(receiptsDetailed1);
            //更改销售单据明细表 普通主键ID
            MaxNo maxNo1=new MaxNo("receipts_detailed",receiptsDetailed1.getRedNo(),0);
            int fh1=commandMethod.updateMax(maxNo1);
            commandMethod.updateMax(maxNo);
        }
        return fh;
    }

    /**
     * 保存退货单据的商品ID代入相应出货仓库表更新库存（根据收货仓库ID增加库存 如收货仓库没有退货商品则新增一条数据 库存为退货数）
     * @param commoditylist
     * @param redDepotNo
     * @return
     */
    @Override
    @Transactional(propagation=REQUIRED,readOnly = false)
    public int updateWoreHouse(List<Commodity> commoditylist, String redDepotNo) {
        int count=0;
        for(int i=0;i<commoditylist.size();i++){
            Commodity commodity = new Commodity(commoditylist.get(i).getComId(),commoditylist.get(i).getDuo1(),redDepotNo);
            //选择的收货仓库没有该商品 则新增一条数据 库存数为退货数
            int fh=returnCommodityManageDaoImpl.updateWoreHouse(commodity);
            if(fh==0){
                //新增数据
                MaxNo maxNo = new MaxNo();
                maxNo.setManName("repertoryson");
                String puMaxNo = commandMethod.getPuMaxNo(maxNo);
                maxNo.setManSort(puMaxNo);
                RepertorySon repertorySon = new RepertorySon(puMaxNo,commoditylist.get(i).getComId(),commoditylist.get(i).getComName(),Integer.parseInt(commoditylist.get(i).getDuo1())
                ,redDepotNo,"退货新增库存信息");
                int fh1=returnCommodityManageDaoImpl.insertWoreHouse(repertorySon);
                commandMethod.updateMax(maxNo);
            }
            count++;
        }
        if(count==commoditylist.size()){
            return 1;
        }
        return 0;
    }

    /**
     * 更新可退货数量
     * @param commoditylist
     * @param oddNum1
     * @return
     */
    @Override
    public int updateCanReturnNum(List<Commodity> commoditylist, String oddNum1) {
        int fh=0;
        for(int i=0;i<commoditylist.size();i++){
            ReceiptsDetailed receiptsDetailed = new ReceiptsDetailed(commoditylist.get(i).getComId(),Integer.parseInt(commoditylist.get(i).getDuo1()),oddNum1);
            fh=returnCommodityManageDaoImpl.updateCanReturnNum(receiptsDetailed);
        }
        return 0;
    }


}
