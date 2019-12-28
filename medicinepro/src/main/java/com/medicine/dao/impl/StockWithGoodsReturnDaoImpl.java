package com.medicine.dao.impl;

import com.medicine.dao.inter.StockWithGoodsReturnDaoInter;
import com.medicine.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 郭念
 * @Date: 2019-12-02 15:54
 * @Description: 采购退货查询数据访问实现类
 */
@Repository(value = "stockWithGoodsReturnDaoImpl")
public class StockWithGoodsReturnDaoImpl implements StockWithGoodsReturnDaoInter {
    //1、在数据访问bean中依赖于SqlSessionFactory(spring容器会根据配置文件完成对sessionFactory)
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;
    //2、提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 1、采购进退货查询
     * @return
     */
    @Override
    public List<Receipts> StockAndGoodsReturnSearch(Receipts receipts) {
        SqlSession sqlSession = null;
        List<Receipts> receiptsDetailedList = new ArrayList<Receipts>();
        try {
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "stockandgoodsreturn.crud.StockAndGoodsReturnSearch";
            //4、执行查询操作
            receiptsDetailedList = sqlSession.selectList(statementKey,receipts);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null!= sqlSession){
                sqlSession.close();
            }
        }
        return receiptsDetailedList;
    }

    /**
     * 2、分页查询总条数
     * @return
     */
    @Override
    public int SearchTotalRow(Receipts receipts) {
        SqlSession sqlSession = null;
        int row = 0;
        try {
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "stockandgoodsreturn.crud.SearchTotalRow";
            //4、执行查询操作
            row = sqlSession.selectOne(statementKey,receipts);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null!= sqlSession){
                sqlSession.close();
            }
        }
        return row;
    }

    /**
     * 3、查询单据详细信息
     * @return
     */
    @Override
    public List<ReceiptsDetailed> SearchReceiptsInfo() {
        SqlSession sqlSession = null;
        List<ReceiptsDetailed> receiptsDetailedList = new ArrayList<ReceiptsDetailed>();
        try {
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "stockandgoodsreturn.crud.SearchReceiptsInfo";
            //4、执行查询操作
            receiptsDetailedList = sqlSession.selectList(statementKey);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null!= sqlSession){
                sqlSession.close();
            }
        }
        return receiptsDetailedList;
    }

    /**
     * 4、根据单号查询单据详细信息
     * @param receipts
     * @return
     */
    @Override
    public List<ReceiptsDetailed> SearchReceiptsInfobyRecNo(Receipts receipts) {
        SqlSession sqlSession = null;
        List<ReceiptsDetailed> receiptsDetailedList = new ArrayList<ReceiptsDetailed>();
        try {
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "stockandgoodsreturn.crud.SearchReceiptsInfobyRecNo";
            //4、执行查询操作
            receiptsDetailedList = sqlSession.selectList(statementKey,receipts);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null!= sqlSession){
                sqlSession.close();
            }
        }
        return receiptsDetailedList;
    }

    /**
     * 5、第一次查询采购退货表格信息【无数据】
     * @return
     */
    @Override
    public List<ReceiptsDetailed> SearchPurchaseReturn() {
        SqlSession sqlSession = null;
        List<ReceiptsDetailed> receiptsDetailedList = new ArrayList<ReceiptsDetailed>();
        try {
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "stockandgoodsreturn.crud.searchPurchaseReturn";
            //4、执行查询操作
            receiptsDetailedList = sqlSession.selectList(statementKey);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null!= sqlSession){
                sqlSession.close();
            }
        }
        return receiptsDetailedList;
    }

    /**
     * 6、第二次根据整单退货中的单号查询采购退货表格信息
     * @param receipts
     * @return
     */
    @Override
    public List<ReceiptsDetailed> SearchPurchaseReturnByRecNo(Receipts receipts) {
        SqlSession sqlSession = null;
        List<ReceiptsDetailed> receiptsDetailedList = new ArrayList<ReceiptsDetailed>();
        try {
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "stockandgoodsreturn.crud.searchPurchaseReturnByRecNo";
            //4、执行查询操作
            receiptsDetailedList = sqlSession.selectList(statementKey,receipts);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null!= sqlSession){
                sqlSession.close();
            }
        }
        return receiptsDetailedList;
    }

    /**
     * 7、动态获取供货商下拉框
     * @return
     */
    @Override
    public List<Supplier> supplierListSearch() {
        SqlSession sqlSession = null;
        List<Supplier> supplierList  = new ArrayList<Supplier>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行的statementKey
            String statementKey = "stockandgoodsreturn.crud.searchsupplier";
            //4、执行查询操作
            supplierList = sqlSession.selectList(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭sqlSession
            sqlSession.close();
        }
        return supplierList;
    }

    /**
     * 8、动态获取仓库名称下拉框
     * @return
     */
    @Override
    public List<Warehouse> warehouseListSearch() {
        SqlSession sqlSession = null;
        List<Warehouse> warehouseList = new ArrayList<Warehouse>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行的statementKey
            String statementKey = "stockandgoodsreturn.crud.searchwarehouse";
            //4、执行查询操作
            warehouseList = sqlSession.selectList(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭sqlSession
            sqlSession.close();
        }
        return warehouseList;
    }
}
