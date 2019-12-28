package com.medicine.dao.impl;

import com.medicine.dao.inter.CommodityDaoInter;
import com.medicine.pojo.Category;
import com.medicine.pojo.Commodity;
import com.medicine.util.Page;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Auther:刘双
 * DATE: 2019-11-29-8:05
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.dao.impl
 */
@Repository("commodityDaoImpl")
public class CommodityDaoImpl implements CommodityDaoInter{
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactoryBean;

    public void setSqlSessionFactoryBean(SqlSessionFactory sqlSessionFactoryBean) {
        this.sqlSessionFactoryBean = sqlSessionFactoryBean;
    }
    /**
     * 查询所有商品信息
     * @return List<Commodity>
     */
    @Override
    public List<Commodity> searchCommodityDao(Page page) {
        SqlSession sqlSession = null;
        List<Commodity> commodityList = new ArrayList<Commodity>();
        try {
            System.out.println("==="+sqlSessionFactoryBean);
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodity.searchCommodity";
            //6、执行查询操作
            commodityList = sqlSession.selectList(statementKey,page);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return commodityList;
    }

    /**
     * 查询 所有商品的信息，不进行分页，为hanlder商品总条数做准备
     * @return
     */
    @Override
    public List<Commodity> searchCommodityAllDao() {
        SqlSession sqlSession = null;
        List<Commodity> commodityList = new ArrayList<Commodity>();
        try {
            System.out.println("==="+sqlSessionFactoryBean);
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodity.searchCommodityAll";
            //6、执行查询操作
            commodityList = sqlSession.selectList(statementKey);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return commodityList;
    }

    /**
     * 根据商品类型编号查询所有商品信息
     * @param page
     * @param commodityzId
     * @return
     */
    @Override
    public List<Commodity> searchCommodityForTypeAllDao(Page page,String commodityzId) {
        SqlSession sqlSession = null;
        Map<String, Object> map2 = new HashMap<String, Object>();
        List<Commodity> commodityList = new ArrayList<Commodity>();
        List<Integer> list=new ArrayList<Integer>();
        list.add(page.getPage());
        list.add(page.getlimit());
        map2.put("list",list);
        map2.put("siteTag",commodityzId );
        try {
            System.out.println("==="+sqlSessionFactoryBean);
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodity.searchCommodityForTypeAll";
            //6、执行查询操作
            commodityList = sqlSession.selectList(statementKey,map2);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return commodityList;
    }
    /**
     * 根据商品类别查询商品的信息，不进行分页，为hanlder商品总条数做准备
     * @return
     */
    @Override
    public List<Commodity> searchCommodityAllDao2(String comId) {
        SqlSession sqlSession = null;
        List<Commodity> commodityList = new ArrayList<Commodity>();
        try {
            System.out.println("==="+sqlSessionFactoryBean);
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodity.searchCommodityAll2";
            //6、执行查询操作
            commodityList = sqlSession.selectList(statementKey,comId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return commodityList;
    }

}
