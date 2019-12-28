package com.medicine.dao.inter;

import com.medicine.pojo.*;

import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-07 15:26
 * @Description:库存调拨
 */
public interface AllocationManagerDaoInter {
    /**
     * 查询商品清单的信息
     * @param repertorySon
     * @return List<RepertorySon>
     */
    List<RepertorySon> searchCommidyInfo(RepertorySon repertorySon);
    /**
     * 查询商品清单的信息总条数
     * @param repertorySon
     * @return int
     */
    int searchCommidyInfoSize(RepertorySon repertorySon);
    /**
     * 查询经办人
     * @return List<Employees>
     * @param employees
     */
    List<Employees> searchEmployeesJin(Employees employees);
    /**
     * 查询单据主信息
     * @param receipts 条件
     * @return List<Receipts>
     */
    List<Receipts> searchReceiptsInfo(Receipts receipts);
    /**
     * 查询单据主表信息的总条数
     * @param receipts 条件
     * @return int
     */
    int searchReceiptsInfoSize(Receipts receipts);
    /**
     * 新增单据主表信息
     * @param receipts
     * @return int
     */
    int insertReceiptsInfo(Receipts receipts);

    /**
     * 查询商品信息
     * @param repertorySon
     * @return
     */
    Commodity searchCommidyInfoByRep(String repertorySon);
    /**
     * 查询单据明细信息
     * @param repertorySon 条件
     * @return List<RepertorySon>
     */
    List<ReceiptsDetailed> searchReceiptsDetailedInfo(Receipts repertorySon);
    /**
     * 查询单据主表信息的总条数
     * @param repertorySon 条件
     * @return int
     */
    int searchReceiptsDetailedInfoSize(Receipts repertorySon);

    /**
     * 查询是否存在该商品信息在库存中
     * @param commodity1 条件
     * @return int
     */
    String searchRepertorySonInfo(ReceiptsDetailed commodity1);


    /**
     * 新增单据明细表信息
     * @param repertorySon
     * @return int
     */
    int insertReceiptsDetailedInfo(ReceiptsDetailed repertorySon);

    /**
     * 新增库存明细信息
     * @return int
     * @param repertorySon 条件
     */
    int insertRepertorySonInfo(RepertorySon repertorySon);

    /**
     * 修改出库库存信息
     * @param receiptsDetailed 条件
     * @return int
     */
    int updateRepertorySonOutInfo(ReceiptsDetailed receiptsDetailed);

    /**
     * 修改入库库存明细表的信息
     * @param receiptsDetailed 条件
     * @return int
     */
    int updateRepertorySonInInfo(ReceiptsDetailed receiptsDetailed);
}
