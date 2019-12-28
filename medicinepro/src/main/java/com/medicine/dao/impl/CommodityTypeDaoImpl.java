package com.medicine.dao.impl;

import com.medicine.dao.inter.CommodityTypeDaoInter;
import com.medicine.pojo.Category;
import com.medicine.service.impl.CommodityTypeServiceImpl;
import com.medicine.service.inter.CommodityTypeServiceInter;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-27-14:39
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.dao.impl
 */
@Repository("commodityTypeDaoImpl")
public class CommodityTypeDaoImpl implements CommodityTypeDaoInter {
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
            String statementKey = "medicinepro.commodityType.searchCommodityTypeParent";
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
    /**
     * 查询商品类别子类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityDao(String catId) {
        SqlSession sqlSession = null;
        List<Category> categpryList = new ArrayList<Category>();
        try {
            //的作用：
            System.out.println("==="+sqlSessionFactoryBean);
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "medicinepro.commodityType.searchCommodityType";
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
            String statementKey = "medicinepro.commodityType.searchCommodityTypeseniorSeclct";
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

}
