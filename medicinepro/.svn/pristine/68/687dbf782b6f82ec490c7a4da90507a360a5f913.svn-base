package com.medicine.service.impl;

import com.medicine.dao.inter.WarehouseDaoInter;
import com.medicine.pojo.*;
import com.medicine.service.inter.WarehouseServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:匡佩
 * @Date: 2019/11/28 0028 17:13
 * @Description:仓库管理业务逻辑实现类
 */
@Service(value = "warehouseServiceImpl")
public class WarehouseServiceImpl implements WarehouseServiceInter{
    @Autowired
    @Qualifier(value = "warehouseDaoImpl")
    //1、service依赖于数据访问的接口引用
    private WarehouseDaoInter warehouseDaoImpl;
    //2、提供setter方式进行注入
    public void setWarehouseDaoImpl(WarehouseDaoInter warehouseDaoImpl) {
        this.warehouseDaoImpl = warehouseDaoImpl;
    }

    @Resource(name = "commandMethod")
    //1、依赖于业务逻辑接口引用(最终注入的是由spring容器完成业务逻辑实现实例的注入)
    private CommandMethod commandMethod;
    //2、通过提供setter方式进行注入
    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 查询数据、分页查询
     * @param page
     * @return List<Warehouse>
     */
    @Transactional(readOnly = true)
    public List<Warehouse> searchWarehouse(Page page) {
        return warehouseDaoImpl.searchWarehouse(page);
    }

    /**
     * 查询总条数
     * @return int
     */
    @Transactional(readOnly = true)
    public int currentPageNumber() {
        return warehouseDaoImpl.currentPageNumber();
    }

    /**
     * 查询仓库负责人
     * @return List<Warehouse>
     */
    public List<Employees> searchwarehouseempName() {
        return warehouseDaoImpl.searchwarehouseempName();
    }

    /**
     * 新增数据
     * @param warehouse
     * @param maxNo
     * @return int
     */
    @Transactional(readOnly = true)
    public int insertWarehouse(Warehouse warehouse, MaxNo maxNo) {
        commandMethod.updateMax(maxNo);
        return warehouseDaoImpl.insertWarehouse(warehouse);
    }

    /**
     * 删除数据
     * @param warID
     * @return int
     */
    @Transactional(readOnly = true)
    public int deleteWarehouse(String[] warID) {
        return warehouseDaoImpl.deleteWarehouse(warID);
    }

    /**
     * 编辑数据
     * @param warehouse
     * @return int
     */
    @Transactional(readOnly = true)
    public int updateWarehouse(Warehouse warehouse) {
        return warehouseDaoImpl.updateWarehouse(warehouse);
    }

    /**
     * 省
     * @return List<Province>
     */
    public List<Province> selectAllprovince() {
        return warehouseDaoImpl.selectAllprovince();
    }

    /**
     * 市
     * @param processId
     * @return List<City>
     */
    public List<City> selectAllCity(String processId) {
        return warehouseDaoImpl.selectAllCity(processId);
    }

    /**
     * 区
     * @param cityIds
     * @return List<District>
     */
    public List<District> selectAllArea(String cityIds) {
        return warehouseDaoImpl.selectAllArea(cityIds);
    }

    /**
     * 地址表编号
     * @param proId
     * @param citId
     * @param disId
     * @return String
     */
    public String selectSupAddressNo(String proId, String citId, String disId) {
        return warehouseDaoImpl.selectSupAddressNo(proId,citId,disId);
    }

    /**
     * 最大编号，自增
     * @return String
     */
    public String searchwarehouseIdMax() {
        String warehouseIdMax=warehouseDaoImpl.searchwarehouseIdMax();
        int t=Integer.parseInt(warehouseIdMax.substring(2));
        String warehouseId2Max=new String();
        if((t+1)<9){
            warehouseId2Max="000"+(t+1);
        }else if((t+1)<99){
            warehouseId2Max="00"+(t+1);
        }else if((t+1)<999){
            warehouseId2Max="0"+(t+1);
        }
        return warehouseIdMax.substring(0,2)+warehouseId2Max;
    }
}
