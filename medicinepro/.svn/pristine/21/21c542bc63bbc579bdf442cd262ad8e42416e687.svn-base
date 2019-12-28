package com.medicine.service.impl;

import com.medicine.dao.inter.AllocationTableDaoInter;
import com.medicine.pojo.Commodity;
import com.medicine.service.inter.AllocationTableServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;
import com.medicine.pojo.*;

/**
 * @Auther: 匡丹
 * @Date: 2019-11-27 14:35
 * @Description:
 */
@Service("allocationTableServiceImpl")
public class AllocationTableServiceImpl implements AllocationTableServiceInter {
    @Resource(name = "allocationTableDaoImpl")
    private AllocationTableDaoInter allocationTableDaoImpl;

    public void setAllocationTableDaoImpl(AllocationTableDaoInter allocationTableDaoImpl) {
        this.allocationTableDaoImpl = allocationTableDaoImpl;
    }

    /**
     * 查商品信息集合
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<Commodity> searchAllocationTableList(Commodity commodity) {
        commodity.setPage((commodity.getPage() - 1) * commodity.getLimit());
        return allocationTableDaoImpl.searchAllocationTableList(commodity);
    }

    /**
     * 查询仓库信息
     * @return List<Warehouse>
     */
    @Override
    public List<Warehouse> searchWareHourseInfo(Warehouse warehouse) {
        return allocationTableDaoImpl.searchWareHourseInfo(warehouse);
    }

    /**
     * 查询库存为0的商品
     * @param commodity
     * @return
     */
    @Override
    public int searchAllocationTableListSize(Commodity commodity) {
        return allocationTableDaoImpl.searchAllocationTableListSize(commodity);
    }

}
