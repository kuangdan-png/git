package com.medicine.service.impl;

import com.medicine.dao.inter.MerchBillManagerDaoInter;
import com.medicine.pojo.*;
import com.medicine.service.inter.MerchBillManagerServiceInter;
import com.medicine.util.CommandMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 周宏伟
 * @Date: 2019-11-27 11:29
 * @Description: 采购进货中【老商品添加】的Service实现类
 */
@Service(value = "merchBillManagerServiceImpl")
public class MerchBillManagerServiceImpl implements MerchBillManagerServiceInter {
    //1、依赖数据访问的接口引用指向实现类
    @Resource(name = "merchBillManagerDaoImpl")
    private MerchBillManagerDaoInter merchBillManagerDaoImpl;
    //2、提供setter方式注入
    public void setMerchBillManagerDaoImpl(MerchBillManagerDaoInter merchBillManagerDaoImpl) {
        this.merchBillManagerDaoImpl = merchBillManagerDaoImpl;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 1、查询【采购进货中的老商品添加】所有的商品清单【根据获取的商品编号或者名称模糊查询】
     * @return List<RepertorySon> 返回集合
     * @param repertorySon
     */
    @Transactional(readOnly = true)
    @Override
    public List<RepertorySon> searchAllMerchBill(RepertorySon repertorySon) {
        //商品编号
        String repComId = repertorySon.getRepComId();
        //检查该字符串是否包含数字
        boolean numeric = commandMethod.isNumeric(repComId);
        if(!numeric){
            //商品名称
            repertorySon.setRepProName(repComId);
            repertorySon.setRepComId(null);
        }
        return merchBillManagerDaoImpl.searchAllMerchBill(repertorySon);
    }

    /**
     * 2、查询商品类别父类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityType() {
        List<Category> categoryList=merchBillManagerDaoImpl.searchCommodityTypeDao();
        return categoryList;
    }
    /**
     * 3、查询商品类别子类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodity(String catId) {
        List<Category> categoryList=merchBillManagerDaoImpl.searchCommodityDao(catId);
        return categoryList;
    }

    /**
     * 4.查询所有的商品
     * @return
     */
    @Override
    public List<Commodity> searchCommodityAllService() {
        List<Commodity> commodityList=merchBillManagerDaoImpl.searchCommodityAllDao();
        return commodityList;
    }

    /**
     * 5.根据商品编号查询商品所属类型
     * @param commodityzId
     * @return
     */
    @Override
    public List<RepertorySon> searchCommodityForTypeService(String commodityzId) {
        List<RepertorySon> repertorySonList=merchBillManagerDaoImpl.searchCommodityForTypeAllDao(commodityzId);
        return repertorySonList;
    }

    /**
     * 6、查询【采购进货中的老商品添加】所有的最近进货
     * @return List<Commodity>返回集合
     */
    @Transactional(readOnly = true)
    @Override
    public List<ReceiptsDetailed> searchAllRecentStock() {
        return merchBillManagerDaoImpl.searchAllRecentStock();
    }

    /**
     * 7、对单据表进行新增
     * @param receipts 单据主表信息
     * @param data     单据明细数据
     * @return int 影响行数
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public int addReceiptsDetailed(Receipts receipts, List<RepertorySon> data) {
        //声明查询的单据主表最大编号的条件
        MaxNo maxNo = new MaxNo("receipts", 0);
        String puMaxNo1 = commandMethod.getPuMaxNo(maxNo);
        //赋值【将最大编号赋值给maxNo】
        maxNo.setManSort(puMaxNo1);

        //单据主表的单号
        MaxNo maxNo1 = new MaxNo("receipts", receipts.getRecOdd(),3);

        //为receipts赋初始值【最大编号、单据类型、条数】
        receipts.setRecNo(puMaxNo1);
        receipts.setRecDocumentTypes("RT00001");
        receipts.setRecTiaoNumber(data.size());

        //获得入库的编号
        String redPutNo = receipts.getRedDepotNo();
        System.err.println(""+redPutNo);
        //声明number
        int number = 0;
        //循环库存表累加number
        for (RepertorySon repertorySon : data) {
            number += Integer.parseInt(repertorySon.getDuo1());
        }
        //总数量
        receipts.setRecTotalNumber(number);

        //用于监听是否新增完全
        int repertorySonRows = 0;
        //1.新增单据主表信息
        int receiptsRows = merchBillManagerDaoImpl.insertReceiptsInfo(receipts);

        //2.新增单据明细信息
        //循环data
        for (RepertorySon repertorySon : data) {//每次循环
            System.out.println("");
            System.err.println("" + repertorySon);
            System.out.println("");
            //2.1 声明变量，并给与单据明细编号条件
            MaxNo maxNo2 = new MaxNo("receipts_detailed", 0);

            //2.2 得到单据明细表的编号
            String puMaxNo = commandMethod.getPuMaxNo(maxNo2);
            //为其赋值【将单号赋值给maxNo2】
            maxNo2.setManSort(puMaxNo);

            //2.3 声明变量，并给与单据明细单号条件
            MaxNo maxNo3 = new MaxNo("receipts_detailed",1);

            //2.4 得到单据明细表的单号
            String puMaxNo2 = commandMethod.getOddMaxNo(maxNo3);
            //为其赋值【将单号赋值给maxNo3】
            maxNo3.setManSort(puMaxNo2);

            //2.5 设置RepId 为null防止与searchCommidyInfo中的参数冲突
            repertorySon.setRepId(null);

            Commodity commodity = repertorySon.getCommodity();

            //编号，单号，商品编号，商品名称，商品单位，产品规格，批准文号，单价，数量，生产厂商，单据主表的单号
            ReceiptsDetailed receiptsDetailed =
                    new ReceiptsDetailed(puMaxNo, puMaxNo2,commodity.getComId(),commodity.getComName(),
                            commodity.getComUnit(),commodity.getComProduct(),commodity.getComApproval(),
                            receipts.getRecDate(),Double.parseDouble(commodity.getDuo5()),Integer.parseInt(repertorySon.getDuo1()),
                            commodity.getManufacturer().getManName(),puMaxNo1);
            System.err.println(""+receiptsDetailed);

            //执行新增单据明细信息
            int rows = merchBillManagerDaoImpl.insertReceiptsDetailedInfo(receiptsDetailed);
            System.out.println("row = "+ rows);
            //赋值仓库的编号
            receiptsDetailed.setDuo1(redPutNo);

            //3.查询仓库中是否有该数据
            String repertorySon1 = merchBillManagerDaoImpl.searchRepertorySonInfo(receiptsDetailed);

            //2.修改单据明细表的最大编号
            int updataRepertorySonRows = commandMethod.updateMax(maxNo2);

            //2.修改单据明细表的最大单号
            int updataReceiptsDetailedOddRows = commandMethod.updateMax(maxNo3);

            //获得入库的库存明细表编号
            receiptsDetailed.setDuo2(repertorySon1);

            //判断 repertorySon1 是否为null
            if (null != repertorySon1 && !"".equals(repertorySon1)) {// repertorySon1 不为null，说明存在修改

                //修改入库库存明细表的信息
                int repertorySonRow = merchBillManagerDaoImpl.updateRepertorySonInInfo(receiptsDetailed);
                repertorySonRows++;

            } else {// repertorySon1 为null，说明不存在，新增
                MaxNo maxNo4 = new MaxNo();
                maxNo4.setManName("repertoryson");
                String puMaxNo3 = commandMethod.getPuMaxNo(maxNo4);
                maxNo4.setManSort(puMaxNo3);
                //赋值仓库、【库存明细表】商品ID、商品名称、库存数、价格
                repertorySon.setRepId(puMaxNo3);
                repertorySon.setReqWareNo(redPutNo);
                repertorySon.setRepComId(repertorySon.getCommodity().getComId());
                repertorySon.setRepProName(repertorySon.getCommodity().getComName());
                repertorySon.setReqCurrent(Integer.parseInt(repertorySon.getDuo1()));
                repertorySon.setReqPrice(repertorySon.getCommodity().getComPrice());
                System.out.println("sdfghk="+repertorySon);
                //新增入库库存信息
                int repertorySonRow = merchBillManagerDaoImpl.insertRepertorySonInfo(repertorySon);
                //2.修改库存明细表的最大编号
                int updatRepertorySonOddRows = commandMethod.updateMax(maxNo4);
                // repertorySonRows 累加
                repertorySonRows++;

            }

        }
        //当监听到repertorySonRows 值等于 data.size()时，新增成功
        if (repertorySonRows == data.size()) {
            //1.修改单据表的最大编号
            int i = commandMethod.updateMax(maxNo);

            //3.修改单据表的单号的最大编号
            int i2 = commandMethod.updateMax(maxNo1);
            //判断i、i2是否大于0
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