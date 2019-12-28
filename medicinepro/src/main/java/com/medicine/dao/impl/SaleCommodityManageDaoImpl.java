package com.medicine.dao.impl;

import com.medicine.dao.inter.SaleCommodityManageDaoInter;
import com.medicine.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * Auther:龚成
 * DATE: 2019-11-27 10:29:41
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
@Repository("saleCommodityManageDaoImpl")
public class SaleCommodityManageDaoImpl implements SaleCommodityManageDaoInter {
    @Resource(name="sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    /**
     * 查询代售商品
     * @return
     * @param pagegation
     */
    @Override
    public List<Commodity> saleCommodityInfo(Pagegation pagegation) {
        SqlSession sqlSession=null;
        List<Commodity> commodityList= new ArrayList<Commodity>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "sale.crud.searchsalecom";
            //6、执行查询操作
            commodityList = sqlSession.selectList(statementKey,pagegation);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }

        return commodityList;
    }


    /**
     * 根据商品名称或者编号与仓库ID模糊查询
     * @return
     * @param val
     * @param warID
     */
    @Override
    public List<Commodity> commodityByNameOrId(String val, String warID) {
        Commodity commodity = new Commodity(val,warID);
        SqlSession sqlSession=null;
        List<Commodity> commodityList= new ArrayList<Commodity>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "sale.crud.cominfoByIONgc";
            //6、执行查询操作
            commodityList = sqlSession.selectList(statementKey,commodity);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }

        return commodityList;
    }


    @Override
    public List<Category> searchCommodityTypeDao() {
        SqlSession sqlSession = null;
        List<Category> categpryList = new ArrayList<Category>();
        try {

            sqlSession = sqlSessionFactory.openSession();
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

    @Override
    public List<Category> searchCommodityDao(String catId) {
        SqlSession sqlSession = null;
        List<Category> categpryList = new ArrayList<Category>();
        try {

            sqlSession = sqlSessionFactory.openSession();
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

    @Override
    public List<Category> searchCommodityseniorSeclct(String seniorSeclct) {
        SqlSession sqlSession = null;
        List<Category> categpryList = new ArrayList<Category>();
        try {

            sqlSession = sqlSessionFactory.openSession();
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

    /**
     * 根据点击获取类型ID查询商品信息
     * @param comTypeId
     * @param warID
     * @return
     */
    @Override
    public List<Commodity> infoByClick(String comTypeId, String warID) {
        SqlSession sqlSession=null;
        Commodity commodity =new Commodity();
        commodity.setDuo4(comTypeId);
        commodity.setDuo5(warID);
        List<Commodity> commodityList= new ArrayList<Commodity>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "sale.crud.searchcominfoByClick";
            //6、执行查询操作
            commodityList = sqlSession.selectList(statementKey,commodity);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }

        return commodityList;
    }

    /**
     * 获取客户名称下拉列表
     * @return
     */
    @Override
    public List<Client> clientNameList() {
        SqlSession sqlSession=null;
        List<Client> clientList= new ArrayList<Client>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "sale.crud.searchclientList";
            //6、执行查询操作
            clientList = sqlSession.selectList(statementKey);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return clientList;
    }

    /**
     * 获取仓库名称下拉列表
     * @return
     */
    @Override
    public List<Warehouse> allwarHName() {
        SqlSession sqlSession=null;
        List<Warehouse> warehouse= new ArrayList<Warehouse>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "sale.crud.allwarHName";
            //6、执行查询操作
            warehouse = sqlSession.selectList(statementKey);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return warehouse;
    }


    /**
     * 查询经办人下拉列表
     * @return
     */
    @Override
    public List<Employees> allEmployessName() {
        SqlSession sqlSession=null;
        List<Employees> allEmployessName= new ArrayList<Employees>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "sale.crud.allEmployessName";
            //6、执行查询操作
            allEmployessName = sqlSession.selectList(statementKey);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return allEmployessName;
    }

    /**
     * 新增销售单据表
     * @param receipts
     * @return
     */
    @Override
    public int insertFormInfo(Receipts receipts) {
        SqlSession sqlSession=null;
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "sale.crud.comSaleinfoInsert";
            //6、执行查询操作
            fh = sqlSession.insert(statementKey,receipts);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return fh;
    }

    /**
     * 新增销售单据明细表
     * @param receiptsDetailed
     * @return
     */
    @Override
    public int insertTableInfo(ReceiptsDetailed receiptsDetailed) {
        SqlSession sqlSession=null;
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "sale.crud.comSaleTableinfoInsert";
            //6、执行查询操作
            fh = sqlSession.insert(statementKey,receiptsDetailed);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return fh;
    }

    /**
     * 根据商品ID与仓库ID查询库存
     * @param warID
     * @param comId
     * @return
     */
    @Override
    public int ifNumBigRepertory(String comId, String warID) {
        RepertorySon repertorySon = new RepertorySon(comId,warID);
        SqlSession sqlSession=null;
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "sale.crud.ifNumBigRepertory";
            //6、执行查询操作
            fh = sqlSession.selectOne(statementKey,repertorySon);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return fh;
    }

    /**
     * 根据销售单据的商品ID代入相应仓库表更新库存
     * @param commodity
     */
    @Override
    public int updateWoreHouse(Commodity commodity) {
        SqlSession sqlSession=null;
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "sale.crud.updateWoreHouse";
            //6、执行查询操作
            fh = sqlSession.update(statementKey,commodity);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return fh;
    }
}
