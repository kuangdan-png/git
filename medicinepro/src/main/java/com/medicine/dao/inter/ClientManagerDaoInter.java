package com.medicine.dao.inter;

import com.medicine.pojo.Client;
import com.medicine.pojo.ClientType;
import com.medicine.pojo.Employees;
import com.medicine.util.Page;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:刘志成
 * @Date: 2019/11/26 0025 14:54
 * @Description:客户数据访问接口类
 */
public interface ClientManagerDaoInter {
    //分页查询
    @Resource(name = "sql")
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
     * 客户编号自增
     * @return ClientId 客户编号
     */
    public String insertClientId();

    /**
     * 删除客户
     * @param cliID
     * @return
     */
    int deleteClient(String[] cliID);

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
     * 新增客户类型
     * @param clientType
     * @return
     */
    int insertClientType(ClientType clientType);

    /**
     * 客户类型主键自增
     * @return
     */
    public String insertClientTypeId();

    /**
     * 删除客户类型
     * @param clientType
     * @return
     */
    int deleteClientType(ClientType clientType);

    /**
     * 编辑客户类型信息
     * @param ClientType
     * @return
     */
    int updateClientType(ClientType ClientType);

    /**
     * 查询员工信息(联系人)
     * @return
     */
    List<Employees> searchEmployees();
}
