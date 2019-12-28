package com.medicine.service.inter;

import com.medicine.pojo.*;
import com.medicine.util.Page;

import java.util.List;

/**
 * @Author: 刘涵
 * @Date: 2019-11-23 10:59
 * @Description: 权限设置
*/
public interface AuthorityManagerServiceInter {
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
     * @param maxNo
     * @return int
     */
    int excuteAddRoles(Role role, MaxNo maxNo);

    /**
     * 根据角色编号查询角色信息
     * @param role
     * @return Role
     */
    Role getRolesByRolNo(Role role);

    /**
     * 根据角色编号删除角色信息
     * @param rolNo 角色编号
     * @return int
     */
    int deleteRolesInfo(String rolNo);

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
     * @param authority 权限
     * @param maxNo 修改最大编号
     * @return int
     */
    int insertAuthority(Authority authority, MaxNo maxNo);

    /**
     * 查询员工信息
     * @return  List<LayuiTreeAuthority<List<Employees>>>
     */
    List<LayuiTreeAuthority<Employees>> searchEmployees();


    /**
     * 查询角色没有被禁用的信息
     * @return  List<Role>
     */
    List<Role> searchRoles();

    /**
     * 删除权限信息
     * @param autNo
     * @return
     */
    int deleteAuthorityInfo(String autNo);

    /**
     * 根据权限编号获得权限信息
     * @param authority
     * @return
     */
    Authority getAuthorityByAutNo(Authority authority);

    /**
     * 对员工，角色，权限授权
     * @param employees
     * @param authority
     * @param role
     * @return int
     */
    int setAuthority(List<LayuiTreeAuthority<Employees>> employees, List<LayuiTreeAuthority<Authority>> authority, List<LayuiTreeAuthority<Role>> role);

    /**
     * 查询权限信息
     * @return List<LayuiTreeAuthority<Authority>>
     */
    List<LayuiTreeAuthority<Authority>> searchAuthoritys();

    /**
     * 修改角色信息
     * @param role
     * @return int
     */
    int updateRolesInfo(Role role);

    /**
     * 修改权限信息
     * @param authority
     * @return int
     */
    int updateAuthority(Authority authority);
}
