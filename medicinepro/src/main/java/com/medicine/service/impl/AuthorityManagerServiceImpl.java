package com.medicine.service.impl;

import com.medicine.dao.inter.AuthorityManagerDaoInter;
import com.medicine.exception.WareHouseStockException;
import com.medicine.pojo.*;
import com.medicine.service.inter.AuthorityManagerServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-05 09:10
 * @Description: 权限管理
 */
@Service("authorityManagerServiceImpl")
public class AuthorityManagerServiceImpl implements AuthorityManagerServiceInter {
    @Resource(name = "authorityManagerDaoImpl")
    private AuthorityManagerDaoInter authorityManagerDaoInter = null;

    public void setAuthorityManagerDaoInter(AuthorityManagerDaoInter authorityManagerDaoInter) {
        this.authorityManagerDaoInter = authorityManagerDaoInter;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 查询所有的角色
     *
     * @param page
     * @return
     */
    @Override
    public List<Role> searchRoleInfo(Page page) {
        page.setPage((page.getPage() - 1) * page.getlimit());
        return authorityManagerDaoInter.searchRoleInfo(page);
    }

    /**
     * 角色总条数
     *
     * @return
     */
    @Override
    public int searchRoleAll() {
        return authorityManagerDaoInter.searchRoleAll();
    }

    /**
     * 新增角色
     *
     * @param role  角色信息
     * @param maxNo
     * @return int
     */
    @Transactional(value = "dataSourceTransactionManager", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = {Exception.class, RuntimeException.class, SQLException.class})
    @Override
    public int excuteAddRoles(Role role, MaxNo maxNo) {

        //设置值 要修改的编号
        maxNo.setManSort(role.getRolNo());
        int rows = 0;
        int i1 = 0;
        //修改最大编号
        try {
            rows = authorityManagerDaoInter.excuteUpdateRolesMaxNo(maxNo);
            i1 = authorityManagerDaoInter.excuteAddRoles(role);
        } catch (WareHouseStockException e) {
            throw new WareHouseStockException("新增异常");
        } finally {
            if (0 < rows && 0 < i1) {
                return 1;
            } else {
                return 0;
            }
        }
    }


    /**
     * 根据角色编号查询角色信息
     *
     * @param role
     * @return Role
     */
    @Override
    public Role getRolesByRolNo(Role role) {
        return authorityManagerDaoInter.getRolesByRolNo(role);
    }

    /**
     * 根据角色编号删除角色信息
     *
     * @param rolNo 角色编号
     * @return int
     */
    @Override
    public int deleteRolesInfo(String rolNo) {

        //将字符串分割
        String[] split = rolNo.split(",");

        //声明变量查看成功次数
        int count = 0;

        //循环数组的数据
        for (int i = 0; i < split.length; i++) {

            //获得分割后的数据
            String rol = split[i];

            //声明角色对象，并赋值
            Role role = new Role();
            role.setRolNo(rol);

            //设置为禁用
            role.setRolStatus(1);

            //删除角色信息，即将角色的状态改为禁用
            int rows = authorityManagerDaoInter.updateRolesInfo(role);

            //当删除成功后，count累加
            if (rows > 0) {
                count++;
            }
        }

        //判断如果count==split,则说明全部删除成功了
        if (count == split.length) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 查询权限信息
     *
     * @param page 分页信息
     * @return List<Authority>
     */
    @Override
    public List<Authority> searchAuthorityInfo(Page page) {
        page.setPage((page.getPage() - 1) * page.getlimit());
        return authorityManagerDaoInter.searchAuthorityInfo(page);
    }

    /**
     * 查询权限中条数
     *
     * @return int
     */
    @Override
    public int searchAuthorityAll() {
        return authorityManagerDaoInter.searchAuthorityAll();
    }

    /**
     * 增加权限信息
     *
     * @param authority 权限
     * @param maxNo     修改最大编号
     * @return int
     */
    @Override
    public int insertAuthority(Authority authority, MaxNo maxNo) {
        //设置值 要修改的编号
        maxNo.setManSort(authority.getAutNo());

        //修改最大编号
        int i = authorityManagerDaoInter.excuteUpdateRolesMaxNo(maxNo);


        //返回权限新增的信息
        return authorityManagerDaoInter.insertAuthority(authority);
    }

    /**
     * 查询员工信息
     *
     * @return List<Employees>
     */
    @Override
    public List<LayuiTreeAuthority<Employees>> searchEmployees() {

        //声明要存储数据的list集合
        List<LayuiTreeAuthority<Employees>> list = new ArrayList<>();
        List<Employees> employeesList = authorityManagerDaoInter.searchEmployees();
        //循环将数据添加
        for (Employees employees : employeesList) {
            //声明变量 listLayuiTreeAuthority
            LayuiTreeAuthority<Employees> listLayuiTreeAuthority = new LayuiTreeAuthority<>();
            //为其赋值
            listLayuiTreeAuthority.setTitle(employees.getEmpName());
            listLayuiTreeAuthority.setId(employees.getEmpNo());
            //将 listLayuiTreeAuthority 对象添加到list 集合中
            list.add(listLayuiTreeAuthority);
        }
        return list;
    }


    /**
     * 查询角色没有被禁用的信息
     *
     * @return List<Role>
     */
    @Override
    public List<Role> searchRoles() {
        return authorityManagerDaoInter.searchRoles();
    }


    /**
     * 删除权限信息
     *
     * @param autNo
     * @return int
     */
    @Override
    public int deleteAuthorityInfo(String autNo) {
        //将字符串分割
        String[] split = autNo.split(",");
        //声明变量查看成功次数
        int count = 0;

        //循环数组的数据
        for (int i = 0; i < split.length; i++) {
            //获得分割后的数据
            String auto = split[i];

            //声明角色对象，并赋值
            Authority authority = new Authority();
            authority.setAutNo(auto);
            //删除角色信息，即将角色的状态改为禁用
            int rows = authorityManagerDaoInter.updateAuthority(authority);

            //当删除成功后，count累加
            if (rows > 0) {
                count++;
            }
        }

        //判断如果count==split,则说明全部删除成功了
        if (count == split.length) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 根据权限编号获得权限信息
     *
     * @param authority
     * @return Authority
     */
    @Override
    public Authority getAuthorityByAutNo(Authority authority) {
        return authorityManagerDaoInter.getAuthorityByAutNo(authority);
    }

    /**
     * 查询权限信息
     *
     * @return List<LayuiTreeAuthority   <   Authority>>
     */
    @Override
    public List<LayuiTreeAuthority<Authority>> searchAuthoritys() {
        List<LayuiTreeAuthority<Authority>> list = new ArrayList<LayuiTreeAuthority<Authority>>();

        List<Authority> authorityList = authorityManagerDaoInter.searchAuthority();

        //循环将数据添加
        for (Authority authority : authorityList) {
            //根据父类查询子类权限
            List<Authority> authorities = authorityManagerDaoInter.searchSencondAuthority(authority.getAutNo());
            List<LayuiTreeAuthority<Authority>> list1 = new ArrayList<LayuiTreeAuthority<Authority>>();
            for (Authority authority1 : authorities) {
                LayuiTreeAuthority<Authority> layuiTreeAuthority = new LayuiTreeAuthority<Authority>(authority1.getAutName(), authority1.getAutNo());

                list1.add(layuiTreeAuthority);
            }
            //存储子类权限
            LayuiTreeAuthority<Authority> listLayuiTreeAuthority = new LayuiTreeAuthority<Authority>(authority.getAutName(), authority.getAutNo(), list1);
            //添加权限信息
            list.add(listLayuiTreeAuthority);
        }
        return list;
    }

    /**
     * 对员工，角色，权限授权
     *
     * @param employees
     * @param authority
     * @param role
     * @return int
     */
    @Override
    public int setAuthority(List<LayuiTreeAuthority<Employees>> employees, List<LayuiTreeAuthority<Authority>> authority, List<LayuiTreeAuthority<Role>> role) {
        //判断是否成功
        int count=0;
        //1. 循环 employees 员工集合
        for (LayuiTreeAuthority<Employees> employeesLayuiTree : employees) {

            //2. 获得员工角色表的最大编号
            MaxNo maxNo = new MaxNo();
            maxNo.setManName("employees_role");
            //2.1 获得员工角色最大编号
            String puMaxNo = commandMethod.getPuMaxNo(maxNo);
            maxNo.setManSort(puMaxNo);

            //3.循环 role 集合 ，为将员工和角色关联
            for (LayuiTreeAuthority<Role> roleLayuiTree : role) {

                //4.设置初始值 员工角色和角色权限
                EmployeesRole employeesRole = new EmployeesRole(puMaxNo, employeesLayuiTree.getId(), roleLayuiTree.getId(), "");

                //5.执行新增员工角色 。角色权限
                int row = authorityManagerDaoInter.insertEmployeesRoleInfo(employeesRole);

                //6. 循环权限集合
                for (LayuiTreeAuthority<Authority> authorityLayuiTree: authority) {

                    //7. 循环二级权限
                    for (LayuiTreeAuthority<Authority> treeAuthority : authorityLayuiTree.getChildren()){

                        //8. 获得角色权限表的最大编号
                        MaxNo maxNo1 = new MaxNo();
                        maxNo1.setManName("role_authority");

                        //9.获得员工最大编号
                        String puMaxNo1 = commandMethod.getPuMaxNo(maxNo1);
                        maxNo1.setManSort(puMaxNo1);

                        //10. 封装一级权限数据
                        RoleAuthority roleAuthority = new RoleAuthority(puMaxNo1,roleLayuiTree.getId(),authorityLayuiTree.getId());

                        //11. 封装二级权限数据
                        roleAuthority.setAuthSecondMenuNo(treeAuthority.getId());

                        //12. 新增角色权限信息
                        int roleAuthorityRows = authorityManagerDaoInter.insertRoleAuthorityInfo(roleAuthority);

                        //13. 修改角色权限 最大编号
                        int i1 = commandMethod.updateMax(maxNo1);

                        count++;
                    }
                }
                //4.修改员工角色的最大编号
                int i = commandMethod.updateMax(maxNo);
            }
        }
        //获得循环次数
        int size=role.size()*employees.size()*authority.size();
        if(count==size){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 修改角色信息
     *
     * @param role
     * @return int
     */
    @Override
    public int updateRolesInfo(Role role) {
        return authorityManagerDaoInter.updateRolesInfo(role);
    }

    /**
     * 修改权限信息
     *
     * @param authority
     * @return int
     */
    @Override
    public int updateAuthority(Authority authority) {
        return authorityManagerDaoInter.updateAuthority(authority);
    }


}
