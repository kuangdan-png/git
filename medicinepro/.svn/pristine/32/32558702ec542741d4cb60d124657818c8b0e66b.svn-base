package com.medicine.dao.impl;

import com.medicine.dao.inter.MerchBillReturnManagerDaoInter;
import com.medicine.exception.WareHouseStockException;
import com.medicine.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 郭念
 * @Date: 2019-11-26 21:18
 * @Description: 采购退货中【老商品添加】的商品清单的Dao实现类
 */
@Repository(value = "merchBillReturnManagerDaoImpl")
public class MerchBillReturnManagerDaoImpl implements MerchBillReturnManagerDaoInter {
    //1、在数据访问bean中依赖于SqlSessionFactory(spring容器会根据配置文件完成对sessionFactory)
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;
    //2、提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    /**
     * 1、查询【采购进货中的老商品添加】所有的商品清单
     * @return List<RepertorySon> 返回集合
     */
    @Override
    public List<RepertorySon> searchAllMerchBillReturn(Receipts val) {
        SqlSession sqlSession = null;
        List<RepertorySon> repertorySonList = new ArrayList<RepertorySon>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //2、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "merchbillReturn.crud.searchMerchBillReturnList";
            //3、执行查询操作
            repertorySonList = sqlSession.selectList(statementKey,val);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //4.关闭sqlSession
            sqlSession.close();
        }
        return repertorySonList;
    }

    /**
     * 2、查询所有商品信息
     * @return
     */
    @Override
    public List<Commodity> searchCommodityAllDao() {
        SqlSession sqlSession = null;
        List<Commodity> commodityList = new ArrayList<Commodity>();
        try {
            System.out.println("==="+sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "merchbillReturn.crud.searchCommodityAll";
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
     * 3、根据商品类别编号查询商品信息
     * @param commodityzId
     * @return
     */
    @Override
    public List<RepertorySon> searchCommodityForTypeAllDao(String commodityzId) {
        SqlSession sqlSession = null;
        List<RepertorySon> repertorysonList = new ArrayList<RepertorySon>();
        try {
            System.out.println("==="+sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "merchbillReturn.crud.searchCommodityForTypeAll";
            //6、执行查询操作
            repertorysonList = sqlSession.selectList(statementKey,commodityzId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return repertorysonList;
    }

    /**
     * 4、查询商品类别父类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityTypeDao() {
        SqlSession sqlSession = null;
        List<Category> categpryList = new ArrayList<Category>();
        try {
            System.out.println("==="+sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "merchbillReturn.crud.searchCommodityTypeParent";
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
     * 5、查询商品类别子类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityDao(String catId) {
        SqlSession sqlSession = null;
        List<Category> categpryList = new ArrayList<Category>();
        try {
            //的作用：
            System.out.println("==="+sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "merchbillReturn.crud.searchCommodityType";
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
     * 6、新增单据明细表信息
     * @param receiptsDetailed
     * @return
     */
    @Override
    public int insertReceiptsDetailedInfo(ReceiptsDetailed receiptsDetailed) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //2、定义待执行statementKey(jdbc:编写待执行的SQL)
            String statementKey="merchbillReturn.crud.insertReceiptsDetailed";
            //查询数据
            rows=sqlSession.insert(statementKey,receiptsDetailed);

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
     * 7、修改入库库存明细表的信息
     * @param receiptsDetailed 条件
     * @return int
     */
    @Override
    public int updateRepertorySonInInfo(ReceiptsDetailed receiptsDetailed) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //2、定义待执行statementKey(jdbc:编写待执行的SQL)
            String statementKey="merchbillReturn.crud.updateRepertorySonInInfo";
            //查询数据
            rows=sqlSession.selectOne(statementKey,receiptsDetailed);
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
     * 8、新增单据主表信息
     * @param receipts
     * @return int
     */
    @Override
    public int insertReceiptsInfo(Receipts receipts) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //2、定义待执行statementKey(jdbc:编写待执行的SQL)
            String statementKey="merchbillReturn.crud.insertReceiptsInfo";
            //查询数据
            rows=sqlSession.selectOne(statementKey,receipts);
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
