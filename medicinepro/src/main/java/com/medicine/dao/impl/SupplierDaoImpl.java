package com.medicine.dao.impl;

import com.medicine.dao.inter.SupplierDaoInter;
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
 * @Date: 2019/11/25 0025 16:37
 * @Description:查询供货商Dao实现类
 */
@Repository(value ="supplierDaoImpl" )
public class SupplierDaoImpl implements SupplierDaoInter {
    //1、在数据访问bean中依赖于SqlSessionFactory(spring容器会根据配置文件完成对sessionFactory)
    @Resource(name ="sqlSessionFactoryBean")
    //2、提供setter方式完成注入
    private SqlSessionFactory sqlSessionFactory;
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    /**
     * 查询所有供货商集合
     * @return List<Supplier> 类型集合
     * 带参数Page page
     * statementKey：supplier.crud.searchsuppliermapList
     */
    public List<Supplier> searchSupplier(Page page) {
        SqlSession sqlSession = null;
        List<Supplier> suppliers=new ArrayList<Supplier>();
        try {

            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.searchsuppliermapList";
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
     * @return int类型
     * statementKey：supplier.crud.countnum
     */
    public int currentPageNumber() {
        SqlSession sqlSession = null;
        int rows =0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.countnum";
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
     * 新增供货商数据
     * @param supplier 所带参数Supplier supplier
     * @return int类型
     * statementKey：supplier.crud.supplierInsert
     */
    public int insertSupplier(Supplier supplier) {
        SqlSession sqlSession = null;
         int rows =0;
        try {

            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.supplierInsert";
            //4、执行查询操作
            rows=sqlSession.insert(statementKey,supplier);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 删除供货商
     * @param supID 所带参数String[] supID
     * @return int类型
     * statementKey：supplier.crud.supplierDelete
     */
    public int deleteSupplier(String[] supID) {
        SqlSession sqlSession = null;
        int rows =0;
        try {

            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.supplierDelete";
            //4、执行查询操作
            rows=sqlSession.delete(statementKey,supID);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 编辑供货商
     * @param supplier 所带参数Supplier supplier
     * @return int类型
     * statementKey：supplier.crud.supplierUpdate
     */
    public int updateSupplier(Supplier supplier) {
        SqlSession sqlSession = null;
        int rows =0;
        try {

            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.supplierUpdate";
            //4、执行查询操作
            rows=sqlSession.update(statementKey,supplier);

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
     * @return List<Province> 集合
     * statementKey：supplier.crud.selectAllprovince
     */
    public List<Province> selectAllprovince() {
        SqlSession sqlSession = null;
        List<Province> provinces=new ArrayList<Province>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.selectAllprovince";
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
     * @param processId 所带参数 String processId
     * @return List<City> 集合
     * statementKey：supplier.crud.selectAllCity
     */
    public List<City> selectAllCity(String processId) {
        SqlSession sqlSession = null;
        List<City> cities=new ArrayList<City>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.selectAllCity";
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
     * 市
     * @param cityIds 所带参数 String cityIds
     * @return List<District> 集合
     * statementKey：supplier.crud.selectAllArea
     */
    public List<District> selectAllArea(String cityIds) {
        SqlSession sqlSession = null;
        List<District> districts=new ArrayList<District>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.selectAllArea";
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
     * 根据省市区编号查询地址表编号
     * @param proId
     * @param citId
     * @param disId
     * @return String类型
     * statementKey：supplier.crud.selectSupAddressNo
     * 利用Map赋值三个参数
     */
    public String selectSupAddressNo(String proId,String citId,String disId) {
        SqlSession sqlSession = null;
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("proId",proId);
        map.put("citId",citId);
        map.put("disId",disId);
        String supplier=null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.selectSupAddressNo";
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
     * 搜索
     * @param search 所带参数 String search,Page page
     * @return List<Supplier> 集合
     * statementKey：supplier.crud.searchselect
     * 利用Map赋值
     *
     */
    public List<Supplier> toProduct(String search,Page page) {
        System.out.println(page.getPage());
        System.out.println(page.getlimit());
        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"+search);
        SqlSession sqlSession = null;
        Map<String,Object> map=new HashMap<String, Object>();
        List<Supplier> suppliers=new ArrayList<Supplier>();
        List<Integer> integers=new ArrayList<Integer>();
        integers.add(page.getPage());
        integers.add(page.getlimit());
        map.put("a",search);
        map.put("list",integers);
        try {

            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.searchselect";
            //4、执行查询操作
            suppliers = sqlSession.selectList(statementKey,map);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return suppliers;
    }

    /**
     * 搜索内容的总条数
     * @param search
     * @return int类型
     * statementKey：supplier.crud.searchselectrows
     */
    public int searchselectrows(String search) {
        SqlSession sqlSession = null;
        int rows =0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.searchselectrows";
            //4、执行查询操作
            rows=sqlSession.selectOne(statementKey,search);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 获取最大编号
     * @return String 类型
     * statementKey：supplier.crud.searchSupplierIdMax
     */
    public String searchSupplierIdMax() {
        SqlSession sqlSession = null;
        String rows =null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "supplier.crud.searchSupplierIdMax";
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
