package com.medicine.dao.inter;


import com.medicine.pojo.Commodity;
import com.medicine.pojo.RepertorySon;
import com.medicine.pojo.Warehouse;

import java.util.List;

/**
 * @Auther: 匡丹
 * @Date: 2019-11-27 14:29
 * @Description:
 */
public interface AllocationTableDaoInter {
    /**
     * 查商品信息集合
     * @return
     */
    List<Commodity> searchAllocationTableList(Commodity commodity);

    /**
     * 库存信息
     * @param warehouse
     * @return
     */
    List<Warehouse> searchWareHourseInfo(Warehouse warehouse);

    /**
     * 查询库存为0的商品
     * @param commodity
     * @return
     */
    int searchAllocationTableListSize(Commodity commodity);
}

