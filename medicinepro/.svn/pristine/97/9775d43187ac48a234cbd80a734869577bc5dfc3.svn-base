package com.medicine.service.impl;

import com.medicine.dao.inter.SaleCommodityManageDaoInter;
import com.medicine.pojo.*;
import com.medicine.service.inter.SaleCommodityManageServiceInter;
import com.medicine.util.CommandMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Auther:龚成
 * DATE: 2019-11-27 10:29:41
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
@Service("saleCommodityManageServiceImpl")
public class SaleCommodityManageServiceImpl implements SaleCommodityManageServiceInter {
    //依赖注入数据访问层
    @Resource(name = "saleCommodityManageDaoImpl")
    private SaleCommodityManageDaoInter SaleCommodityManageDaoImpl;
    public void setSaleCommodityManageDaoImpl(SaleCommodityManageDaoInter saleCommodityManageDaoImpl) {
        SaleCommodityManageDaoImpl = saleCommodityManageDaoImpl;
    }
    //依赖注入单号查询类
    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;
    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    //销售单号
    private String redOdd="";
    //仓库主键
    private String recWareNo="";
    //备注
    private String redComment="";
    //单据表主键
    private String recNo="";
    //客户主键
    private String cliID="";

    //实收金额
    private double duo4=0.0;
    /**
     * 查询代售商品
     * @return
     * @param pagegation
     */
    @Transactional(readOnly = true)
    @Override
    //调用数据访问层查询销售商品方法方法
    public List<Commodity> saleCommodityInfo(Pagegation pagegation) {
        return SaleCommodityManageDaoImpl.saleCommodityInfo(pagegation);
    }
    /**
     * /**
     * 根据获取的商品编号或者名称与仓库ID模糊查询
     * @return
     * @param val
     * @param warID
     */
    @Override
    public List<Commodity> commodityByNameOrId(String val, String warID) {
        return SaleCommodityManageDaoImpl.commodityByNameOrId(val,warID);
    }

    /**
     * 查询商品类别父类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityType() {
        List<Category> categoryList=SaleCommodityManageDaoImpl.searchCommodityTypeDao();
        return categoryList;
    }
    /**
     * 查询商品类别子类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodity(String catId) {
        List<Category> categoryList=SaleCommodityManageDaoImpl.searchCommodityDao(catId);
        return categoryList;
    }
    /**
     * 根据页面传输的条件查询类别
     * @param seniorSeclct
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityseniorSeclct(String seniorSeclct) {
        List<Category> categoryList=SaleCommodityManageDaoImpl.searchCommodityseniorSeclct(seniorSeclct);
        return categoryList;
    }
    /**
     * 根据点击获取类型ID查询商品信息
     * @param comTypeId
     * @param warID
     * @return
     */
    @Override
    public List<Commodity> infoByClick(String comTypeId, String warID) {
        return SaleCommodityManageDaoImpl.infoByClick(comTypeId,warID);
    }

    /**
     * 客户名称下拉列表
     * @return
     */
    @Override
    public List<Client> clientNameList() {
        List<Client> clientList=SaleCommodityManageDaoImpl.clientNameList();
        return clientList;
    }

    /**
     * 可用仓库信息
     * @return
     */
    @Override
    public List<Warehouse> allwarHName() {
        List<Warehouse> warehouse=SaleCommodityManageDaoImpl.allwarHName();
        return warehouse;
    }
    /**
     * 查询经办人下拉列表
     * @return
     */
    @Override
    public List<Employees> allEmployessName() {
        return SaleCommodityManageDaoImpl.allEmployessName();
    }

    /**
     * 新增销售单据表
     * @param receipts
     * @return
     */
    @Override
    @Transactional(propagation=REQUIRED,readOnly = false)
    public int insertFormInfo(Receipts receipts) {
        //获取普通主键ID
        MaxNo maxNo =new MaxNo("receipts",0);
        String recNo1=commandMethod.getPuMaxNo(maxNo);
        receipts.setRecDocumentTypes("RN00004");
        receipts.setRecNo(recNo1);
        //销售单号(明细表用)
        redOdd=receipts.getRecOdd();
        //仓库ID(明细表用)
        recWareNo=receipts.getRecWareNo();
        //备注(明细表用)
        redComment=receipts.getRecRemark();
        //销售单据表普通主键ID(明细表用)
        recNo=receipts.getRecNo();
        //客户ID(明细表用)
        cliID=receipts.getDuo2();
        //收收金额 (明细表用)
        duo4=Double.parseDouble(receipts.getDuo4());
        try {
            //将页面日期转换为date
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(String.valueOf(receipts.getRecDateSale()));
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date);
            Calendar now = Calendar.getInstance();
            //将时分秒,毫秒域清零 将当前系统时分秒拼接
            cal1.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY));
            cal1.set(Calendar.MINUTE, now.get(Calendar.MINUTE));
            cal1.set(Calendar.SECOND, now.get(Calendar.SECOND));
            //set为销售日期赋值
            receipts.setRecDateSale(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal1.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //执行新增方法
        int fh=SaleCommodityManageDaoImpl.insertFormInfo(receipts);
        //更改销售单据最大单据号
        MaxNo maxNo2=new MaxNo("receipts",receipts.getRecOdd(),6);
        int fh2=commandMethod.updateMax(maxNo2);
        return fh;
    }

    /**
     * 新增销售明细表
     * @param commoditylist
     * @return
     */
    @Override
    @Transactional(propagation=REQUIRED,readOnly = false)
    public int insertTableInfo(List<Commodity> commoditylist) {
        int fh=0;
        for (int i=0;i<commoditylist.size();i++){
            //获取销售单据明细表 普通主键ID
            MaxNo maxNo =new MaxNo("receipts_detailed",0);
            String redNo=commandMethod.getPuMaxNo(maxNo);
            //获取销售商品对象
            Commodity commodity =commoditylist.get(i);
            //创建明细表对象 构造方法赋值新增数据 （redOdd——与销售单据主表单据号对应）
            ReceiptsDetailed receiptsDetailed1=new ReceiptsDetailed(redNo,redOdd,commodity.getComId(),
                   commodity.getComName(),commodity.getComUnit(), commodity.getComProduct(),
                   commodity.getComApproval(),commodity.getComPrice(),Integer.parseInt(commodity.getDuo1()),
                    recWareNo,redComment,commodity.getComTypeId(),
                    recNo,cliID,Integer.parseInt(commodity.getDuo1()),
                    duo4);
            //执行新增
           fh=SaleCommodityManageDaoImpl.insertTableInfo(receiptsDetailed1);
            //更改销售单据明细表 普通主键ID
            MaxNo maxNo1=new MaxNo("receipts_detailed",receiptsDetailed1.getRedNo(),0);
            int fh1=commandMethod.updateMax(maxNo1);
        }
        return fh;
    }

    /**
     * 根据商品ID与仓库ID查询库存
     * @param comId
     * @param warID
     * @return
     */
    @Override
    public int ifNumBigRepertory(String comId, String warID) {
        return SaleCommodityManageDaoImpl.ifNumBigRepertory(comId,warID);
    }

    /**
     * 根据销售单据的商品ID代入相应仓库表更新库存
     * @param commoditylist
     * @param redDepotNo
     * @return
     */
    @Override
    @Transactional(propagation=REQUIRED,readOnly = false)
    public int updateWoreHouse(List<Commodity> commoditylist, String redDepotNo) {
        int fh=0;
        for(int i=0;i<commoditylist.size();i++){
            //根据仓库ID 销售数量 执行修改
            Commodity commodity = new Commodity(commoditylist.get(i).getComId(),commoditylist.get(i).getDuo1(),redDepotNo);
            fh=SaleCommodityManageDaoImpl.updateWoreHouse(commodity);
        }
        return fh;
    }

}
