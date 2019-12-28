package com.medicine.dao.impl;

import com.medicine.dao.inter.UserMangerDaoInter;
import com.medicine.pojo.Authority;
import com.medicine.pojo.Employees;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-02 08:39
 * @Description: 用户操作的数据访问层
 */
@Repository("userMangerDaoImpl")
public class UserMangerDaoImpl implements UserMangerDaoInter {
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory=null;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 查询数据库，是否存在指定的用户名和密码的用户(主键/账户/密码/账户状态/盐)
     * @param employees
     * @return
     */
    @Override
    public Employees getEmplInfoByLoginInfo(Employees employees) {
        SqlSession sqlSession=null;
        Employees employee=null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            employee=sqlSession.selectOne("userManager.crud.getEmplInfoByLoginInfo",employees);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if ( null != sqlSession) {
                sqlSession.close();
            }
        }
        return employee;
    }

    /**
     * 根据员工信息获得该员工的权限
     * @param employees 员工信息
     * @return 权限
     */
    @Override
    public List<Authority> getPermissionsByEmploy(Employees employees) {
        SqlSession sqlSession=null;
        List<Authority> authorityList=new ArrayList<Authority>();
        try{
            sqlSession = sqlSessionFactory.openSession();

            //查询数据
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if ( null != sqlSession) {
                sqlSession.close();
            }
        }
        return authorityList;
    }
    /**
     * 查询一级菜单
     * @return List<Authority>
     * @param employees
     */
    @Override
    public List<Authority> searchFristMenu(Employees employees) {
        SqlSession sqlSession=null;
        List<Authority> authorityList=new ArrayList<Authority>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            authorityList=sqlSession.selectList("userManager.crud.searchFristMenu",employees);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if ( null != sqlSession) {
                sqlSession.close();
            }
        }
        return authorityList;
    }
    /**
     * 根据一级菜单编号查询二级菜单
     * @param authority 一级菜单编号
     * @return List<Authority>
     */
    @Override
    public List<Authority> searchSeconedMenu(Authority authority) {
        SqlSession sqlSession=null;
        List<Authority> authorityList=new ArrayList<Authority>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            authorityList=sqlSession.selectList("userManager.crud.searchSeconedMenu",authority);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if ( null != sqlSession) {
                sqlSession.close();
            }
        }
        return authorityList;
    }
}
