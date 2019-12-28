package com.medicine.dao.inter;

import com.medicine.pojo.*;
import com.medicine.util.Page;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:匡佩
 * @Date: 2019/11/28 0028 17:06
 * @Description:仓库管理数据访问层接口
 */
public interface WarehouseDaoInter {
    @Resource(name = "sql")
    /**
     * 分页查询
     * @param page
     * @return List<Warehouse>
     */
    List<Warehouse> searchWarehouse(Page page);
    /**
     * 查询总条数
     * @return int
     */
    int currentPageNumber();

    /**
     * 查询仓库负责人
     * @return List<Warehouse>
     */
    List<Employees> searchwarehouseempName();
    /**
     * 新增数据
     * @param warehouse
     * @return int
     */
    int insertWarehouse(Warehouse warehouse);

    /**
     * 删除数据
     * @param warID String[]
     * @return int
     */
    int deleteWarehouse(String[] warID);

    /**
     * 编辑数据
     * @param warehouse
     * @return int
     */
    int updateWarehouse(Warehouse warehouse);
    /**
     * 省
     * @return List<Province>
     */
    List<Province> selectAllprovince();

    /**
     * 市
     * @param processId
     * @return List<City>
     */
    List<City> selectAllCity(String processId);

    /**
     * 区
     * @param cityIds
     * @return List<District>
     */
    List<District> selectAllArea(String cityIds);

    /**
     * 地址表编号
     * @param proId
     * @param citId
     * @param disId
     * @return String
     */
    String selectSupAddressNo(String proId, String citId, String disId);
    /**
     * 查询最大编号，自增
     * @return String
     */
    String searchwarehouseIdMax();
}
