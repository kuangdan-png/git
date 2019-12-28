package com.medicine.dao.inter;

import com.medicine.pojo.*;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据访问层接口
 * @author 陈选创
 * @Date 2019-11-2514:32
 * @Version 1.0
 * @Company YYJC EDU
 */
//@Repository(value = "employeesInfoDaoInter")
public interface EmployeesInfoDaoInter {
    /**
     * 查询所有员工信息
     * @return
     */
//    @Select(value = "select * from employees")
//    @Results({
//            @Result(id=true, column="empNo", property="empNo"),
//            @Result(column="empName" ,property="empName"),
//            @Result(column="empSex" ,property="empSex"),
//            @Result(column="empTel" ,property="empTel"),
//            @Result(column="empEmail" ,property="empEmail"),
//            @Result(column="empRatio", property="empRatio"),
//            @Result(column="empDutyNo", property="empDutyNo"),
//            @Result(column="empRemark", property="empRemark"),
//            @Result(column="empSalary", property="empSalary"),
//            @Result(column="empAddressNo", property="empAddressNo"),
//            @Result(column="empBirthday" ,property="empBirthday"),
//    })
    List<Employees> searchEmployeesInfo(Employees employees);

    /**
     *查询总条数
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
     * 查询员工最大编号
     * @return
     */
    String searchMaxEmployeesId();

    /**
     * 新增员工信息
     * @return
     */
    int insertEmployeesInfo(Employees employees);

    /**
     * 删除员工信息
     * @param
     * @return
     */
    int deleteEmployeesInfo(String[] employeesNo);

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
