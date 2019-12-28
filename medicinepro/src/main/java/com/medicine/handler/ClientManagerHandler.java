package com.medicine.handler;

import com.medicine.pojo.Client;
import com.medicine.pojo.ClientType;
import com.medicine.pojo.Employees;
import com.medicine.service.inter.ClientManagerServiceInter;
import com.medicine.util.Page;
import com.medicine.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther:刘志成
 * @Date: 2019/11/26 0025 14:54
 * @Description:客户信息handle类
 */
@Controller//spring控制器
public class ClientManagerHandler {
    @Autowired
    @Qualifier(value = "clientManagerServiceImpl")
    //依赖于业务逻辑接口引用(最终注入的是由spring容器完成业务逻辑实现实例的注入)
    private ClientManagerServiceInter clientManagerServiceImpl;

    //提供setter方式注入
    public void setClientManagerServiceImpl(ClientManagerServiceInter clientManagerServiceImpl) {
        this.clientManagerServiceImpl = clientManagerServiceImpl;
    }

    /**
     * 查询客户的所有信息
     *
     * @param page 分页
     * @return
     */
    @RequestMapping(value = "/searchClientMapList.action")
    public @ResponseBody
    ResultMap<List<Client>> searchClient(Page page) {
        //关于分页
        int t=page.getPage();//当前页
        int u=page.getlimit();//每页条数
        page.setPage((t-1)*u);
        //查询客户数据
        List<Client> clients = clientManagerServiceImpl.searchClient(page);
        //返回总条数
        int rows = clientManagerServiceImpl.totalNumberOfPages();
        ResultMap<List<Client>> resultMap = new ResultMap<List<Client>>("", clients, 0, rows);
        return resultMap;
    }

    /**
     * 新增客信息
     *
     * @param client
     * @return
     */
    @RequestMapping(value = "/clientInsert.action")
    public @ResponseBody
    String clientInsert(@RequestBody Client client) {
        System.out.println("=================invoke clientInsert method");
        System.out.println("cliIDnnnnnnn");
        //调用业务逻辑实现类
        int rows = clientManagerServiceImpl.insertClient(client);
        System.out.println("返回条数" + rows);
        if (0 < rows) {
            return "[\"success\"]";
        } else {
            return "[\"no\"]";
        }
    }
    /**
     * 删除客户信息
     *
     * @param client
     * @return
     */
    @RequestMapping(value = "/clientDelete.action")
    public @ResponseBody int clientDelete(Client client) {
        int rows = clientManagerServiceImpl.deleteClient(client);
        return rows;
    }

    /**
     * 编辑客户信息
     *
     * @param client
     * @return
     */
    @RequestMapping(value = "/clientUpdate.action")
    public @ResponseBody
    String clientUpdate(@RequestBody Client client) {
        int rows = clientManagerServiceImpl.updateClient(client);
        System.out.println("编辑" + rows);
        System.out.println("编辑" + client.getCliContacts());
        if (0 < rows) {
            return "[\"success\"]";
        } else {
            return "[\"no\"]";
        }
    }

    /**
     * 查询客户类型信息
     *
     * @return
     */
    @RequestMapping(value = "/searchClientType.action")
    public @ResponseBody
    ResultMap<List<ClientType>> searchClientType() {
        System.out.println("invoke searchClientType method");
        List<ClientType> clientTypeList = clientManagerServiceImpl.searchClientType();
        for (ClientType clientType : clientTypeList) {
            System.out.println(clientType);
        }
        ResultMap<List<ClientType>> listResultMap = new ResultMap<List<ClientType>>("", clientTypeList, 0, clientTypeList.size());
        return listResultMap;
    }
    /**
     * 查询客户类型信息
     *
     * @return
     */
    @RequestMapping(value = "/searchClientType2.action")
    public @ResponseBody
    List<ClientType> searchClientType2() {
        System.out.println("invoke searchClientType method");
        List<ClientType> clientTypeList = clientManagerServiceImpl.searchClientType();
        for (ClientType clientType : clientTypeList) {
            System.out.println(clientType);
        }
        return clientTypeList;
    }

    /**
     * 新增客户类型信息
     *
     * @param clientType
     * @return
     */
    @RequestMapping(value = "/clientTypeInsert.action")
    public @ResponseBody
    String clientTypeInsert(@RequestBody ClientType clientType) {
        System.out.println("============invoke clientTypeInsert method=============");
        //调用业务逻辑实现类
        int rows = clientManagerServiceImpl.insertClient(clientType);
        System.out.println("返回条数" + rows);
        if (0 < rows) {
            return "[\"success\"]";
        } else {
            return "[\"no\"]";
        }
    }

    /**
     * 客户主键自增
     *
     * @return
     */
    @RequestMapping(value = "/returnClientTypeId.action")
    public @ResponseBody
    String returnClientTypeId() {
        String clientTypeId = clientManagerServiceImpl.insertClientTypeId();
        return clientTypeId;
    }

    /**
     * 删除客户类型信息
     *
     * @param clientType
     * @return
     */
    @RequestMapping(value = "/clientTypeDelete.action")
    public @ResponseBody
    String clientTypeDelete(ClientType clientType) {
        System.out.println("删除" + clientType.getCltID());
        int rows = clientManagerServiceImpl.deleteClientType(clientType);
        System.out.println("删除" + rows);
        if (0 < rows) {
            return "[\"success\"]";
        } else {
            return "[\"no\"]";
        }
    }

    /**
     * 编辑客户类型信息
     * @param clientType
     * @return
     */
    @RequestMapping("/clientTypeUpdate.action")
    public @ResponseBody
    String clientTypeUpdate(@RequestBody ClientType clientType) {
        int rows=clientManagerServiceImpl.updateClientType(clientType);
        System.out.println("编辑"+rows);
        System.out.println("编辑"+clientType.getCltID());
        if (0 < rows) {
            return "[\"success\"]";
        } else {
            return "[\"no\"]";
        }
    }

    /**
     * 查询员工信息(联系人)
     *
     * @return
     */
    @RequestMapping(value = "/searchEmployees.action")
    public @ResponseBody
    List<Employees> searchEmployees() {
        //System.out.println("invoke searchClientType method");
        List<Employees> employeesList = clientManagerServiceImpl.searchEmployees();
        for (Employees employees : employeesList) {
            System.out.println(employees);
        }
        return employeesList;
    }

}
