package com.medicine.dao.impl;

import com.medicine.dao.inter.ChangeCommodityDaoInter;
import com.medicine.pojo.Category;
import com.medicine.pojo.Commodity;
import com.medicine.pojo.Manufacturer;
import com.medicine.pojo.Supplier;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-30-8:19
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.dao.impl
 */
@Repository("changeCommodityDaoImpl")
public class ChangeCommodityDaoImpl implements ChangeCommodityDaoInter{
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactoryBean;

    public void setSqlSessionFactoryBean(SqlSessionFactory sqlSessionFactoryBean) {
        this.sqlSessionFactoryBean = sqlSessionFactoryBean;
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
            String statementKey = "medicinepro.Changecommodity.searchUnit";
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
            String statementKey = "medicinepro.Changecommodity.insertCommodity";
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
            String statementKey = "medicinepro.Changecommodity.searchManufacturerList";
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
            String statementKey = "medicinepro.Changecommodity.selectCOmmodityId";
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
            String statementKey = "medicinepro.Changecommodity.searchCatId";
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

    /**
     * 删除商品信息（将商品状态改为1）
     * @param comId
     * @return
     */
    @Override
    public int deleteCommodity(List<String> comId) {
        SqlSession sqlSession = null;
        int rows =0;
        try {
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.Changecommodity.deleteCommodity";
            //6、执行查询操作
            rows = sqlSession.insert(statementKey,comId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return rows;
    }


    @Override
    public int deleteCommodity2(String comId) {
        SqlSession sqlSession = null;
        int rows =0;
        try {
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.Changecommodity.deleteCommodity2";
            //6、执行查询操作
            rows = sqlSession.insert(statementKey,comId);
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
     * 查询所有供货商信息
     * @return
     */
    @Override
    public List<Supplier> searchSupplier() {
        SqlSession sqlSession = null;
        List<Supplier> supplierList = new ArrayList<Supplier>();
        try {
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.Changecommodity.searchSupplierList";
            //6、执行查询操作
            supplierList = sqlSession.selectList(statementKey);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return supplierList;
    }
}
