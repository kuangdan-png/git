package com.medicine.dao.impl;

import com.medicine.dao.inter.WareHouseManagerDaoInter;
import com.medicine.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张如意
 * @Date: 2019-11-27 15:49
 * @Description:
 */
@Repository("wareHouseManagerDaoImpl")
public class WareHouseManagerDaoImpl implements WareHouseManagerDaoInter {

    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory=null;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 药品信息的过期查询
     *
     * @param repertorySon
     * @return
     */
    @Override
    public List<RepertorySon> searchStaleDated(RepertorySon repertorySon) {
        SqlSession sqlSession=null;
        List<RepertorySon> list=new ArrayList<RepertorySon>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("warehouse.crud.searchStaleDated",repertorySon);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return list;
    }

    /**
     * 药品的数量
     *
     * @param repertorySon
     * @return
     */
    @Override
    public int searchTotalRows(RepertorySon repertorySon) {
        SqlSession sqlSession=null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("warehouse.crud.searchTotalRows",repertorySon);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return rows;
    }

    /**
     * 查询最大编号刘涵写
     *
     * @param maxNo
     * @return
     */
    @Override
    public MaxNo searchMaxNo(MaxNo maxNo) {
        SqlSession sqlSession=null;
        MaxNo maxNo1= null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            maxNo1=sqlSession.selectOne("warehouse.crud.searchMaxNo",maxNo);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return maxNo1;
    }

    /**
     * 查询所有的仓库信息
     *
     * @return
     */
    @Override
    public List<Warehouse> searchWareHourseInfo() {
        SqlSession sqlSession=null;
        List<Warehouse> list=new ArrayList<Warehouse>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("warehouse.crud.searchWareHourseInfo");
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return list;
    }

    /**
     * 查询 库存数量 低于 最低库存 的药品数量
     *
     * @return
     */
    @Override
    public int searchWarehouseNumIsZeroTotalRows() {
        SqlSession sqlSession=null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("warehouse.crud.searchWarehouseNumIsZeroTotalRows");
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return rows;
    }

    /**
     * 查询 库存数量 低于 最低库存 的药品
     *
     * @param repertorySon
     * @return
     */
    @Override
    public List<Commodity> searchWarehouseNumIsZero(RepertorySon repertorySon) {
        SqlSession sqlSession=null;
        List<Commodity> list=new ArrayList<Commodity>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("warehouse.crud.searchWarehouseNumIsZero",repertorySon);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return list;
    }

    /**
     * 根据商品编号查询进货和销售明细的药品数量
     *
     * @param receiptsDetailed
     * @return
     */
    @Override
    public int searchPurchaseAndSalesDetailsTotalRows(ReceiptsDetailed receiptsDetailed) {
        SqlSession sqlSession=null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("warehouse.crud.searchPurchaseAndSalesDetailsTotalRows",receiptsDetailed);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return rows;
    }

    /**
     * 根据商品编号查询进货和销售明细的药品
     *
     * @param receiptsDetailed
     * @return
     */
    @Override
    public List<Receipts> searchPurchaseAndSalesDetails(ReceiptsDetailed receiptsDetailed) {
        SqlSession sqlSession=null;
        List<Receipts> list=new ArrayList<Receipts>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("warehouse.crud.searchPurchaseAndSalesDetails",receiptsDetailed);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return list;
    }
}
