package com.medicine.service.inter;

import com.medicine.pojo.Client;
import com.medicine.pojo.ClientType;
import com.medicine.pojo.Employees;
import com.medicine.util.Page;

import java.util.List;

/**
 * @Auther:刘志成
 * @Date: 2019/11/26 0025 14:54
 * @Description:客户业务逻辑接口类
 */
public interface ClientManagerServiceInter {
    //查询
    List<Client> searchClient(Page page);

    //查询总条数
    int totalNumberOfPages();

    /**
     * 新增客户
     * @param client
     * @return
     */
    int insertClient(Client client);

    /**
     * 查询客户ID
     * @return
     */
    public String insertClientId();

    /**
     * 删除客户信息
     * @param cliID
     * @return
     */
    int deleteClient(Client client);

    /**
     * 编辑客户信息
     * @param client
     * @return
     */
    int updateClient(Client client);

    /**
     * 查询客户类型
     * @return
     */
    List<ClientType> searchClientType();

    /**
     * 新增客户类型信息
     * @param clientType
     * @return
     */
    int insertClient(ClientType clientType);

    /**
     * 客户类型主键自增
     * @return
     */
    public String insertClientTypeId();

    /**
     * 删除客户类型信息
     * @param clientType
     * @return
     */
    int deleteClientType(ClientType clientType);

    /**
     * 编辑客户类型信息
     * @param clientType
     * @return
     */
    int updateClientType(ClientType clientType);

    /**
     * 查询员工信息(联系人)
     * @return
     */
    List<Employees> searchEmployees();
}
