package com.medicine.dao.inter;

import com.medicine.pojo.Authority;
import com.medicine.pojo.Employees;

import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-02 08:38
 * @Description:用户操作的数据访问层接口
 */
public interface UserMangerDaoInter {

    /**
     * 获得该用户的信息
     * @param employees
     * @return
     */
    Employees getEmplInfoByLoginInfo(Employees employees);

    /**
     * 获得该用户的权限
     * @param employees
     * @return
     */
    List<Authority> getPermissionsByEmploy(Employees employees);
    /**
     * 查询一级菜单
     * @return List<Authority>
     * @param employees
     */
    List<Authority> searchFristMenu(Employees employees);
    /**
     * 根据一级菜单编号查询二级菜单
     * @param authority 一级菜单编号
     * @return List<Authority>
     */
    List<Authority> searchSeconedMenu(Authority authority);
}
