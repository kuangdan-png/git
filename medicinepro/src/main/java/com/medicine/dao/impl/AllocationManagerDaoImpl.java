package com.medicine.dao.impl;

import com.medicine.dao.inter.AllocationManagerDaoInter;
import com.medicine.exception.WareHouseStockException;
import com.medicine.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-07 15:27
 * @Description:库存调拨
 */
@Repository("allocationManagerDaoImpl")
public class AllocationManagerDaoImpl implements AllocationManagerDaoInter{
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;

    //2、提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    /**
     * 查询商品清单的信息
     * @param repertorySon
     * @return List<RepertorySon>
     */
    @Override
    public List<RepertorySon> searchCommidyInfo(RepertorySon repertorySon) {
        SqlSession sqlSession=null;
        List<RepertorySon> list=new ArrayList<RepertorySon>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("allocationManager.crud.searchCommidyInfo",repertorySon);
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
     * 查询商品清单的信息总条数
     * @param repertorySon
     * @return int
     */
    @Override
    public int searchCommidyInfoSize(RepertorySon repertorySon) {
        SqlSession sqlSession=null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("allocationManager.crud.searchCommidyInfoSize",repertorySon);
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
     * 查询经办人
     * @return List<Employees>
     * @param employees
     */
    @Override
    public List<Employees> searchEmployeesJin(Employees employees) {
        SqlSession sqlSession=null;
        List<Employees> employeesList = new ArrayList<Employees>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            employeesList=sqlSession.selectList("allocationManager.crud.searchEmployeesJin",employees);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return employeesList;
    }
    /**
     * 查询单据主信息
     * @param receipts 条件
     * @return List<Receipts>
     */
    @Override
    public List<Receipts> searchReceiptsInfo(Receipts receipts) {
        SqlSession sqlSession=null;
        List<Receipts> receiptsList = new ArrayList<Receipts>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            receiptsList=sqlSession.selectList("allocationManager.crud.searchReceiptsInfo",receipts);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return receiptsList;
    }
    /**
     * 查询单据主表信息的总条数
     * @param receipts 条件
     * @return int
     */
    @Override
    public int searchReceiptsInfoSize(Receipts receipts) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("allocationManager.crud.searchReceiptsInfoSize",receipts);
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
     * 查询商品信息通过商品编号
     * @param repertorySon
     * @return
     */
    @Override
    public Commodity searchCommidyInfoByRep(String repertorySon) {
        SqlSession sqlSession=null;
        Commodity commodity = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            commodity=sqlSession.selectOne("allocationManager.crud.searchCommidyInfoByRep",repertorySon);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return commodity;
    }
    /**
     * 查询单据明细信息
     * @param repertorySon 条件
     * @return List<RepertorySon>
     */
    @Override
    public List<ReceiptsDetailed> searchReceiptsDetailedInfo(Receipts repertorySon) {

        SqlSession sqlSession=null;
        List<ReceiptsDetailed> receiptsList = new ArrayList<>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            receiptsList=sqlSession.selectList("allocationManager.crud.searchReceiptsDetailedInfo",repertorySon);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return receiptsList;
    }
    /**
     * 查询单据主表信息的总条数
     * @param repertorySon 条件
     * @return int
     */
    @Override
    public int searchReceiptsDetailedInfoSize(Receipts repertorySon) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("allocationManager.crud.searchReceiptsDetailedInfoSize",repertorySon);
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
     * 查询是否存在该商品信息在库存中
     * @param repertorySon 条件
     * @return int
     */
    @Override
    public String searchRepertorySonInfo(ReceiptsDetailed repertorySon) {
        SqlSession sqlSession=null;
        String rows="";
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("allocationManager.crud.searchRepertorySonInfo",repertorySon);
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
     * 新增单据明细表信息
     * @param receiptsDetailed
     * @return
     */
    @Override
    public int insertReceiptsDetailedInfo(ReceiptsDetailed receiptsDetailed) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("allocationManager.crud.insertReceiptsDetailedInfo",receiptsDetailed);
            if(rows<=0){
                throw new WareHouseStockException("新增单据明细表信息异常");
            }
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
     * 新增库存明细信息
     * @return int
     * @param repertorySon 条件
     */
    @Override
    public int insertRepertorySonInfo(RepertorySon repertorySon) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("allocationManager.crud.insertRepertorySonInfo",repertorySon);
            if(rows<=0){
                throw new WareHouseStockException("新增库存明细信息异常");
            }
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
     * 修改出库库存明细表的信息
     * @param receiptsDetailed 条件
     * @return int
     */
    @Override
    public int updateRepertorySonOutInfo(ReceiptsDetailed receiptsDetailed) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("allocationManager.crud.updateRepertorySonOutInfo",receiptsDetailed);
            if(rows<=0){
                throw new WareHouseStockException("修改库存信息异常");
            }
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
     * 修改入库库存明细表的信息
     * @param receiptsDetailed 条件
     * @return int
     */
    @Override
    public int updateRepertorySonInInfo(ReceiptsDetailed receiptsDetailed) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("allocationManager.crud.updateRepertorySonInInfo",receiptsDetailed);
            System.out.println("");
            System.out.println(""+receiptsDetailed);
            System.out.println("");
            System.out.println(""+rows);
            System.out.println("");
            if(rows<=0){
                throw new WareHouseStockException("修改库存信息异常");
            }
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
     * 新增单据主表信息
     * @param receipts
     * @return int
     */
    @Override
    public int insertReceiptsInfo(Receipts receipts) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("allocationManager.crud.insertReceiptsInfo",receipts);
            if(rows<=0){
                throw new WareHouseStockException("新增单据主表信息异常");
            }
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
}
