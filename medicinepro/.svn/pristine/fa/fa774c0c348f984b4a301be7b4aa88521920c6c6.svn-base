package com.medicine.handler;

import com.medicine.pojo.*;
import com.medicine.service.inter.AuthorityManagerServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.Page;
import com.medicine.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author: 刘涵
 * @Date: 2019-11-23 10:59
 * @Description:
 */

/**
 * 用户登录检查及权限查询处理器
 */
@Controller("authorityManagerHandler")
@RequestMapping("/authorityManager")
public class AuthorityManagerHandler {
    //依赖业务逻辑层
    @Resource(name = "authorityManagerServiceImpl")
    private AuthorityManagerServiceInter authorityManagerServiceImpl;

    public void setUserAuthorityManagerServiceImpl(AuthorityManagerServiceInter authorityManagerServiceImpl) {
        this.authorityManagerServiceImpl = authorityManagerServiceImpl;
    }
    //获得CommandMethod 对象
    @Resource(name = "commandMethod")
    private CommandMethod commandMethod;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 查询角色信息
     * @param page
     * @return
     */
    @RequestMapping("/searchRoleInfo.action")
    @ResponseBody
    public ResultMap<List<Role>> searchRoleInfo(Page page){

        //查询角色信息
       List<Role> roleList= authorityManagerServiceImpl.searchRoleInfo(page);

       //查询角色的总条数
       int all= authorityManagerServiceImpl.searchRoleAll();

       //将数据封装给map中
       ResultMap<List<Role>> map = new ResultMap<List<Role>>("",roleList,200,all);

       //返回map对象
       return map;
    }

    /**
     * 查询角色的最大编号
     * @return
     */
    @RequestMapping("/getRolesMaxNo.action")
    @ResponseBody
    public String getRolesMaxNo(HttpServletRequest request){

        //封装对象maxNo
        MaxNo maxNo=new MaxNo();
        maxNo.setManName("role");
        //查询获得最大编号
        String puMaxNo = commandMethod.getPuMaxNo(maxNo);


        request.getSession().setAttribute("Max_NoRoles_Obj",maxNo);

        //返回最大编号
        return puMaxNo;
    }

    /**
     * 创建新角色
     * @return String
     */
    @RequestMapping("/excuteAddRoles.action")
    @ResponseBody
    public String excuteAddRoles(@RequestBody Role role, HttpServletRequest request){

        System.out.println("role" + role);

        //将数据从Request中取 Employees_Info
        Employees employees = (Employees)request.getSession().getAttribute("Employees_Info");

        //取出最大编号的信息Max_NoRoles_Obj
        MaxNo maxNo = (MaxNo)request.getSession().getAttribute("Max_NoRoles_Obj");

        //设置授权人编号
        role.setRolAuthoEmployNo(employees.getEmpNo());

        //执行新增该操作，并传递参数 role
        int rows = authorityManagerServiceImpl.excuteAddRoles(role,maxNo);

        //判断rows大于新增成功
        if ( 0 < rows) {
            return "succeed";
        }else{
            return "failure";
        }

    }

    /**
     * 获得角色信息根据角色编号
     * @return Role
     */
    @RequestMapping("/getRolesByRolNo.action")
    @ResponseBody
    public Role excuteAddRoles(Role role){

        if(null !=role){
            //执行新增该操作，并传递参数 role
            Role roles = authorityManagerServiceImpl.getRolesByRolNo(role);

            //返回查询结果
            return  roles;
        }else{
            return null;
        }


    }

    /**
     * 删除角色
     * @return Role
     */
    @RequestMapping("/deleteRolesInfo.action")
    @ResponseBody
    public String deleteRolesInfo(String rolNo){

        //执行新增该操作，并传递参数 role
        int rows = authorityManagerServiceImpl.deleteRolesInfo(rolNo);

        //判断rows大于新增成功
        if ( 0 < rows) {
            return "succeed";
        }else{
            return "failure";
        }
    }

    /**
     * 修改角色信息
     * @param role
     * @return String
     */
    @RequestMapping("/updateRolesInfo.action")
    @ResponseBody
    public String updateRolesInfo(@RequestBody Role role){
        int rows=authorityManagerServiceImpl.updateRolesInfo(role);
        //判断rows大于新增成功
        if ( 0 < rows) {
            return "succeed";
        }else{
            return "failure";
        }
    }

    /**
     * 权限查询
     * @return Role
     */
    @RequestMapping("/searchAuthorityInfo.action")
    @ResponseBody
    public ResultMap<List<Authority>> searchAuthorityInfo(Page page){

            //执行新增该操作，并传递参数 role
            List<Authority> authoritityList = authorityManagerServiceImpl.searchAuthorityInfo(page);

            //查询角色的总条数
            int all= authorityManagerServiceImpl.searchAuthorityAll();

            //将数据封装给map中
            ResultMap<List<Authority>> map = new ResultMap<List<Authority>>("",authoritityList,200,all);

            //返回map对象
            return map;
    }

    /**
     * 权限查询
     * @return Role
     */
    @RequestMapping("/searchAuthority.action")
    @ResponseBody
    public List<Authority> searchAuthority(Page page){

        //执行新增该操作，并传递参数 role
        List<Authority> authoritityList = authorityManagerServiceImpl.searchAuthorityInfo(page);

        //返回authoritityList对象
        return authoritityList;
    }


    /**
     * 查询权限的最大编号
     * @return
     */
    @RequestMapping("/getAuthorityMaxNo.action")
    @ResponseBody
    public String getAuthorityMaxNo(HttpServletRequest request){
        //封装对象maxNo
        MaxNo maxNo=new MaxNo();
        maxNo.setManName("authority");
        //查询获得最大编号
        String puMaxNo = commandMethod.getPuMaxNo(maxNo);

        request.getSession().setAttribute("Max_NoAuthority_Obj",maxNo);

        //返回最大编号
        return puMaxNo;
    }

    /**
     * 新增权限信息
     * @param authority
     * @param request
     * @return
     */
    @RequestMapping("/insertAuthority.action")
    @ResponseBody
    public String insertAuthority(@RequestBody Authority authority, HttpServletRequest request){
        //取出最大编号的信息Max_NoRoles_Obj
        MaxNo maxNo = (MaxNo)request.getSession().getAttribute("Max_NoAuthority_Obj");

        //执行新增该操作，并传递参数 role
        int rows = authorityManagerServiceImpl.insertAuthority(authority,maxNo);

        //判断rows大于新增成功
        if ( 0 < rows) {
            return "succeed";
        }else{
            return "failure";
        }

    }

    /**
     * 修改权限信息
     * @return
     */
    @RequestMapping("/updateAuthority.action")
    @ResponseBody
    public String updateAuthority(@RequestBody Authority authority){
        int rows=authorityManagerServiceImpl.updateAuthority(authority);
        //判断rows大于新增成功
        if ( 0 < rows) {
            return "succeed";
        }else{
            return "failure";
        }
    }

    /**
     * 查询员工没有被禁用的信息
     * @return LayuiTreeAuthority<List<Employees>>
     */
    @RequestMapping("/searchEmployees.action")
    @ResponseBody
    public  List<LayuiTreeAuthority<Employees>> searchEmployees(){
        //获得查询的list集合
        List<LayuiTreeAuthority<Employees>> employeesList = authorityManagerServiceImpl.searchEmployees();
        //返回数据
        return employeesList;
    }


    /**
     * 查询角色没有被禁用的信息
     * @return LayuiTreeAuthority<List<Role>>
     */
    @RequestMapping("/searchRoles.action")
    @ResponseBody
    public List<LayuiTreeAuthority<Role>> searchRoles(){

        List<LayuiTreeAuthority<Role>> layuiTreeAuthorityList = new ArrayList<>();

        //获得list集合
        List<Role> employeesList = authorityManagerServiceImpl.searchRoles();

        //循环将数据添加
        for (Role  role:employeesList){
            //声明变量 listLayuiTreeAuthority
            LayuiTreeAuthority<Role> listLayuiTreeAuthority = new LayuiTreeAuthority<>();
            listLayuiTreeAuthority.setTitle(role.getRolName());
            listLayuiTreeAuthority.setId(role.getRolNo());
            layuiTreeAuthorityList.add(listLayuiTreeAuthority);
        }
        return layuiTreeAuthorityList;
    }

    /**
     * 查询权限没有被禁用的信息
     * @return LayuiTreeAuthority<List<Role>>
     */
    @RequestMapping("/searchAuthoritys.action")
    @ResponseBody
    public List<LayuiTreeAuthority<Authority>> searchAuthoritys(){
        //声明变量存储传递到页面的数据
        List<LayuiTreeAuthority<Authority>>  list=authorityManagerServiceImpl.searchAuthoritys();
        //返回数据
        return list;
    }


    /**
     * 删除权限
     * @return String
     */
    @RequestMapping("/deleteAuthorityInfo.action")
    @ResponseBody
    public String deleteAuthorityInfo(String autNo){
        //执行新增该操作，并传递参数 role
        int rows = authorityManagerServiceImpl.deleteAuthorityInfo(autNo);

        //判断rows大于新增成功
        if ( 0 < rows) {
            return "succeed";
        }else{
            return "failure";
        }

    }
    /**
     * 获得权限信息根据权限编号
     * @return Authority
     */
    @RequestMapping("/getAuthorityByAutNo.action")
    @ResponseBody
    public Authority getAuthorityByAutNo(Authority authority){

        //执行新增该操作，并传递参数 role
        Authority authorityByAutNo = authorityManagerServiceImpl.getAuthorityByAutNo(authority);
        //返回查询结果
        return  authorityByAutNo;

    }

    /**
     * 获得role
     * @return String
     */
    @RequestMapping("/getRoleInfo.action")
    @ResponseBody
    public String getRoleInfo(@RequestBody List<LayuiTreeAuthority<Role>> role,HttpServletRequest request) {
        //判断授权操作
        if(null != role ){
            for(LayuiTreeAuthority<Role> employeesLayuiTreeAuthority:role){
                System.out.println(""+employeesLayuiTreeAuthority);
            }
            request.getSession().setAttribute("Role",role);
            return "success";
        }else{
            return "failure";
        }
    }

    /**
     * 获得employees
     * @return String
     */
    @RequestMapping("/getEmployees.action")
    @ResponseBody
    public String getEmployees(@RequestBody List<LayuiTreeAuthority<Employees>> employees,HttpServletRequest request ) {
        //判断授权操作
        if(null != employees ){
            for(LayuiTreeAuthority<Employees> employeesLayuiTreeAuthority:employees){

                System.out.println(""+employeesLayuiTreeAuthority);
            }
            request.getSession().setAttribute("Employees",employees);
            return "success";
        }else{
            return "failure";
        }
    }


    /**
     * 授权
     * @return String
     */
    @RequestMapping("/setAuthority.action")
    @ResponseBody
    public String setAuthority(@RequestBody List<LayuiTreeAuthority<Authority>> authorities,HttpServletRequest request){
        HttpSession session = request.getSession();
        //获得session中的值

        //获得角色
        List<LayuiTreeAuthority<Role>> role = (List<LayuiTreeAuthority<Role>>)session.getAttribute("Role");

        //获得员工
        List<LayuiTreeAuthority<Employees>> employees = (List<LayuiTreeAuthority<Employees>>)session.getAttribute("Employees");
        for(LayuiTreeAuthority<Employees> employeesLayuiTreeAuthority:employees){

            System.out.println(""+employeesLayuiTreeAuthority);
        }

        System.out.println("");
        System.out.println("");
        for(LayuiTreeAuthority<Role> employeesLayuiTreeAuthority:role){

            System.out.println(""+employeesLayuiTreeAuthority);
        }
        //执行授权操作
       int rows = authorityManagerServiceImpl.setAuthority(employees,authorities,role);
//        int rows=1;
        //判断授权操作
        if(rows>0){
            return "success";
        }else{
            return "failure";
        }
    }
}
