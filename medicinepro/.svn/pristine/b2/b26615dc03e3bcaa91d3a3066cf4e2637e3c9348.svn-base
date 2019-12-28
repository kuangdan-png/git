package com.medicine.dao.impl;

import com.medicine.dao.inter.AuthorityManagerDaoInter;
import com.medicine.exception.WareHouseStockException;
import com.medicine.pojo.*;
import com.medicine.util.Page;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-27 11:27
 * @Description:
 */
@Service("authorityManagerDaoImpl")
public class AuthorityManagerDaoImpl implements AuthorityManagerDaoInter {

    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;

    //2、提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    /**
     * 查询所有的角色
     * @return
     * @param page
     */
    @Override
    public List<Role> searchRoleInfo(Page page) {
        SqlSession sqlSession=null;
        List<Role> list=new ArrayList<Role>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("authorityManager.crud.searchRoleInfo",page);
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
     * 角色总条数
     * @return
     */
    @Override
    public int searchRoleAll() {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("authorityManager.crud.searchRoleAll");
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
     * 新增角色
     * @param role 角色信息
     * @return int
     */
    @Override
    public int excuteAddRoles(Role role) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.insert("authorityManager.crud.excuteAddRoles",role);
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
     * 修改最大编号
     * @param maxNo
     * @return int
     */
    @Override
    public int excuteUpdateRolesMaxNo(MaxNo maxNo) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.update("authorityManager.crud.excuteUpdateRolesMaxNo",maxNo);
            if(rows<0){
                throw new WareHouseStockException("修改最大编号异常");
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
     * 根据角色编号查询角色信息
     * @param role
     * @return Role
     */
    @Override
    public Role getRolesByRolNo(Role role) {
        SqlSession sqlSession=null;
        Role roles=null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            roles=sqlSession.selectOne("authorityManager.crud.getRolesByRolNo",role);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return roles;
    }
    /**
     * 根据角色编号删除角色信息
     * @param role 角色编号
     * @return int
     */
    @Override
    public int updateRolesInfo(Role role) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.update("authorityManager.crud.updateRolesInfo",role);
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
     * 查询权限信息
     * @param page 分页信息
     * @return List<Authority>
     */
    @Override
    public List<Authority> searchAuthorityInfo(Page page) {
        SqlSession sqlSession=null;
        List<Authority> list=new ArrayList<Authority>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("authorityManager.crud.searchAuthorityInfo",page);
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
     * 查询权限中条数
     * @return int
     */
    @Override
    public int searchAuthorityAll() {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.selectOne("authorityManager.crud.searchAuthorityAll");
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
     * 增加权限信息
     * @param authority 权限
     * @return int
     */
    @Override
    public int insertAuthority(Authority authority) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.insert("authorityManager.crud.insertAuthority",authority);
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
     * 查询员工信息
     * @return  List<Employees>
     */
    @Override
    public List<Employees> searchEmployees() {
        SqlSession sqlSession=null;
        List<Employees> list=new ArrayList<Employees>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("authorityManager.crud.searchEmployees");
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
     * 查询权限没有被禁用的信息
     * @return List<Authority>
     */
    @Override
    public List<Authority> searchAuthority() {
        SqlSession sqlSession=null;
        List<Authority> list=new ArrayList<Authority>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("authorityManager.crud.searchAuthority");
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
     * 查询角色没有被禁用的信息
     * @return  List<Role>
     */
    @Override
    public List<Role> searchRoles() {
        SqlSession sqlSession=null;
        List<Role> list=new ArrayList<Role>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("authorityManager.crud.searchRoles");
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
     * 查询二级权限没有被禁用的信息
     * @return List<Authority>
     * @param autNo
     */
    @Override
    public List<Authority> searchSencondAuthority(String autNo) {
        SqlSession sqlSession=null;
        List<Authority> list=new ArrayList<Authority>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            list=sqlSession.selectList("authorityManager.crud.searchSencondAuthority",autNo);
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
     * 根据权限编号获得权限信息
     * @param authority
     * @return Authority
     */
    @Override
    public Authority getAuthorityByAutNo(Authority authority) {
        SqlSession sqlSession=null;
        Authority authority1 = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            authority1=sqlSession.selectOne("authorityManager.crud.getAuthorityByAutNo",authority);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return authority1;
    }
    /**
     * 删除权限信息
     * @param authority
     * @return int
     */
    @Override
    public int updateAuthority(Authority authority) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.update("authorityManager.crud.updateAuthority",authority);
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
     * 新增角色权限信息
     * @param roleAuthority 插入条件
     * @return int
     */
    @Override
    public int insertRoleAuthorityInfo(RoleAuthority roleAuthority) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.update("authorityManager.crud.insertRoleAuthorityInfo",roleAuthority);
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
     * 新增员工角色信息
     * @param employeesRole 插入条件
     * @return int
     */
    @Override
    public int insertEmployeesRoleInfo(EmployeesRole employeesRole) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.update("authorityManager.crud.insertEmployeesRoleInfo",employeesRole);
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
