package com.medicine.service.inter;

import com.medicine.pojo.Employees;
import com.medicine.pojo.Receipts;
import com.medicine.pojo.ReceiptsDetailed;
import com.medicine.pojo.RepertorySon;
import com.medicine.util.Page;
import com.medicine.util.ResultMap;

import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-07 15:25
 * @Description:库存调拨
 */
public interface AllocationManagerServiceInter {
    /**
     * 查询商品清单的信息
     * @param repertorySon
     * @param page
     * @return List<RepertorySon>
     */
    List<RepertorySon> searchCommidyInfo(RepertorySon repertorySon, Page page);

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
     * @return ResultMap<List<Receipts>>
     */
    ResultMap<List<Receipts>> searchReceiptsInfo(Receipts receipts);
    /**
     * 查询单据明细信息
     * @param repertorySon 条件
     * @return ResultMap<List<RepertorySon>>
     */
    ResultMap<List<ReceiptsDetailed>>  searchRepertorySonInfo(Receipts repertorySon);

    /**
     * 对单据表进行新增
     * @param receipts 单据主表信息
     * @param data 单据明细数据
     * @return int 影响行数
     */
    int addReceiptsDetailed(Receipts receipts, List<RepertorySon> data);
}
