package com.medicine.service.impl;

import com.medicine.dao.inter.MerchBillReturnManagerDaoInter;
import com.medicine.pojo.*;
import com.medicine.service.inter.MerchBillReturnManagerServiceInter;
import com.medicine.util.CommandMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 郭念
 * @Date: 2019-11-27 11:29
 * @Description: 采购退货中【老商品添加】的商品清单的Service实现类
 */
@Service(value = "merchBillReturnManagerServiceImpl")
public class MerchBillReturnManagerServiceImpl implements MerchBillReturnManagerServiceInter {
    //1、依赖数据访问的接口引用指向实现类
    @Resource(name = "merchBillReturnManagerDaoImpl")
    private MerchBillReturnManagerDaoInter merchBillManagerDaoImpl;
    //2、提供setter方式注入
    public void setMerchBillManagerDaoImpl(MerchBillReturnManagerDaoInter merchBillManagerDaoImpl) {
        this.merchBillManagerDaoImpl = merchBillManagerDaoImpl;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 1、查询【采购进货中的老商品添加】所有的商品清单
     * @return List<RepertorySon> 返回集合
     */
    @Transactional(readOnly = true)
    @Override
    public List<RepertorySon> searchAllMerchBillReturn(Receipts val) {
        String recNo = val.getRecNo();
        boolean numeric = commandMethod.isNumeric(recNo);
        if(!numeric){
            val.setRecOdd(recNo);
            val.setRecNo(null);
        }
        return merchBillManagerDaoImpl.searchAllMerchBillReturn(val);
    }

    /**
     * 2、查询所有商品信息
     * @return
     */
    @Override
    public List<Commodity> searchCommodityAllService() {
        List<Commodity> commodityList=merchBillManagerDaoImpl.searchCommodityAllDao();
        return commodityList;
    }

    /**
     * 3、根据商品类别编号查询商品信息
     * @param commodityzId
     * @return
     */
    @Override
    public List<RepertorySon> searchCommodityForTypeService(String commodityzId) {
        List<RepertorySon> repertorysonList=merchBillManagerDaoImpl.searchCommodityForTypeAllDao(commodityzId);
        return repertorysonList;
    }

    /**
     * 4、查询商品类别父类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityType() {
        List<Category> categoryList=merchBillManagerDaoImpl.searchCommodityTypeDao();
        return categoryList;
    }
    /**
     * 5、查询商品类别子类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodity(String catId) {
        List<Category> categoryList=merchBillManagerDaoImpl.searchCommodityDao(catId);
        return categoryList;
    }

    /**
     * 6、对单据表进行新增
     * @param receipts 单据主表信息
     * @param data     单据明细数据
     * @return int 影响行数
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public int addReceiptsDetailed(Receipts receipts, List<RepertorySon> data) {
        //声明查询的最大编号的条件
        MaxNo maxNo = new MaxNo("receipts", 0);
        String puMaxNo1 = commandMethod.getPuMaxNo(maxNo);
        maxNo.setManSort(puMaxNo1);
        //单据主表的单号
        MaxNo maxNo1 = new MaxNo("receipts", receipts.getRecOdd(),7);

        //为receipts赋初始值
        receipts.setRecNo(puMaxNo1);
        receipts.setRecDocumentTypes("RN00005");
        receipts.setRecTiaoNumber(data.size());

        //获得入库的编号
        String redPutNo = receipts.getRedPutNo();
        int number = 0;

        //循环累加number
        for (RepertorySon repertorySon : data) {
            System.err.println(""+repertorySon.getDuo1());
            number += Integer.parseInt(repertorySon.getDuo1());
        }
        receipts.setRecTotalNumber(number);

        //用于监听是否新增完全
        int repertorySonRows = 0;
        //1.新增单据主表信息
        int receiptsRows = merchBillManagerDaoImpl.insertReceiptsInfo(receipts);

        //2.新增单据明细信息
        //循环data
        for (RepertorySon repertorySon : data) {//每次循环
            System.out.println("");
            System.out.println("" + repertorySon);
            System.out.println("");
            //2.1 声明变量，并给与条件
            MaxNo maxNo2 = new MaxNo("receipts_detailed", 0);

            //2.2 得到单据明细表的编号
            String puMaxNo = commandMethod.getPuMaxNo(maxNo2);
            //为其赋值
            maxNo2.setManSort(puMaxNo);

            //2.3 声明变量，并给与条件
            MaxNo maxNo3 = new MaxNo("receipts_detailed",5);

            //2.4 得到单据明细表的单号
            String puMaxNo2 = commandMethod.getOddMaxNo(maxNo3);
            //为其赋值
            maxNo3.setManSort(puMaxNo2);

            //2.5 设置RepId 为null防止与searchCommidyInfo中的参数冲突
            repertorySon.setRepId(null);

            Commodity commodity = repertorySon.getCommodity();
            //编号，单号，商品编号，商品名称，商品单位，产品规格，批准文号，单价，数量，生产厂商，单据主表的单号
           ReceiptsDetailed receiptsDetailed = new ReceiptsDetailed(
                   puMaxNo,puMaxNo2,commodity.getComId(),commodity.getComName(),
                   commodity.getComUnit(),commodity.getComProduct(),commodity.getComApproval(),
                   repertorySon.getReqPrice(),Integer.parseInt(repertorySon.getDuo1()),commodity.getManufacturer().getManId(),puMaxNo1
           );

            //执行新增单据明细信息
            int rows = merchBillManagerDaoImpl.insertReceiptsDetailedInfo(receiptsDetailed);
            System.out.println("row = "+ rows);
            //赋值仓库的编号
            receiptsDetailed.setDuo1(redPutNo);

            //2.修改单据明细表的最大编号
            int updataRepertorySonRows = commandMethod.updateMax(maxNo2);

            //2.修改单据明细表的最大单号
            int updataReceiptsDetailedOddRows = commandMethod.updateMax(maxNo3);

            //修改出库库存明细表的信息
            int repertorySonRow = merchBillManagerDaoImpl.updateRepertorySonInInfo(receiptsDetailed);
            repertorySonRows++;
        }
        //当监听到repertorySonRows 值等于 data.size()时，新增成功
        if (repertorySonRows == data.size()) {
            //修改最大编号中存的值
            //1.修改单据表的最大编号
            int i = commandMethod.updateMax(maxNo);

            //3.修改单据表的单号的最大编号
            int i2 = commandMethod.updateMax(maxNo1);
            if (0 < i && 0 < i2) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * 6、对单据表进行新增
     * @param receipts 单据主表信息
     * @param data     单据明细数据
     * @return int 影响行数
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public int addReceiptsDetailedReturn(Receipts receipts, List<ReceiptsDetailed> data) {
        //声明查询的最大编号的条件
        MaxNo maxNo = new MaxNo("receipts", 0);
        String puMaxNo1 = commandMethod.getPuMaxNo(maxNo);
        maxNo.setManSort(puMaxNo1);
        //单据主表的单号
        MaxNo maxNo1 = new MaxNo("receipts", receipts.getRecOdd(),7);

        //为receipts赋初始值
        receipts.setRecNo(puMaxNo1);
        receipts.setRecDocumentTypes("CT00001");
        receipts.setRecTiaoNumber(data.size());

        //获得入库的编号
        String redPutNo = receipts.getRedPutNo();
        int number = 0;

        //循环累加number
        for (ReceiptsDetailed receiptsDetailed : data) {
            System.err.println(""+receiptsDetailed.getRedCount());
            number += receiptsDetailed.getRedCount();
        }
        receipts.setRecTotalNumber(number);

        //用于监听是否新增完全
        int repertorySonRows = 0;
        //1.新增单据主表信息
        int receiptsRows = merchBillManagerDaoImpl.insertReceiptsInfo(receipts);

        //2.新增单据明细信息
        //循环data
        for (ReceiptsDetailed receiptsDetailed : data) {//每次循环
            System.out.println("");
            System.out.println("" + receiptsDetailed);
            System.out.println("");
            //2.1 声明变量，并给与条件
            MaxNo maxNo2 = new MaxNo("receipts_detailed", 0);

            //2.2 得到单据明细表的编号
            String puMaxNo = commandMethod.getPuMaxNo(maxNo2);
            //为其赋值
            maxNo2.setManSort(puMaxNo);

            //2.3 声明变量，并给与条件
            MaxNo maxNo3 = new MaxNo("receipts_detailed",5);

            //2.4 得到单据明细表的单号
            String puMaxNo2 = commandMethod.getOddMaxNo(maxNo3);
            //为其赋值
            maxNo3.setManSort(puMaxNo2);

            //2.5 设置RepId 为null防止与searchCommidyInfo中的参数冲突
            //receiptsDetailed.setRepId(null);

            Commodity commodity = receiptsDetailed.getCommodity();


            //编号，单号，商品编号，商品名称，商品单位，产品规格，批准文号，单价，数量，生产厂商，单据主表的单号
            receiptsDetailed.setRedNo(puMaxNo);
            receiptsDetailed.setRedOdd(puMaxNo2);
            receiptsDetailed.setRedRecNo(receipts.getRecOdd());

            //执行新增单据明细信息
            int rows = merchBillManagerDaoImpl.insertReceiptsDetailedInfo(receiptsDetailed);
            System.out.println("row = "+ rows);
            //赋值仓库的编号
            receiptsDetailed.setDuo1(redPutNo);

            //2.修改单据明细表的最大编号
            int updataRepertorySonRows = commandMethod.updateMax(maxNo2);

            //2.修改单据明细表的最大单号
            int updataReceiptsDetailedOddRows = commandMethod.updateMax(maxNo3);

            //修改出库库存明细表的信息
            int repertorySonRow = merchBillManagerDaoImpl.updateRepertorySonInInfo(receiptsDetailed);
            repertorySonRows++;

        }
        //当监听到repertorySonRows 值等于 data.size()时，新增成功
        if (repertorySonRows == data.size()) {
            //修改最大编号中存的值
            //1.修改单据表的最大编号
            int i = commandMethod.updateMax(maxNo);

            //3.修改单据表的单号的最大编号
            int i2 = commandMethod.updateMax(maxNo1);
            if (0 < i && 0 < i2) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
