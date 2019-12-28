package com.medicine.service.impl;

import com.medicine.dao.inter.AllocationManagerDaoInter;
import com.medicine.exception.WareHouseStockException;
import com.medicine.pojo.*;
import com.medicine.service.inter.AllocationManagerServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.Page;
import com.medicine.util.ResultMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-07 15:26
 * @Description:库存调拨
 */
@Service("allocationManagerServiceImpl")
public class AllocationManagerServiceImpl implements AllocationManagerServiceInter {
    @Resource(name = "allocationManagerDaoImpl")
    private AllocationManagerDaoInter allocationManagerDaoInter = null;

    public void setAllocationManagerDaoInter(AllocationManagerDaoInter allocationManagerDaoInter) {
        this.allocationManagerDaoInter = allocationManagerDaoInter;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 查询商品清单的信息
     *
     * @param repertorySon
     * @param page
     * @return List<RepertorySon>
     */
    @Override
    public List<RepertorySon> searchCommidyInfo(RepertorySon repertorySon, Page page) {
        //获得存储商品编号和商品信息的变量，并存储至 repComId
        String repComId = repertorySon.getRepComId();

        if (null != repComId && !"".equals(repComId)) {

            //判断是商品名称，还是商品编号
            boolean numeric = commandMethod.isNumeric(repComId);

            if (!numeric) {//不包含数字,是商品名称
                //将存储的位置替换
                repertorySon.setRepProName(repComId);
                repertorySon.setRepComId(null);
            }
        }
        //库存明细表的当前库存和最低库存来，存储当前页，和当前的每页显示多少条
        repertorySon.setReqCurrent((page.getPage() - 1) * page.getlimit());
        repertorySon.setReqLowest(page.getlimit());
        //返回查询的信息
        return allocationManagerDaoInter.searchCommidyInfo(repertorySon);
    }

    /**
     * 查询商品清单的信息总条数
     *
     * @param repertorySon
     * @return int
     */
    @Override
    public int searchCommidyInfoSize(RepertorySon repertorySon) {
        //获得存储商品编号和商品信息的变量，并存储至 repComId
        String repComId = repertorySon.getRepComId();

        if (null != repComId && !"".equals(repComId)) {

            //判断是商品名称，还是商品编号
            boolean numeric = commandMethod.isNumeric(repComId);

            if (!numeric) {//不包含数字,是商品名称
                //将存储的位置替换
                repertorySon.setRepProName(repComId);
                repertorySon.setRepComId(null);
            }
        }
        return allocationManagerDaoInter.searchCommidyInfoSize(repertorySon);
    }

    /**
     * 查询经办人
     *
     * @param employees
     * @return List<Employees>
     */
    @Override
    public List<Employees> searchEmployeesJin(Employees employees) {
        return allocationManagerDaoInter.searchEmployeesJin(employees);
    }

    /**
     * 查询单据主信息
     *
     * @param receipts 条件
     * @return List<Receipts>
     */
    @Override
    public ResultMap<List<Receipts>> searchReceiptsInfo(Receipts receipts) {
        //根据条件查询数据
        List<Receipts> list = allocationManagerDaoInter.searchReceiptsInfo(receipts);
        //根据条件查询数据的总条数
        int rows = allocationManagerDaoInter.searchReceiptsInfoSize(receipts);
        //封装在resultMap
        ResultMap<List<Receipts>> resultMap = new ResultMap<List<Receipts>>("", list, 200, rows);
        //返回
        return resultMap;
    }

    /**
     * 查询单据明细信息
     *
     * @param receipts 条件
     * @return List<RepertorySon>
     */
    @Override
    public ResultMap<List<ReceiptsDetailed>> searchRepertorySonInfo(Receipts receipts) {
        //根据条件查询数据
        List<ReceiptsDetailed> list = allocationManagerDaoInter.searchReceiptsDetailedInfo(receipts);
        //根据条件查询数据的总条数
        int rows = allocationManagerDaoInter.searchReceiptsDetailedInfoSize(receipts);
        //封装在resultMap
        ResultMap<List<ReceiptsDetailed>> resultMap = new ResultMap<List<ReceiptsDetailed>>("", list, 200, rows);
        //返回 resultMap
        return resultMap;
    }

    /**
     * 对单据表进行新增
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
        MaxNo maxNo1 = new MaxNo("receipts", receipts.getRecOdd(), 2);

        //为receipts赋初始值
        receipts.setRecNo(puMaxNo1);
        receipts.setRecDocumentTypes("RN00002");
        receipts.setRecTiaoNumber(data.size());
        //获得入库的编号
        String redPutNo = receipts.getRedPutNo();
        //获得出库的编号
        String redDepotNo = receipts.getRedDepotNo();
        int number = 0;
        //循环累加number
        for (RepertorySon repertorySon : data) {
            number += Integer.parseInt(repertorySon.getDuo1());
        }
        receipts.setRecTotalNumber(number);

        //用于监听是否新增完全
        int repertorySonRows = 0;
        //1.新增单据主表信息
        int receiptsRows = allocationManagerDaoInter.insertReceiptsInfo(receipts);

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
            MaxNo maxNo3 = new MaxNo("receipts_detailed", 1);

            //2.4 得到单据明细表的单号
            String puMaxNo2 = commandMethod.getOddMaxNo(maxNo3);
            //为其赋值
            maxNo3.setManSort(puMaxNo2);

            //2.5 设置RepId 为null防止与searchCommidyInfo中的参数冲突
            repertorySon.setRepId(null);

            Commodity commodity = repertorySon.getCommodity();
            //编号，单号，商品编号，商品名称
            ReceiptsDetailed receiptsDetailed =
                    new ReceiptsDetailed(puMaxNo, puMaxNo2, repertorySon.getRepComId(), repertorySon.getRepProName(),
                            commodity.getComUnit(), commodity.getComProduct(), commodity.getComApproval(),
                            commodity.getComPrice(), Integer.parseInt(repertorySon.getDuo1()),
                            commodity.getComManufact(), puMaxNo1);


            //执行新增单据明细信息
            int rows = allocationManagerDaoInter.insertReceiptsDetailedInfo(receiptsDetailed);

            //赋值仓库的编号
            receiptsDetailed.setDuo1(redPutNo);

            //3.查询仓库中是否有该数据
            String repertorySon1 = allocationManagerDaoInter.searchRepertorySonInfo(receiptsDetailed);

            //2.修改单据明细表的最大编号
            int updataRepertorySonRows = commandMethod.updateMax(maxNo2);

            //2.修改单据明细表的最大单号
            int updataReceiptsDetailedOddRows = commandMethod.updateMax(maxNo3);

            //获得出库的编号
            receiptsDetailed.setDuo3(redDepotNo);

            //获得入库的库存明细表编号
            receiptsDetailed.setDuo2(repertorySon1);

            //修改出库库存明细表的信息
            int repertorySonRowOut = allocationManagerDaoInter.updateRepertorySonOutInfo(receiptsDetailed);

            //判断 repertorySon1 是否为null
            if (null != repertorySon1 && !"".equals(repertorySon1)) {// repertorySon1 不为null，说明存在修改

                //修改入库库存明细表的信息
                int repertorySonRow = allocationManagerDaoInter.updateRepertorySonInInfo(receiptsDetailed);
                // repertorySonRows 累加
                repertorySonRows++;

            } else {// repertorySon1 为null，说明不存在，新增
                MaxNo maxNo4 = new MaxNo();
                maxNo4.setManName("repertoryson");
                String puMaxNo3 = commandMethod.getPuMaxNo(maxNo4);
                maxNo4.setManSort(puMaxNo3);
                //赋值
                repertorySon.setRepId(puMaxNo3);
                repertorySon.setReqWareNo(redPutNo);
                System.out.println("");
                System.out.println(""+repertorySon);
                //新增入库库存信息
                int repertorySonRow = allocationManagerDaoInter.insertRepertorySonInfo(repertorySon);

                //2.修改库存明细表的最大编号
                int updatRepertorySonOddRows = commandMethod.updateMax(maxNo4);

                // repertorySonRows 累加
                repertorySonRows++;

            }
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
