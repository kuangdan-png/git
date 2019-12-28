package com.medicine.service.inter;

import com.medicine.pojo.*;

import java.util.List;

/**
 * @author 陈选创
 * @Date 2019-11-2516:02
 * @Version 1.0
 * @Company YYJC EDU
 */
public interface EmployeesInfoServiceInter {
    /**
     * 查询所有员工信息
     * @return
     */
    List<Employees> searchEmployeesInfo(Employees employees);

    /**
     * 查询总条数
     * @return
     */
    int searchSize();

    /**
     * 查询所有省份
     * @return
     */
    List<Province> searchProvinceInfo();

    /**
     * 查询所有市级
     * @return
     */
    List<City> searchCityInfo(String proId);

    /**
     * 查询所有区级
     * @return
     */
    List<District> searchDistrictInfo(String citId);

    /**
     * 查询所有职务
     * @return
     */
    List<DutyList> searchDutyListInfo();

    /**
     * 新增员工信息
     * @return
     */
    int insertEmployeesInfo(Employees employees);

    /**
     * 删除员工信息
     * @return
     */
    int deleteEmployeesInfo(Employees employees);

    /**
     * 按条件查询员工信息
     * @param employees
     * @return
     */
    List<Employees> searchWhereEmployees(Employees employees);

    /**
     * 修改员工信息
     * @param employees
     * @return
     */
    int updateEmployees(Employees employees);
}
