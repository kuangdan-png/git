package com.medicine.dao.impl;

import com.medicine.dao.inter.ReturnCommodityManageDaoInter;
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
@Repository("returnCommodityManageDaoImpl")
public class ReturnCommodityManageDaoImpl implements ReturnCommodityManageDaoInter {
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 查询仓库下拉列表
     * @return
     */
    @Override
    public List<Warehouse> allwarHName() {
        SqlSession sqlSession = null;
        List<Warehouse> warehouse = new ArrayList<Warehouse>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "return.crud.allwarHName";
            //6、执行查询操作
            warehouse = sqlSession.selectList(statementKey);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return warehouse;
    }


    /**
     * 客户名称下拉列表
     * @return
     */
    @Override
    public List<Client> clientNameList() {
        SqlSession sqlSession = null;
        List<Client> clientList = new ArrayList<Client>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "return.crud.searchclientList";
            //6、执行查询操作
            clientList = sqlSession.selectList(statementKey);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return clientList;
    }

    /**
     * 根据商品ID或者名称和客户ID与单据号模糊查询可退货商品
     * @param val
     * @param cliID
     * @param oddNum
     * @return
     */
    @Override
    public List<Commodity> returncommodityByNameOrId(String val, String cliID, String oddNum) {
        Commodity commodity = new Commodity(val,cliID,oddNum);
        SqlSession sqlSession=null;
        List<Commodity> commodityList= new ArrayList<Commodity>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "return.crud.cominfoByIONgc";
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
     * 查询所编辑的商品退货数量是否大于销售数量（销售单据）
     * @return
     * @param comId
     * @param oddNum
     */
    @Override
    public int ifNumBigRepertory(String comId, String oddNum) {
        SqlSession sqlSession=null;
        ReceiptsDetailed receiptsDetailed = new ReceiptsDetailed(comId,oddNum);
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "return.crud.ifReturnNumBigRepertory";
            //6、执行查询操作
            fh = sqlSession.selectOne(statementKey,receiptsDetailed);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return fh;
    }

    /**
     * 新增退货主表信息
     * @param receipts
     * @return
     */
    @Override
    public int insertReturnFormInfo(Receipts receipts) {
        SqlSession sqlSession=null;
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "return.crud.comSaleinfoInsert";
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
     * 新增退货单据明细表
     * @param receiptsDetailed1
     * @return
     */
    @Override
    public int insertReturnTableInfo(ReceiptsDetailed receiptsDetailed1) {
        SqlSession sqlSession=null;
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "return.crud.comSaleTableinfoInsert";
            //6、执行查询操作
            fh = sqlSession.insert(statementKey,receiptsDetailed1);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return fh;
    }

    /**
     * 保存退货单据的商品ID代入相应出货仓库表更新库存
     * @param commodity
     * @return
     */
    @Override
    public int updateWoreHouse(Commodity commodity) {
        SqlSession sqlSession=null;
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "return.crud.updateWoreHouse";
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

    /**
     * 保存退货单据的商品ID代入相应出货仓库表更新库存（根据收货仓库ID增加库存 如收货仓库没有退货商品则新增一条数据 库存为退货数）
     * @param repertorySon
     */
    @Override
    public int insertWoreHouse(RepertorySon repertorySon) {
        SqlSession sqlSession=null;
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "return.crud.returnWoreHouseInsert";
            //6、执行查询操作
            fh = sqlSession.insert(statementKey,repertorySon);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return fh;
    }

    /**
     * 更新可退货数量
     * @param receiptsDetailed
     * @return
     */
    @Override
    public int updateCanReturnNum(ReceiptsDetailed receiptsDetailed) {
        SqlSession sqlSession=null;
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "return.crud.updateCanReturnNu";
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
     * 根据客户名称查询 单号下拉列表
     * @param cliID
     * @return
     */
    @Override
    public List<ReceiptsDetailed> searchReturnNumByCliID(String cliID) {
        SqlSession sqlSession=null;
        List<ReceiptsDetailed> commodityList= new ArrayList<ReceiptsDetailed>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "return.crud.returnNumByCliID";
            //6、执行查询操作
            commodityList = sqlSession.selectList(statementKey,cliID);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return commodityList;
    }
}
