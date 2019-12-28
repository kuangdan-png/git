package com.medicine.dao.impl;

import com.medicine.dao.inter.CommodityManagerDaoInter;
import com.medicine.pojo.Category;

import com.medicine.pojo.Commodity;
import com.medicine.pojo.Manufacturer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Auther:陈涛
 * DATE: 2019-11-27-14:39
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.dao.impl
 */
@Repository("commodityManagerDaoImpl")
public class CommodityManagerDaoImpl implements CommodityManagerDaoInter {
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactoryBean;

    public void setSqlSessionFactoryBean(SqlSessionFactory sqlSessionFactoryBean) {
        this.sqlSessionFactoryBean = sqlSessionFactoryBean;
    }

    /**
     * 查询商品类别父类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityTypeDao() {
        SqlSession sqlSession = null;
        List<Category> categpryList = new ArrayList<Category>();
        try {
            System.out.println("==="+sqlSessionFactoryBean);
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodityType.crud.searchCommodityTypeParent";
            //6、执行查询操作
            categpryList = sqlSession.selectList(statementKey);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return categpryList;
    }

    @Override
    public List<Category> searchCommodityDao(String catId) {
        SqlSession sqlSession = null;
        List<Category> categpryList = new ArrayList<Category>();
        try {
            //的作用：
            System.out.println("==="+sqlSessionFactoryBean);
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodityType.crud.searchCommodityType";
            //6、执行查询操作
            categpryList = sqlSession.selectList(statementKey,catId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return categpryList;
    }

    /**
     * 根据页面传输的条件查询类别
     * @param seniorSeclct
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityseniorSeclct(String seniorSeclct) {
        SqlSession sqlSession = null;
        List<Category> categpryList = new ArrayList<Category>();
        try {
            //的作用：
            System.out.println("==="+sqlSessionFactoryBean);
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodityType.crud.searchCommodityTypeseniorSeclct";
            //6、执行查询操作
            categpryList = sqlSession.selectList(statementKey,seniorSeclct);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return categpryList;
    }

    /**
     * 获取单位下拉列表的值
     * @return List<String>
     */
    @Override
    public List<String> searchUnitDao() {
        SqlSession sqlSession = null;
        List<String> UnitList = new ArrayList<String>();
        try {
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodityType.crud.searchUnit";
            //6、执行查询操作
            UnitList = sqlSession.selectList(statementKey);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return UnitList;
    }
    /**
     * 获取所有工厂信息
     * @return
     */
    @Override
    public List<Manufacturer> searchManufacturer() {
        SqlSession sqlSession = null;
        List<Manufacturer> manufacturerList = new ArrayList<Manufacturer>();
        try {
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodityType.crud.searchManufacturerList";
            //6、执行查询操作
            manufacturerList = sqlSession.selectList(statementKey);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return manufacturerList;
    }

    /**
     * 获得商品最大编号
     * @return
     */
    @Override
    public String returnCOmmodityidDao() {
        SqlSession sqlSession = null;
        String commodityId=null;
        try {
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodityType.crud.selectCOmmodityId";
            //6、执行查询操作
            commodityId = sqlSession.selectOne(statementKey);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return commodityId;
    }

    /**
     * 新增商品信息
     * @param commodity
     * @return
     */
    @Override
    public int insertCommodityDao(Commodity commodity) {
        SqlSession sqlSession = null;
        int rows =0;
        try {
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodityType.crud.insertCommodity";
            //6、执行查询操作
            rows = sqlSession.insert(statementKey,commodity);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return rows;
    }

    /**
     * 根据商品类别名称查询商品类别编号
     * @param catName
     * @return
     */
    @Override
    public Category searchCatId(String catName) {
        SqlSession sqlSession = null;
        Category category=null;
        try {
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodityType.crud.searchCatId";
            //6、执行查询操作
            category = sqlSession.selectOne(statementKey,catName);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return category;
    }

    /*查询采购进货的供货商下拉框动态获取*/
    @Override
    public List<String> searchSupplierDao() {
        SqlSession sqlSession=null;
        List<String> SupplierList=new ArrayList<String>();
        try {
            sqlSession=sqlSessionFactoryBean.openSession();
            String statementKey="medicinepro.commodityType.crud.searchAllsupplierList";
            SupplierList = sqlSession.selectList(statementKey);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return SupplierList;
    }
}
