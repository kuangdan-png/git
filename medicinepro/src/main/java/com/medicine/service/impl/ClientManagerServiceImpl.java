package com.medicine.service.impl;

import com.medicine.dao.impl.ClientManagerDaoImpl;
import com.medicine.dao.inter.ClientManagerDaoInter;
import com.medicine.pojo.Client;
import com.medicine.pojo.ClientType;
import com.medicine.pojo.Employees;
import com.medicine.pojo.MaxNo;
import com.medicine.service.inter.ClientManagerServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:刘志成
 * @Date: 2019/11/26 0025 14:54
 * @Description:客户业务逻辑实现类
 */
@Service(value = "clientManagerServiceImpl")
public class ClientManagerServiceImpl implements ClientManagerServiceInter {
    @Autowired
    @Qualifier(value = "clientManagerDaoImpl")
    //依赖数据访问的接口引用
    private ClientManagerDaoInter clientManagerDaoImpl;

    //提供setter方式注入
    public void setClientManagerDaoImpl(ClientManagerDaoInter clientManagerDaoImpl) {
        this.clientManagerDaoImpl = clientManagerDaoImpl;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }


    /**
     * 查询所有客户信息
     * @return List<Client>
     */
    @Transactional(readOnly = true)
    @Override
    public List<Client> searchClient(Page page) {
        return  clientManagerDaoImpl.searchClient(page);
    }

    /**
     * 查询总条数
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public int totalNumberOfPages() {
        return clientManagerDaoImpl.totalNumberOfPages();
    }

    /**
     * 新增客户
     * @param client
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public int insertClient(Client client) {
        MaxNo maxNo = new MaxNo();
        maxNo.setManName("client");
        String puMaxNo = commandMethod.getPuMaxNo(maxNo);
        maxNo.setManSort(puMaxNo);
        client.setCliID(puMaxNo);
        commandMethod.updateMax(maxNo);
        return clientManagerDaoImpl.insertClient(client);
    }

    /**
     * 查询客户编号最大的值(自动生成)
     * @return
     */
    @Override
    public String insertClientId() {
        //查询客户的最大ID并保存
        String client = clientManagerDaoImpl.insertClientId();
        System.out.println(client);
        //创建变量保存最新页面显示编号
        String newClientID = null;
        //创建变量截取后四位的数值
        String subNewClientID = null;
        //转化保存的数值为int
        int number = 0;
        if("".equals(client) || client == null){
            newClientID = "C0001";
        }else{
            subNewClientID = client.substring(1);
            number = Integer.valueOf(subNewClientID);
            number++;
            if(number >= 0 && number <= 9){
                newClientID = "C000"+number;
            }else if(number >= 10 && number <= 99){
                newClientID = "C00"+number;
            }else {
                newClientID = "C0"+number;
            }
        }
        System.out.println(newClientID);
        return newClientID;
    }

    /**
     * 删除客户信息
     * @param client
     * @return
     */
    @Override
    public int deleteClient(Client client) {
        String[] cliIDArray = client.getCliID().split(",");
        return clientManagerDaoImpl.deleteClient(cliIDArray);
    }

    /**
     * 编辑客户信息
     * @param client
     * @return
     */
    @Override
    public int updateClient(Client client) {
        return clientManagerDaoImpl.updateClient(client);
    }

    /**
     * 查询客户类型信息
     * @return
     */
    @Override
    public List<ClientType> searchClientType() {
        return clientManagerDaoImpl.searchClientType();
    }

    /**
     * 新增客户类型信息
     * @param clientType
     * @return
     */
    @Override
    public int insertClient(ClientType clientType) {
        MaxNo maxNo = new MaxNo();
        maxNo.setManName("client_type");
        String puMaxNo = commandMethod.getPuMaxNo(maxNo);
        maxNo.setManSort(puMaxNo);
        clientType.setCltID(puMaxNo);
        commandMethod.updateMax(maxNo);
        return clientManagerDaoImpl.insertClientType(clientType);
    }

    /**
     * 客户类型主键自增
     * @return
     */
    @Override
    public String insertClientTypeId() {
        //查询客户的最大ID并保存
        String clientType = clientManagerDaoImpl.insertClientTypeId();
        System.out.println(clientType);
        //创建变量保存最新页面显示编号
        String newClientID = null;
        //创建变量截取后四位的数值
        String subNewClientID = null;
        //转化保存的数值为int
        int number = 0;
        if("".equals(clientType) || clientType == null){
            newClientID = "C001";
        }else{
            subNewClientID = clientType.substring(1);
            number = Integer.valueOf(subNewClientID);
            number++;
            if(number >= 0 && number <= 9){
                newClientID = "C00"+number;
            }else if(number >= 10 && number <= 99){
                newClientID = "C0"+number;
            }else {
                newClientID = "C"+number;
            }
        }
        System.out.println(newClientID);
        return newClientID;
    }

    /**
     * 删除客户类型
     * @param clientType
     * @return
     */
    @Override
    public int deleteClientType(ClientType clientType) {
        return clientManagerDaoImpl.deleteClientType(clientType);
    }

    /**
     * 编辑客户类型
     * @param clientType
     * @return
     */
    @Override
    public int updateClientType(ClientType clientType) {
        return clientManagerDaoImpl.updateClientType(clientType);
    }

    /**
     * 查询员工信息(联系人)
     * @return
     */
    @Override
    public List<Employees> searchEmployees() {
        return clientManagerDaoImpl.searchEmployees();
    }
}
