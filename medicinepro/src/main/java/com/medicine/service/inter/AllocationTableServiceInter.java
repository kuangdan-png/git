package com.medicine.service.inter;

import com.medicine.pojo.Commodity;
import com.medicine.pojo.ReceiptsDetailed;

import java.util.List;
import com.medicine.pojo.RepertorySon;
import com.medicine.pojo.Warehouse;
import com.medicine.util.Page;

/**
 * @Auther: 匡丹
 * @Date: 2019-11-27 14:44
 * @Description:
 */
public interface AllocationTableServiceInter {
    /**
     * 查商品信息集合
     * @return
     */
    List<Commodity> searchAllocationTableList(Commodity commodity);

    /**
     * 库存
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
