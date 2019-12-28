package com.medicine.dao.inter;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import com.medicine.pojo.*;
import com.medicine.util.Page;

/**
 * @Auther:匡佩
 * @Date: 2019/11/25 0025 16:54
 * @Description:供货商Dao接口
 */

public interface SupplierDaoInter {
    @Resource(name = "sql")
    /**
     *  分页查询
     *  所带参数：Page page
     *  返回类型：List<Supplier>
     */
    List<Supplier> searchSupplier(Page page);
    /**
     *  查询总条数
     *  返回类型：int
     */
    int currentPageNumber();
    /**
     * 新增数据
     * @param supplier 所带参数 Supplier supplier
     * @return int类型
     */
    int insertSupplier(Supplier supplier);

    /**
     * 删除数据
     * @param supID 所带参数 String[] supID
     * @return int类型
     */
    int deleteSupplier(String[] supID);

    /**
     * 编辑数据
     * @param supplier 所带参数 Supplier supplier
     * @return int
     */
    int updateSupplier(Supplier supplier);

    /**
     * 查询省
     * @return List<Province> 集合
     */
    List<Province> selectAllprovince();

    /**
     * 查询市
     * @param processId 所带参数 String processId
     * @return List<City> 集合
     */
    List<City> selectAllCity(String processId);

    /**
     * 查询区
     * @param cityIds 所带参数 String cityIds
     * @return List<District>
     */
    List<District> selectAllArea(String cityIds);

    /**
     * 地址表编号
     * @param proId
     * @param citId
     * @param disId
     * @return String 类型
     */
    String selectSupAddressNo(String proId, String citId, String disId);

    /**
     * 搜索
     * @param search 返回类型 String search,Page page
     * @return List<Supplier> 集合
     */
    List<Supplier> toProduct(String search, Page page);

    /**
     * 搜索内容总条数
     * 所带参数String search
     * @return int类型
     */
    int searchselectrows(String search);

    /**
     * 查询最大编号，自增
     * @return  String类型
     */
    String searchSupplierIdMax();
}
