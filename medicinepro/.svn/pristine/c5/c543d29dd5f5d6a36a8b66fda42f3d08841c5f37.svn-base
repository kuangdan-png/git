package com.medicine.dao.impl;

import com.medicine.dao.inter.WarehouseDaoInter;
import com.medicine.pojo.*;
import com.medicine.util.Page;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:匡佩
 * @Date: 2019/11/28 0028 17:06
 * @Description:仓库管理数据访问层实现类
 */
@Repository(value ="warehouseDaoImpl" )
public class WarehouseDaoImpl implements WarehouseDaoInter {
    //1、在数据访问bean中依赖于SqlSessionFactory(spring容器会根据配置文件完成对sessionFactory)
    @Resource(name ="sqlSessionFactoryBean")
    //2、提供setter方式完成注入
    private SqlSessionFactory sqlSessionFactory;
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    /**
     * 查询所有供货商集合
     * @param page
     * @return List<Warehouse> 类型集合
     * statementKey:warehouses.crud.searchwarehousemapList
     */
    public List<Warehouse> searchWarehouse(Page page) {
        SqlSession sqlSession = null;
        List<Warehouse> suppliers=new ArrayList<Warehouse>();
        try {

            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.searchwarehousemapList";
            //4、执行查询操作
            suppliers = sqlSession.selectList(statementKey,page);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return suppliers;
    }

    /**
     * 查询总条数
     * @return int
     * statementKey:warehouses.crud.countnum
     */
    public int currentPageNumber() {
        SqlSession sqlSession = null;
        int rows =0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.countnum";
            //4、执行查询操作
            rows=sqlSession.selectOne(statementKey);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 查询仓库负责人
     * @return List<Warehouse>
     * statementKey:warehouses.crud.searchwarehouseempName    
     */
    public List<Employees> searchwarehouseempName() {
        SqlSession sqlSession = null;
        List<Employees> suppliers=new ArrayList<Employees>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.searchwarehouseempName";
            //4、执行查询操作
            suppliers = sqlSession.selectList(statementKey);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return suppliers;
    }

    /**
     * 新增数据
     * @param warehouse
     * @return int
     * statementKey:warehouses.crud.warehouseInsert
     */
    public int insertWarehouse(Warehouse warehouse) {
        SqlSession sqlSession = null;
        int rows =0;
        try {

            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.warehouseInsert";
            //4、执行查询操作
            rows=sqlSession.insert(statementKey,warehouse);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 删除数据
     * @param warID
     * @return int
     * statementKey:warehouses.crud.warehouseDelete
     */
    public int deleteWarehouse(String[] warID) {
        SqlSession sqlSession = null;
        int rows =0;
        try {

            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.warehouseDelete";
            //4、执行查询操作
            rows=sqlSession.delete(statementKey,warID);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 编辑数据
     * @param warehouse
     * @return int
     * statementKey:warehouses.crud.warehouseUpdate
     */
    public int updateWarehouse(Warehouse warehouse) {
        SqlSession sqlSession = null;
        int rows =0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.warehouseUpdate";
            //4、执行查询操作
            rows=sqlSession.update(statementKey,warehouse);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 省
     * @return List<Province>
     * statementKey:warehouses.crud.warehouseAllprovince   
     */
    public List<Province> selectAllprovince() {
        SqlSession sqlSession = null;
        List<Province> provinces=new ArrayList<Province>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.warehouseAllprovince";
            //4、执行查询操作
            provinces = sqlSession.selectList(statementKey);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return provinces;
    }

    /**
     * 市
     * @param processId
     * @return List<City>
     * statementKey:warehouses.crud.warehouseAllCity    
     */
    public List<City> selectAllCity(String processId) {
        SqlSession sqlSession = null;
        List<City> cities=new ArrayList<City>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.warehouseAllCity";
            //4、执行查询操作
            cities = sqlSession.selectList(statementKey,processId);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return cities;
    }

    /**
     * 区
     * @param cityIds
     * @return List<District>
     * statementKey:warehouses.crud.warehouseAllArea    
     */
    public List<District> selectAllArea(String cityIds) {
        SqlSession sqlSession = null;
        List<District> districts=new ArrayList<District>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.warehouseAllArea";
            //4、执行查询操作
            districts = sqlSession.selectList(statementKey,cityIds);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return districts;
    }

    /**
     * 地址表编号
     * @param proId
     * @param citId
     * @param disId
     * @return String
     * statementKey:warehouses.crud.warehouseSupAddressNo
     */
    public String selectSupAddressNo(String proId,String citId,String disId) {
        SqlSession sqlSession = null;
        /*List<District> districts=new ArrayList<District>();*/
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("proId",proId);
        map.put("citId",citId);
        map.put("disId",disId);
        String supplier=null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.warehouseSupAddressNo";
            //4、执行查询操作
            supplier = sqlSession.selectOne(statementKey,map);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return supplier;
    }

    /**
     * 查询最大编号
     * @return String
     */
    public String searchwarehouseIdMax() {
        SqlSession sqlSession = null;
        String rows =null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "warehouses.crud.searchwarehouseIdMax";
            //4、执行查询操作
            rows=sqlSession.selectOne(statementKey);
            System.out.println(rows);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return rows;
    }

}
