package com.medicine.dao.impl;

import com.medicine.dao.inter.MerchBillManagerDaoInter;
import com.medicine.exception.WareHouseStockException;
import com.medicine.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 周宏伟
 * @Date: 2019-11-26 21:18
 * @Description: 采购进货中【老商品添加】的Dao实现类
 */
@Repository(value = "merchBillManagerDaoImpl")
public class MerchBillManagerDaoImpl implements MerchBillManagerDaoInter {
    //1、在数据访问bean中依赖于SqlSessionFactory(spring容器会根据配置文件完成对sessionFactory)
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;
    //2、提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    /**
     * 1、查询【采购进货中的老商品添加】所有的商品清单【根据商品名称或者编号模糊查询】
     * @return List<RepertorySon> 返回集合
     * @param val
     */
    @Override
    public List<RepertorySon> searchAllMerchBill(RepertorySon val) {
        SqlSession sqlSession = null;
        List<RepertorySon> repertorySonList = new ArrayList<RepertorySon>();

        try {
            sqlSession = sqlSessionFactory.openSession();
            //2、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "merchbill.crud.searchMerchBillList";
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
     * 2、查询商品类别父类别
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
            String statementKey = "merchbill.commodity.searchCommodityTypeParent";
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
     * 3、根据父类查询父类的子类
     * @param catId
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
            String statementKey = "merchbill.commodity.searchCommodityType";
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
     * 4.查询所有的商品
     * @return List<Commodity>
     */
    @Override
    public List<Commodity> searchCommodityAllDao() {
        SqlSession sqlSession = null;
        List<Commodity> commodityList = new ArrayList<Commodity>();
        try {
            System.out.println("==="+sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "merchbill.commodity.searchCommodityAll";
            //6、执行查询操作
            commodityList = sqlSession.selectList(statementKey);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return commodityList;
    }

    /**
     * 5.根据商品编号查询商品所属类型
     * @param commodityzId
     * @return List<RepertorySon>
     */
    @Override
    public List<RepertorySon> searchCommodityForTypeAllDao(String commodityzId) {
        SqlSession sqlSession = null;
        List<RepertorySon> repertorySonList = new ArrayList<RepertorySon>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "merchbill.commodity.searchCommodityForTypeAll";
            //6、执行查询操作
            repertorySonList = sqlSession.selectList(statementKey,commodityzId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
                sqlSession.close();
        }
        return repertorySonList;
    }

    /**
     * 6、查询【采购进货中的老商品添加】所有的最近进货
     * @return List<ReceiptsDetailed>
     */
    @Override
    public List<ReceiptsDetailed> searchAllRecentStock() {
        SqlSession sqlSession = null;
        List<ReceiptsDetailed> receiptsDetailedList = new ArrayList<ReceiptsDetailed>();

        try {
            sqlSession = sqlSessionFactory.openSession();
            //2、定义待执行statementKey(jdbc:编写待执行的SQL)
            String statementKey="merchbill.crud.searchRecentStockPurList";
            //3、执行查询操作
            receiptsDetailedList = sqlSession.selectList(statementKey);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //4.关闭sqlSession
            sqlSession.close();
        }
        return receiptsDetailedList;
    }
    /**
     * 7、新增单据明细表信息
     * @param receiptsDetailed
     * @return int
     */
    @Override
    public int insertReceiptsDetailedInfo(ReceiptsDetailed receiptsDetailed) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //2、定义待执行statementKey(jdbc:编写待执行的SQL)
            String statementKey="merchbill.crud.insertReceiptsDetailed";
            //查询数据
            rows=sqlSession.insert(statementKey,receiptsDetailed);
            //System.out.println("sdfghjk="+rows);
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
     * 8、修改入库库存明细表的信息
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
            String statementKey="merchbill.crud.updateRepertorySonInInfo";
            //查询数据
            rows=sqlSession.selectOne(statementKey,receiptsDetailed);
            System.out.println(" ");
            System.out.println(" "+receiptsDetailed);
            System.out.println(" ");
            System.out.println(" "+rows);
            System.out.println(" ");
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
     * 9、新增单据主表信息
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
            String statementKey="merchbill.crud.insertReceiptsInfo";
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

    /**
     * 10、查询是否存在该商品信息在库存中
     * @param repertorySon 条件
     * @return int
     */
    @Override
    public String searchRepertorySonInfo(ReceiptsDetailed repertorySon) {
        SqlSession sqlSession = null;
        String rows = "";
        try{
            sqlSession = sqlSessionFactory.openSession();
            //2、定义待执行statementKey(jdbc:编写待执行的SQL)
            String statementKey = "merchbill.crud.searchRepertorySonInfo";
            //查询数据
            rows = sqlSession.selectOne(statementKey,repertorySon);
        } catch (NullPointerException ex){
            ex.getMessage();
        } finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return rows;
    }

    /**
     * 11、新增库存明细信息
     * @return int
     * @param repertorySon 条件
     */
    @Override
    public int insertRepertorySonInfo(RepertorySon repertorySon) {
        SqlSession sqlSession = null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //2、定义待执行statementKey(jdbc:编写待执行的SQL)
            String statementKey = "merchbill.crud.insertRepertorySonInfo";
            //查询数据
            rows = sqlSession.insert(statementKey,repertorySon);
            if(rows<=0){
                throw new WareHouseStockException("新增库存明细信息异常");
            }
        } catch (NullPointerException ex){
            ex.getMessage();
        } finally {
            //判断sqlSession不为null
            if(null!=sqlSession){
                sqlSession.close();
            }
        }
        return rows;
    }
}
