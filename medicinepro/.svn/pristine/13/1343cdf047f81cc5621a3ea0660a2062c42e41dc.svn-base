package com.medicine.dao.impl;

import com.medicine.dao.inter.AllocationTableDaoInter;
import com.medicine.pojo.Commodity;
import com.medicine.pojo.ReceiptsDetailed;
import com.medicine.pojo.RepertorySon;
import com.medicine.pojo.Warehouse;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 匡丹
 * @Date: 2019-11-27 14:27
 * @Description:
 */
@Repository("allocationTableDaoImpl")
public class AllocationTableDaoImpl implements AllocationTableDaoInter{
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;
    //2、提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 查商品信息集合
     * @return
     */
    @Override
    public List<Commodity> searchAllocationTableList(Commodity commodity) {
        SqlSession sqlSession = null;
        List<Commodity> commodityList = new ArrayList<Commodity>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            String statementKey = "commodity.crud.searchAllocationTableList";
            commodityList=sqlSession.selectList(statementKey,commodity);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return commodityList;
    }

    /**
     * 库存
     * @return
     */
    @Override
    public List<Warehouse> searchWareHourseInfo(Warehouse warehouse) {
        SqlSession sqlSession = null;
        List<Warehouse> warehouseList = new ArrayList<Warehouse>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            String statementKey = "commodity.crud.searchWareHourseInfo";
            warehouseList=sqlSession.selectList(statementKey,warehouse);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return warehouseList;
    }

    /**
     * 查询库存为0的商品
     * @param commodity
     * @return
     */
    @Override
    public int searchAllocationTableListSize(Commodity commodity) {
        SqlSession sqlSession = null;
        int size = 0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            String statementKey = "commodity.crud.searchAllocationTableListSize";
            size=sqlSession.selectOne(statementKey,commodity);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return size;
    }
}
