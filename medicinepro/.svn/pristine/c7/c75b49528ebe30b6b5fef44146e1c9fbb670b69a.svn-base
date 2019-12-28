package com.medicine.service.inter;

import com.medicine.pojo.*;

import java.util.List;

/**
 * @Author: ZRY
 * @Date: 2019-12-02 11:04
 * @Description:
 * 仓库管理业务逻辑接口类
 */
public interface WareHouseManagerServiceInter {

    /**
     * 查询过期药品数量
     * @param repertorySon
     * @return int
     */
    int searchTotalRows(RepertorySon repertorySon);

    /**
     * 查询药品过期数据
     * @param repertorySon
     * @return List<RepertorySon>
     */
    List<RepertorySon> searchStaleDted(RepertorySon repertorySon);

    /**
     * 查询仓库信息
     * @return List<Warehouse>
     */
    List<Warehouse> searchWareHourseInfo();

    /**
     * 生成最大编号
     * @param maxNo
     * @return String
     */
    String getMaxNo(MaxNo maxNo);

    /**
     * 查询库存为零的药品数量
     * @return int
     */
    int searchWarehouseNumIsZeroTotalRows();

    /**
     * 查询库存为零的药品
     * @param repertorySon
     * @return List<Commodity>
     */
    List<Commodity> searchWarehouseNumIsZero(RepertorySon repertorySon);

    /**
     * 根据编号、开始日期、结束日期，查询进货销售明细的数量
     * @param receiptsDetailed
     * @return
     */
    int searchPurchaseAndSalesDetailsTotalRows(ReceiptsDetailed receiptsDetailed);

    /**
     * 根据编号、开始日期、结束日期，查询进货销售明细的数量
     * @param  receiptsDetailed
     * @return List<Receipts>
     */
    List<Receipts> searchPurchaseAndSalesDetails(ReceiptsDetailed receiptsDetailed);

}
