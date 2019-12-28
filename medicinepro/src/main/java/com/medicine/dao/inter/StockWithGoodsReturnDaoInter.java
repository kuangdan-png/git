package com.medicine.dao.inter;

import com.medicine.pojo.*;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Auther: 郭念
 * @Date: 2019-12-02 14:58
 * @Description: 采购退货查询数据访问接口类
 */
@Repository(value = "stockWithGoodsReturnDaoInter")
public interface StockWithGoodsReturnDaoInter {
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
