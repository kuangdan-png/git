package com.medicine.service.inter;

import com.medicine.pojo.*;

import java.util.List;

/**
 * @Auther: 郭念
 * @Date: 2019-12-02 16:06
 * @Description: 采购退货查询业务逻辑接口类
 */
public interface StockWithGoodsReturnServiceInter {
    /**
     * 1、采购进退货查询
     * @return
     */
    List<Receipts> StockAndGoodsReturnSearch(Receipts receipts);

    /**
     * 2、分页查询总条数
     * @return
     */
    int SearchTotalRow(Receipts receipts);

    /**
     * 3、查询单据详细信息
     * @return
     */
    List<ReceiptsDetailed> SearchReceiptsInfo();

    /**
     * 4、根据单号查询单据详细信息
     * @param receipts
     * @return
     */
    List<ReceiptsDetailed> SearchReceiptsInfobyRecNo(Receipts receipts);

    /**
     * 5、第一次查询采购退货表格信息【无数据】
     * @return
     */
    List<ReceiptsDetailed> SearchPurchaseReturn();

    /**
     * 6、第二次根据整单退货中的单号查询采购退货表格信息
     * @param receipts
     * @return
     */
    List<ReceiptsDetailed> SearchPurchaseReturnByRecNo(Receipts receipts);

    /**
     * 7、动态获取供货商下拉框
     * @return
     */
    public List<Supplier> supplierListSearch();

    /**
     * 8、动态获取仓库名称下拉框
     * @return
     */
    public List<Warehouse> warehouseListSearch();

}