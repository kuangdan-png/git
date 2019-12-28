package com.medicine.dao.inter;

import com.medicine.pojo.*;
import com.medicine.util.Page;

import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-27 11:29
 * @Description:权限管理
 */
public interface AuthorityManagerDaoInter {
    /**
     * 查询所有的角色
     * @return
     * @param page
     */
    List<Role> searchRoleInfo(Page page);
    /**
     * 角色总条数
     * @return
     */
    int searchRoleAll();
    /**
     * 新增角色
     * @param role 角色信息
     * @return int
     */
    int excuteAddRoles(Role role);


    /**
     * 修改最大编号
     * @param maxNo
     * @return
     */
    int excuteUpdateRolesMaxNo(MaxNo maxNo);
    /**
     * 根据角色编号查询角色信息
     * @param role
     * @return Role
     */
    Role getRolesByRolNo(Role role);
    /**
     * 根据角色编号删除角色信息
     * @param role 角色编号
     * @return int
     */
    int updateRolesInfo(Role role);
    /**
     * 查询权限信息
     * @param page 分页信息
     * @return List<Authority>
     */
    List<Authority> searchAuthorityInfo(Page page);
    /**
     * 查询权限中条数
     * @return int
     */
    int searchAuthorityAll();

    /**
     * 增加权限信息
     * @param authority
     * @return int
     */
    int insertAuthority(Authority authority);
    /**
     * 查询员工信息
     * @return  List<Employees>
     */
    List<Employees> searchEmployees();
    /**
     * 查询权限没有被禁用的信息
     * @return List<Authority>
     */
    List<Authority> searchAuthority();
    /**
     * 查询角色没有被禁用的信息
     * @return  List<Role>
     */
    List<Role> searchRoles();
    /**
     * 查询二级权限没有被禁用的信息
     * @return List<Authority>
     * @param autNo
     */
    List<Authority> searchSencondAuthority(String autNo);
    /**
     * 根据权限编号获得权限信息
     * @param authority
     * @return Authority
     */
    Authority getAuthorityByAutNo(Authority authority);
    /**
     * 删除权限信息
     * @param authority
     * @return int
     */
    int updateAuthority(Authority authority);

    /**
     * 新增角色权限信息
     * @param roleAuthority 插入条件
     * @return int
     */
    int insertRoleAuthorityInfo(RoleAuthority roleAuthority);
    /**
     * 新增员工角色信息
     * @param employeesRole 插入条件
     * @return int
     */
    int insertEmployeesRoleInfo(EmployeesRole employeesRole);
}
