package com.medicine.handler;

import com.medicine.pojo.*;
import com.medicine.service.inter.StockWithGoodsReturnServiceInter;
import com.medicine.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 郭念
 * @Date: 2019-12-02 16:12
 * @Description: 采购退货查询Handler类
 */
@Controller
@RequestMapping(value = "/GoodsReturnSearch")
public class StockWithGoodsReturnHandler {
    @Resource(name = "stockWithGoodsReturnServiceImpl")
    //1、依赖于业务逻辑接口引用
    private StockWithGoodsReturnServiceInter stockWithGoodsReturnServiceImpl;
    //2、提供setter方法注入
    public void setStockWithGoodsReturnServiceImpl(StockWithGoodsReturnServiceInter stockWithGoodsReturnServiceImpl) {
        this.stockWithGoodsReturnServiceImpl = stockWithGoodsReturnServiceImpl;
    }
    /**
     * 1、采购进退货查询
     * @return
     */
    @RequestMapping(value = "/StockAndGoodsReturnSearch.action")
    public @ResponseBody
    ResultMap<List<Receipts>> StockAndGoodsReturnSearch(Receipts receipts){
        System.out.println(" invoke StockAndGoodsReturnSearch method ");
        //设置页面分页初始值从第一页开始
        receipts.setPage((receipts.getPage()-1)*receipts.getLimit());
        //调用业务逻辑实现类的方法
        List<Receipts> receiptsDetailedList = stockWithGoodsReturnServiceImpl.StockAndGoodsReturnSearch(receipts);
        System.out.println(">>>>>>>>>>>>>>>>>>>>> limit >>>>>>>>>>>>>>>>>>>>>>");
        System.err.println(receiptsDetailedList.size());
        //调用分页计算总页数的方法
        int row = stockWithGoodsReturnServiceImpl.SearchTotalRow(receipts);
        System.out.println(">>>>>>>>>>>>>>>>>>>>> limit >>>>>>>>>>>>>>>>>>>>>>");
        //循环遍历
        for(Receipts receiptsDetailed : receiptsDetailedList){
            System.err.println(">>>>>>>>>>>>>>"+receiptsDetailed);
        }
        ResultMap<List<Receipts>> resultMap = new ResultMap<List<Receipts>>("", receiptsDetailedList, 0, row);
        return resultMap;
    }

    /**
     * 3、查询单据详细信息
     * @return
     */
    @RequestMapping(value = "/SearchReceiptsInfo.action")
    public @ResponseBody ResultMap<List<ReceiptsDetailed>> SearchReceiptsInfo(){
        System.out.println(" invoke SearchReceiptsInfo method ");
        //调用业务逻辑实现类的方法
        List<ReceiptsDetailed> receiptsDetaileds =stockWithGoodsReturnServiceImpl.SearchReceiptsInfo();
        //循环遍历
        for(ReceiptsDetailed receiptsDetailed:receiptsDetaileds){
            System.out.println(receiptsDetailed);
        }
        ResultMap<List<ReceiptsDetailed>> resultMap =new ResultMap<List<ReceiptsDetailed>>("",receiptsDetaileds,0,receiptsDetaileds.size());
        return resultMap;
    }

    /**
     * 4、根据单号查询单据详细信息
     * @param receipts
     * @return
     */
    @RequestMapping(value = "/SearchReceiptsInfobyRecNo.action")
    public @ResponseBody ResultMap<List<ReceiptsDetailed>> SearchReceiptsInfobyRecNo(Receipts receipts){
        System.out.println(" invoke SearchReceiptsInfobyRecNo method ");
        //调用业务逻辑实现类的方法
        List<ReceiptsDetailed> receiptsDetaileds =stockWithGoodsReturnServiceImpl.SearchReceiptsInfobyRecNo(receipts);
        for(ReceiptsDetailed receiptsDetailed:receiptsDetaileds){
            System.out.println(receiptsDetailed);
        }
        ResultMap<List<ReceiptsDetailed>> resultMap =new ResultMap<List<ReceiptsDetailed>>("",receiptsDetaileds,0,receiptsDetaileds.size());
         return resultMap;
    }

    /**
     * 5、第一次查询采购退货表格信息【无数据】
     * @return
     */
    @RequestMapping(value = "/SearchPurchaseReturn.action")
    public @ResponseBody ResultMap<List<ReceiptsDetailed>> SearchPurchaseReturn(){
        System.out.println(" invoke SearchPurchaseReturn method ");
        //调用业务逻辑实现类的方法
        List<ReceiptsDetailed> receiptsDetaileds =stockWithGoodsReturnServiceImpl.SearchPurchaseReturn();
        for(ReceiptsDetailed receiptsDetailed:receiptsDetaileds){
            System.out.println(receiptsDetailed);
        }
        ResultMap<List<ReceiptsDetailed>> resultMap =new ResultMap<List<ReceiptsDetailed>>("",receiptsDetaileds,0,receiptsDetaileds.size());
        return resultMap;
    }

    /**
     * 6、第二次根据整单退货中的单号查询采购退货表格信息
     * @param receipts
     * @return
     */
    @RequestMapping(value = "/SearchPurchaseReturnByRecNo.action")
    public @ResponseBody ResultMap<List<ReceiptsDetailed>> SearchPurchaseReturnByRecNo(Receipts receipts){
        System.out.println(" invoke SearchPurchaseReturnByRecNo method ");
        //调用业务逻辑实现类的方法
        List<ReceiptsDetailed> receiptsDetaileds =stockWithGoodsReturnServiceImpl.SearchPurchaseReturnByRecNo(receipts);
        for(ReceiptsDetailed receiptsDetailed:receiptsDetaileds){
            System.out.println(receiptsDetailed);
        }
        ResultMap<List<ReceiptsDetailed>> resultMap =new ResultMap<List<ReceiptsDetailed>>("",receiptsDetaileds,0,receiptsDetaileds.size());
        return resultMap;
    }

    /**
     * 7、动态获取供货商下拉框
     * @return
     */
    @RequestMapping(value = "/supplierListSearch.action")
    public @ResponseBody List<Supplier> supplierListSearch(){
        System.out.println(" invoke supplierListSearch method ");
        //3、调用业务逻辑实现类的方法
        List<Supplier> supplierList = stockWithGoodsReturnServiceImpl.supplierListSearch();
        for(Supplier supplier : supplierList){
            System.out.println(supplier);
        }
        /*ResultMap<List<Supplier>> resultMap = new ResultMap<List<Supplier>>("",supplierList,0,supplierList.size());*/
        return supplierList;
    }

    /**
     * 8、动态获取仓库名称下拉框
     * @return
     */
    @RequestMapping(value = "/warehouseListSearch.action")
    public @ResponseBody List<Warehouse> warehouseListSearch(){
        System.out.println(" invoke supplierListSearch method ");
        //3、调用业务逻辑实现类的方法
        List<Warehouse> warehouseList = stockWithGoodsReturnServiceImpl.warehouseListSearch();
        for(Warehouse warehouse : warehouseList){
            System.out.println(warehouse);
        }
        return warehouseList;
    }
}
