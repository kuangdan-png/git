package com.medicine.service.inter;

import com.medicine.pojo.Authority;
import com.medicine.pojo.Employees;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-02 19:35
 * @Description:用户权限操作业务逻辑层接口
 */
public interface UserManagerServiceInter {
    /**
     * 查询用户信息通过登录信息
     * @param employees
     * @return Employees
     */
    Employees getEmplInfoByLoginInfo(Employees employees);

    /**
     * 查询菜单
     * @param employees 员工信息
     * @return Map<String,List<Authority>>
     */
    Map<String,List<Authority>> excuteSearchMunu(Employees employees);
}
