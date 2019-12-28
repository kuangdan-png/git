package com.medicine.shiro;

import com.medicine.dao.inter.UserMangerDaoInter;
import com.medicine.pojo.Authority;
import com.medicine.pojo.Employees;
import com.medicine.service.impl.UserManagerServiceImpl;
import com.medicine.service.inter.UserManagerServiceInter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-02 08:23
 * @Description: 认证和授权操作
 */
public class UserManagerRealm extends AuthenticatingRealm {

    @Resource(name = "userManagerServiceImpl")
    private UserManagerServiceInter userManagerServiceInter = null;

    public void setUserManagerServiceInter(UserManagerServiceInter userManagerServiceInter) {
        this.userManagerServiceInter = userManagerServiceInter;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.将token转换为UsernamePasswordToken
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //2.获取token中的登录账户
        String userCode = userToken.getUsername();
        Employees employee = new Employees();
        employee.setUserName(userCode);
        //3.查询数据库，是否存在指定的用户名和密码的用户(主键/账户/密码/账户状态/盐)
        Employees employees =null;
        employees = userManagerServiceInter.getEmplInfoByLoginInfo(employee);
        //4.1 如果没有查询到，抛出异常
        if (employees == null) {
            throw new UnknownAccountException("账户" + userCode + "不存在！");
        }else{
            //将该权限存至session中
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("Employees_Info",employees);
        }
        //4.2 如果查询到了，封装查询结果
        Object principal = employees.getUserName();
        Object credentials = employees.getUserPass();
        String realmName = this.getName();
        //盐为用户的用户名
        String salt = employees.getUserName();
        //获取盐，用于对密码在加密算法(MD5)的基础上二次加密ֵ
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, byteSalt, realmName);
        //5. 返回给调用login(token)方法
        return info;
    }

    /**
     * 授权
     * @param pc
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        /**
         * 流程
         * 1.根据用户user->2.获取角色id->3.根据角色id获取权限permission
         */
        //获得employees对象
        Employees employees=(Employees)pc.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //获取permission
        if(employees!=null) {

            //获得权限
            UserManagerServiceImpl userManagerService =(UserManagerServiceImpl)userManagerServiceInter;

            //一级菜单
            List<Authority> authorities = userManagerService.searchFristMenu(employees);

            //判断authorities
            if ( null !=authorities && 0<authorities.size()) {

                for (Authority authority:authorities){

                    //二级菜单
                    List<Authority> authorities1 = userManagerService.searchSeconedMenu(authority);

                    //判断authorities1
                    if ( null != authorities1 && 0 < authorities1.size()) {
                        for (Authority authority1:authorities1){

                            info.addStringPermission(authority1.getAutUrl());
                        }
                    }

                    info.addStringPermission(authority.getAutUrl());
                }
                return info;
            }
        }
        return null;
    }

//测试
    public static void main(String[] args) {
//
        Math.random();
    }
}
