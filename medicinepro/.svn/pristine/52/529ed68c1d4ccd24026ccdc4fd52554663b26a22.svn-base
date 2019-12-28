package com.medicine.service.impl;

import com.medicine.dao.inter.UserMangerDaoInter;
import com.medicine.pojo.Authority;
import com.medicine.pojo.Employees;
import com.medicine.service.inter.UserManagerServiceInter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-02 19:36
 * @Description:用户权限业务逻辑层实现类
 */
@Service("userManagerServiceImpl")
public class UserManagerServiceImpl implements UserManagerServiceInter {
    @Resource(name="userMangerDaoImpl")
    private UserMangerDaoInter userMangerDaoInter = null;

    public void setUserMangerDaoInter(UserMangerDaoInter userMangerDaoInter) {
        this.userMangerDaoInter = userMangerDaoInter;
    }

    /**
     * 查询用户信息通过登录信息
     * @param employees
     * @return Employees
     */
    @Override
    public Employees getEmplInfoByLoginInfo(Employees employees) {

        return userMangerDaoInter.getEmplInfoByLoginInfo(employees);
    }

    /**
     * 查询菜单
     * @param employees 员工信息
     * @return Map<String,List<Authority>>
     */
    @Override
    public Map<String, List<Authority>> excuteSearchMunu(Employees employees) {
        //声明map
        Map<String, List<Authority>> map = new HashMap<String, List<Authority>>();

        //查询一级菜单
        List<Authority> authorities = searchFristMenu(employees);

        //循环赋值给map
        for (Authority authority:authorities){
            //将员工信息中的员工编号赋值给 autParentNo 传递
            authority.setAutParentNo(employees.getEmpNo());

            //根据 authority 信息查询二级菜单的数据
            List<Authority> authoritie = searchSeconedMenu(authority);

            //将父类的名称最为key，根据父类获得子类菜单存为value
            map.put(authority.getAutName(),authoritie);
        }
        //返回带有菜单信息的数据
        return map;
    }

    /**
     * 查询一级菜单
     * @return List<Authority>
     */
    public List<Authority> searchFristMenu(Employees employees) {
        return userMangerDaoInter.searchFristMenu(employees);
    }
    /**
     * 根据一级菜单编号查询二级菜单
     * @param authority 一级菜单编号
     * @return List<Authority>
     */
    public List<Authority> searchSeconedMenu(Authority authority) {
        return userMangerDaoInter.searchSeconedMenu(authority);
    }
}
