package com.medicine.dao.impl;

import com.medicine.dao.inter.ClientManagerDaoInter;
import com.medicine.pojo.Client;
import com.medicine.pojo.ClientType;
import com.medicine.pojo.Employees;
import com.medicine.util.Page;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:刘志成
 * @Date: 2019/11/26 0025 14:54
 * @Description:客户数据访问实现类
 */
@Repository(value = "clientManagerDaoImpl")
public class ClientManagerDaoImpl implements ClientManagerDaoInter {
    //在数据访问bean中依赖于SqlSessionFactory(spring容器会根据配置文件完成对sessionFactory)
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;
    //提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 查询所有客户的信息
     * @return List<Client> 客户集合
     */
    @Override
    public List<Client> searchClient(Page page) {
        SqlSession sqlSession = null;
        List<Client> clients = new ArrayList<Client>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.searchClientMapList";
            //执行查询操作
            clients = sqlSession.selectList(statementKey,page);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return clients;
    }

    /**
     * 查询总条数
     * @return
     */
    @Override
    public int totalNumberOfPages(){
        SqlSession sqlSession = null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.countNum";
            //执行查询操作
            rows = sqlSession.selectOne(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 新增客户信息
     * @param client
     * @return
     */
    @Override
    public int insertClient(Client client) {
        SqlSession sqlSession = null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.clientInsert";
            //执行查询操作
            rows = sqlSession.insert(statementKey,client);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 查询客户最大编号
     * @return
     */
    @Override
    public String insertClientId() {
        SqlSession sqlSession = null;
        String clientId = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.clientId";
            //执行查询操作
            clientId = sqlSession.selectOne(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return clientId;
    }

    /**
     * 删除客户信息
     * @param cliID
     * @return
     */
    @Override
    public int deleteClient(String[] cliID) {
        SqlSession sqlSession = null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.clientDelete";
            //执行查询操作
            rows=sqlSession.delete(statementKey,cliID);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 编辑客户信息
     * @param client
     * @return
     */
    @Override
    public int updateClient(Client client) {
        SqlSession sqlSession = null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.clientUpdate";
            //执行查询操作
            rows=sqlSession.delete(statementKey,client);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 查询客户类型
     * @return
     */
    @Override
    public List<ClientType> searchClientType() {
        SqlSession sqlSession = null;
        List<ClientType> clientTypes = new ArrayList<ClientType>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.searchClientType";
            //执行查询操作
            clientTypes = sqlSession.selectList(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return clientTypes;
    }

    /**
     * 新增客户类型
     * @param clientType
     * @return
     */
    @Override
    public int insertClientType(ClientType clientType) {
        SqlSession sqlSession = null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.clientTypeInsert";
            //执行查询操作
            rows = sqlSession.insert(statementKey,clientType);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 客户类型主键自增
     * @return
     */
    @Override
    public String insertClientTypeId() {
        SqlSession sqlSession = null;
        String clientTypeId = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.clientTypeId";
            //执行查询操作
            clientTypeId = sqlSession.selectOne(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return clientTypeId;
    }

    /**
     * 删除客户类型信息
     * @param clientType
     * @return
     */
    @Override
    public int deleteClientType(ClientType clientType) {
        SqlSession sqlSession = null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.clientTypeDelete";
            //执行查询操作
            rows=sqlSession.delete(statementKey,clientType);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 编辑客户类型信息
     * @param clientType
     * @return
     */
    @Override
    public int updateClientType(ClientType clientType) {
        SqlSession sqlSession = null;
        int rows = 0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            String statementKey = "client.crud.clientTypeUpdate";
            rows = sqlSession.delete(statementKey,clientType);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 查询员工信息(联系人)
     * @return
     */
    @Override
    public List<Employees> searchEmployees() {
        SqlSession sqlSession = null;
        List<Employees> employees = new ArrayList<Employees>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "client.crud.searchEmployees";
            //执行查询操作
            employees = sqlSession.selectList(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return employees;
    }
}
