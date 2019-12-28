package com.medicine.dao.inter;

import com.medicine.pojo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ZRY
 * @Date: 2019-12-02 11:17
 * @Description:
 * 仓库管理数据访问接口
 */
@Repository("wareHouseManagerDaoImpl")
public interface WareHouseManagerDaoInter {
    /**
     * 药品信息的过期查询
     * @param repertorySon
     * @return
     */
    List<RepertorySon> searchStaleDated(RepertorySon repertorySon);

    /**
     * 药品的数量
     * @param repertorySon
     * @return
     */
    int searchTotalRows(RepertorySon repertorySon);

    /**
     * 查询最大编号刘涵写
     * @param maxNo
     * @return
     */
    MaxNo searchMaxNo(MaxNo maxNo);

    /**
     * 查询所有的仓库信息
     * @return
     */
    List<Warehouse> searchWareHourseInfo();

    /**
     * 查询库存数量为0的药品数量
     * @return
     */
    int searchWarehouseNumIsZeroTotalRows();

    /**
     * 查询库存数量为0的药品
     * @param repertorySon
     * @return
     */
    List<Commodity> searchWarehouseNumIsZero(RepertorySon repertorySon);

    /**
     * 根据商品编号查询进货和销售明细的药品数量
     * @param receiptsDetailed
     * @return
     */
    int searchPurchaseAndSalesDetailsTotalRows(ReceiptsDetailed receiptsDetailed);
    /**
     * 根据商品编号查询进货和销售明细的药品
     * @param receiptsDetailed
     * @return
     */
    List<Receipts> searchPurchaseAndSalesDetails(ReceiptsDetailed receiptsDetailed);
}
