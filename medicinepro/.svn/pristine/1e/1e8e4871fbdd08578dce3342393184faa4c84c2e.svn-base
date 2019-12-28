package com.medicine.service.impl;

import com.medicine.dao.inter.EmployeesInfoDaoInter;
import com.medicine.pojo.*;
import com.medicine.service.inter.EmployeesInfoServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.MD5;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 业务逻辑接口类
 * @author 陈选创
 * @Date 2019-11-2516:03
 * @Version 1.0
 * @Company YYJC EDU
 *
 */
@Service("employeesInfoServiceImpl")
public class EmployeesInfoServiceImpl implements EmployeesInfoServiceInter {
    //1、依赖数据访问的接口引用
    @Resource(name = "employeesInfoDaoImpl")
    private EmployeesInfoDaoInter employeesInfoDaoImpl;

    //2、提供setter方式完成注入
    public void setEmployeesInfoDaoImpl(EmployeesInfoDaoInter employeesInfoDaoImpl) {
        this.employeesInfoDaoImpl = employeesInfoDaoImpl;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }


    /**
     * 查询所有员工信息
     *
     * @return
     */
    public List<Employees> searchEmployeesInfo(Employees employees) {
        //SQL分页处理
        employees.setPage((employees.getPage() - 1) * employees.getLimit());
//        employees.setEmpUserPass(MD5.md5(employees.getEmpUserPass()));
        return employeesInfoDaoImpl.searchEmployeesInfo(employees);
    }

    /**
     * 查询总页数
     * @return
     */
    public int searchSize() {
        return employeesInfoDaoImpl.searchSize();
    }

    /**
     * 查询所有省份
     * @return
     */
    @Override
    public List<Province> searchProvinceInfo() {
        return employeesInfoDaoImpl.searchProvinceInfo();
    }

    /**
     * 查询所有市级
     * @return
     */
    @Override
    public List<City> searchCityInfo(String proId) {
        return employeesInfoDaoImpl.searchCityInfo(proId);
    }

    /**
     * 查询所有区级
     *
     * @return
     */
    @Override
    public List<District> searchDistrictInfo(String citId) {
        return employeesInfoDaoImpl.searchDistrictInfo(citId);
    }

    /**
     * 查询所有职务
     *
     * @return
     */
    @Override
    public List<DutyList> searchDutyListInfo() {
        return employeesInfoDaoImpl.searchDutyListInfo();
    }

    /**
     * 新增员工信息
     * @param employees
     * @return
     */
    @Override
    public int insertEmployeesInfo(Employees employees) {
        //将时间类型从String---date类型转换
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss");
        String empBirthday = employees.getEmpBirthdayStr();
        String empHiredate = employees.getEmpHiredateStr();
        try {
            employees.setEmpBirthday(formatter.parse(empBirthday));
            employees.setEmpHiredate(formatter.parse(empHiredate));
//          加密的方式
            String hashAlgorithmName = "MD5";
//          加密的密码
            String credentials = employees.getUserPass();;
//          盐值
            Object salt = ByteSource.Util.bytes(employees.getUserName());
//          加密的次数
            int hashIterations = 1024;
            SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
            System.err.println(""+simpleHash);
            employees.setUserPass(simpleHash.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MaxNo maxNo = new MaxNo();
        maxNo.setManName("employees");
        maxNo.setManSort(employees.getEmpNo());
        commandMethod.updateMax(maxNo);
        return employeesInfoDaoImpl.insertEmployeesInfo(employees);
    }

    /**
     * 删除员工信息
     * @return
     */
    @Override
    public int deleteEmployeesInfo(Employees employees) {
        //员工信息多条删除，对数组进行处理
        String[] employeeNoArray = employees.getEmpNo().split(",");
        return employeesInfoDaoImpl.deleteEmployeesInfo(employeeNoArray);
    }

    /**
     * 按条件查询员工信息
     * @param employees
     * @return
     */
    @Override
    public List<Employees> searchWhereEmployees(Employees employees) {
        //分页时对当前页数的处理
        employees.setPage((employees.getPage() - 1) * employees.getLimit());
        return employeesInfoDaoImpl.searchWhereEmployees(employees);
    }

    /**
     * 修改员工信息
     * @param employees
     * @return
     */
    @Override
    public int updateEmployees(Employees employees) {
        //将时间类型从String---date类型转换
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String empBirthday = employees.getEmpBirthdayStr();
        String empHiredate = employees.getEmpHiredateStr();
        try {
            employees.setEmpBirthday(formatter.parse(empBirthday));
            employees.setEmpHiredate(formatter.parse(empHiredate));
//            加密的方式
            String hashAlgorithmName = "MD5";
//          加密的密码
            String credentials = employees.getUserPass();;
//          盐值
            Object salt = ByteSource.Util.bytes(employees.getUserName());
//          加密的次数
            int hashIterations = 1024;
            SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
            System.err.println(""+simpleHash);
            employees.setUserPass(simpleHash.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return employeesInfoDaoImpl.updateEmployees(employees);
    }
}
