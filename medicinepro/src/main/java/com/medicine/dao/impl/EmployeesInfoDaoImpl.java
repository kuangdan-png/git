package com.medicine.dao.impl;

import com.medicine.dao.inter.EmployeesInfoDaoInter;
import com.medicine.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈选创
 * @Date 2019-11-2514:32
 * @Version 1.0
 * @Company YYJC EDU
 */
@Repository("employeesInfoDaoImpl")
public class EmployeesInfoDaoImpl implements EmployeesInfoDaoInter {
    //1、在数据访问bean中依赖于SqlSessionFactory(spring容器会根据配置文件完成对sessionFactory)
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;
    //2、提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 查询所有员工信息
     * @return
     */
    public List<Employees> searchEmployeesInfo(Employees employees) {
        SqlSession sqlSession = null;
        List<Employees> employeesList=new ArrayList<Employees>();

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.searchEmployeesList";

            employeesList=sqlSession.selectList(statementKey,employees);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return employeesList;
    }

    /**
     * 总条数
     * @return
     */
    public int searchSize() {
        SqlSession sqlSession = null;
        int row=0;

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.searchSize";

            row=sqlSession.selectOne(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

        return row;
    }

    /**
     * 查询所有省份
     * @return
     */
    @Override
    public List<Province> searchProvinceInfo() {
        SqlSession sqlSession = null;
        List<Province> provinceList=new ArrayList<Province>();

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.searchProvince";
            
            provinceList=sqlSession.selectList(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return provinceList;
    }

    /**
     * 查询所有市级
     * @return
     */
    @Override
    public List<City> searchCityInfo(String proId) {
        SqlSession sqlSession = null;
        List<City> cityList=new ArrayList<City>();

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.searchCity";

            cityList=sqlSession.selectList(statementKey,proId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return cityList;
    }

    /**
     * 查询所有区级
     * @return
     */
    @Override
    public List<District> searchDistrictInfo(String citId) {
        SqlSession sqlSession = null;
        List<District> districtList=new ArrayList<District>();

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.searchDistrict";

            districtList=sqlSession.selectList(statementKey,citId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return districtList;
    }

    /**
     * 查询所有职务
     * @return
     */
    @Override
    public List<DutyList> searchDutyListInfo() {
        SqlSession sqlSession = null;
        List<DutyList> dutyLists=new ArrayList<DutyList>();

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.searchDutyList";

            dutyLists=sqlSession.selectList(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return dutyLists;
    }

    /**
     * 自动复制最大员工编号
     * @return
     */
    @Override
    public String searchMaxEmployeesId() {
        SqlSession sqlSession = null;
        String employeesId=null;

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.searchMaxEmployeesId";

            employeesId=sqlSession.selectOne(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return employeesId;
    }

    /**
     * 新增员工信息
     * @param employees
     * @return
     */
    public int insertEmployeesInfo(Employees employees) {
        SqlSession sqlSession = null;
        int row=0;

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.insertEmployeesInfo";

            row=sqlSession.insert(statementKey,employees);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

        return row;
    }

    /**
     * 删除员工信息
     * @return
     */
    @Override
    public int deleteEmployeesInfo(String[] employeesNo) {
        SqlSession sqlSession = null;
        int row=0;

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.deleteEmployeesInfo";

            row=sqlSession.update(statementKey,employeesNo);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return row;
    }

    /**
     *按条件查询员工信息
     * @param employees
     * @return
     */
    @Override
    public List<Employees> searchWhereEmployees(Employees employees) {
        SqlSession sqlSession = null;
        List<Employees> employeesList=new ArrayList<Employees>();

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.selectLikeEmployees";

            employeesList=sqlSession.selectList(statementKey,employees);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return employeesList;
    }

    /**
     * 修改员工信息
     * @param employees
     * @return
     */
    @Override
    public int updateEmployees(Employees employees) {
        SqlSession sqlSession = null;
        int row=0;

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="employees.crud.updateEmployees";

            row=sqlSession.update(statementKey,employees);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return row;
    }
}
