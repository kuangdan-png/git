package com.medicine.handler;

import com.medicine.pojo.*;
import com.medicine.service.inter.EmployeesInfoServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 陈选创
 * @Date 2019-11-25 16:14
 * @Version 1.0
 * @Company YYJC EDU
 */
@Controller
@RequestMapping(value = "/employees")
public class EmployeesInfoHandler{
    //依赖业务逻辑的接口引用
    @Resource(name = "employeesInfoServiceImpl")
    private EmployeesInfoServiceInter employeesInfoServiceImpl;
    //提供setter方式完成注入
    public void setEmployeesInfoServiceImpl(EmployeesInfoServiceInter employeesInfoServiceImpl) {
        this.employeesInfoServiceImpl = employeesInfoServiceImpl;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 查询所有员工
     * @param employees
     * @return listResultMap
     * http://localhost:8008/employeesInfoHandler/searchEmployeesInfo.action
     */
    @RequestMapping(value = "/searchAllEmployeesInfo.action")
    public @ResponseBody ResultMap<List<Employees>> searchAllEmployeesInfo(Employees employees){
        //调用业务逻辑实现类 查询员工总条数
        int row = employeesInfoServiceImpl.searchSize();
        //查询员工分页
        List<Employees> employeesList=employeesInfoServiceImpl.searchEmployeesInfo(employees);
        ResultMap<List<Employees>> listResultMap=new ResultMap<List<Employees>>("",employeesList, 200,row);

        return listResultMap;
    }

    /**
     * 查询省份
     * @return provinceList
     */
    @RequestMapping(value = "/searchAllProvinceInfo.action")
    public @ResponseBody List<Province> searchAllProvinceInfo(){
        List<Province> provinceList = employeesInfoServiceImpl.searchProvinceInfo();
        return provinceList;
    }

    /**
     * 查询所有市级
     * @return cityList
     */
    @RequestMapping(value = "/searchAllCityInfo.action")
    public @ResponseBody List<City> searchAllCityInfo(City city){
        List<City> cityList = employeesInfoServiceImpl.searchCityInfo(city.getCitProvinceNo());
        return cityList;
    }

    /**
     * 查询所有区级
     * @return districtList
     */
    @RequestMapping(value = "/searchAllDistrictInfo.action")
    public @ResponseBody List<District> searchAllDistrictInfo(District district){
        List<District> districtList = employeesInfoServiceImpl.searchDistrictInfo(district.getDisCityNo());
        return districtList;
    }

    /**
     * 查询所有职务
     * @return dutyLists
     */
    @RequestMapping(value = "/searchAllDutyListInfo.action")
    public @ResponseBody List<DutyList> searchAllDutyListInfo(){
        List<DutyList> dutyLists = employeesInfoServiceImpl.searchDutyListInfo();
        return dutyLists;
    }

    /**
     * 自动赋值编号
     * @return maxEmployeesId
     */
    @RequestMapping(value = "/searchMaxEmployeesId.action")
    public @ResponseBody String searchMaxEmployeesId(){
        //return "{\"maxEmployeesId\":"+maxEmployeesId+"}";
        MaxNo maxNo=new MaxNo();
        maxNo.setManName("employees");
        String puMaxNo = commandMethod.getPuMaxNo(maxNo);
        return puMaxNo;
    }

    /**
     * 员工信息的新增
     * @param employees
     * @return row
     */
    @RequestMapping(value = "/insertEmployeesInfo.action")
    public @ResponseBody int insertEmployeesInfo(Employees employees){
//        System.err.println("employees.getEmpNo="+employees.getEmpNo());
        //调用业务逻辑实现类
        int row=employeesInfoServiceImpl.insertEmployeesInfo(employees);
        return row;
    }

    /**
     *  删除员工信息
     * @return successed
     */
    @RequestMapping(value = "/deleteEmployeesInfo.action")
    public @ResponseBody String deleteEmployeesInfo(Employees employees){
        int row = employeesInfoServiceImpl.deleteEmployeesInfo(employees);
        if(0!=row){
            return "successed";
        }else{
            return "failed";
        }
    }

    /**
     * 按条件查询员工信息
     * @param employees
     * @return listResultMap
     */
    @RequestMapping(value = "/searchWhereEmployees.action")
    public @ResponseBody ResultMap<List<Employees>> searchWhereEmployees(Employees employees){
        //调用业务逻辑实现类 总条数
        int row = employeesInfoServiceImpl.searchSize();
        List<Employees> employeesList=employeesInfoServiceImpl.searchWhereEmployees(employees);

        ResultMap<List<Employees>> listResultMap=new ResultMap<List<Employees>>("",employeesList, 200,row);
//        System.err.println("按条件查询员工信息=="+employeesList.size());

        return listResultMap;
    }

    /**
     *  修改员工信息
     * @return row
     */
    @RequestMapping(value = "/updateEmployees.action")
    public @ResponseBody int updateEmployees(Employees employees){
//        System.err.println(employees.getEmpBirthdayStr());
        int row = employeesInfoServiceImpl.updateEmployees(employees);
        System.err.println(row);
        return row;
    }
}
