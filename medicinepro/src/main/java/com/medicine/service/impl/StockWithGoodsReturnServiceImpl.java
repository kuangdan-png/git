package com.medicine.service.impl;

import com.medicine.dao.inter.StockWithGoodsReturnDaoInter;
import com.medicine.pojo.*;
import com.medicine.service.inter.StockWithGoodsReturnServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 郭念
 * @Date: 2019-12-02 16:07
 * @Description: 采购退货查询业务逻辑实现类
 */
@Service(value = "stockWithGoodsReturnServiceImpl")
public class StockWithGoodsReturnServiceImpl implements StockWithGoodsReturnServiceInter {
    @Resource(name = "stockWithGoodsReturnDaoImpl")
    //1、依赖于数据访问接口引用
    private StockWithGoodsReturnDaoInter stockWithGoodsReturnDaoImpl;
    //2、提供setter方法注入
    public void setStockWithGoodsReturnDaoImpl(StockWithGoodsReturnDaoInter stockWithGoodsReturnDaoImpl) {
        this.stockWithGoodsReturnDaoImpl = stockWithGoodsReturnDaoImpl;
    }

    /**
     * 1、采购进退货查询
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<Receipts> StockAndGoodsReturnSearch(Receipts receipts) {
        return stockWithGoodsReturnDaoImpl.StockAndGoodsReturnSearch(receipts);
    }

    /**
     * 2、分页查询总条数
     * @return
     */
    @Override
    public int SearchTotalRow(Receipts receipts) {
        return stockWithGoodsReturnDaoImpl.SearchTotalRow(receipts);
    }

    /**
     * 2、查询单据详细信息
     * @return
     */
    @Override
    public List<ReceiptsDetailed> SearchReceiptsInfo() {
        return stockWithGoodsReturnDaoImpl.SearchReceiptsInfo();
    }

    /**
     * 3、根据单号查询单据详细信息
     * @param receipts
     * @return
     */
    @Override
    public List<ReceiptsDetailed> SearchReceiptsInfobyRecNo(Receipts receipts) {
        return stockWithGoodsReturnDaoImpl.SearchReceiptsInfobyRecNo(receipts);
    }

    /**
     * 5、第一次查询采购退货表格信息【无数据】
     * @return
     */
    @Override
    public List<ReceiptsDetailed> SearchPurchaseReturn() {
        return stockWithGoodsReturnDaoImpl.SearchPurchaseReturn();
    }

    /**
     * 6、第二次根据整单退货中的单号查询采购退货表格信息
     * @param receipts
     * @return
     */
    @Override
    public List<ReceiptsDetailed> SearchPurchaseReturnByRecNo(Receipts receipts) {
        return stockWithGoodsReturnDaoImpl.SearchPurchaseReturnByRecNo(receipts);
    }

    /**
     * 7、动态获取供货商下拉框
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<Supplier> supplierListSearch() {
        return stockWithGoodsReturnDaoImpl.supplierListSearch();
    }

    /**
     * 8、动态获取仓库名称下拉框
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<Warehouse> warehouseListSearch() {
        return stockWithGoodsReturnDaoImpl.warehouseListSearch();
    }
}
