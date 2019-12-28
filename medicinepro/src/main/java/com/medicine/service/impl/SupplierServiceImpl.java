package com.medicine.service.impl;

import com.medicine.dao.inter.SupplierDaoInter;
import com.medicine.pojo.*;
import com.medicine.service.inter.SupplierServiceInter;
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
 * @Date: 2019/11/25 0025 16:45
 * @Description:查询供货商Service实现类
 */
@Service(value = "supplierServiceImpl")
public class SupplierServiceImpl implements SupplierServiceInter {
    @Autowired
    @Qualifier(value = "supplierDaoImpl")
    //1、service依赖于数据访问的接口引用
    private SupplierDaoInter supplierDaoImpl;
    //2、提供setter方式进行注入
    public void setSupplierDaoImpl(SupplierDaoInter supplierDaoImpl) {
        this.supplierDaoImpl = supplierDaoImpl;
    }
    @Resource(name = "commandMethod")
    //1、依赖于业务逻辑接口引用(最终注入的是由spring容器完成业务逻辑实现实例的注入)
    private CommandMethod commandMethod;
    //2、通过提供setter方式进行注入
    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }
    /**
     * 查询所有供货商
     * @return List<Supplier> 返回集合
     * 所带参数 Page page
     * searchSupplier(page)
     *
     */
    @Transactional(readOnly = true)
    public List<Supplier> searchSupplier(Page page) {
        //封装每页显示的数据
        List<Supplier> lists = supplierDaoImpl.searchSupplier(page);
        return lists;
    }

    /**
     * 查询总条数
     * @return int类型
     * currentPageNumber()
     */
    @Transactional(readOnly = true)
    public int currentPageNumber() {
        return supplierDaoImpl.currentPageNumber();
    }

    /**
     * 新增供货商
     * @param supplier 所带参数 Supplier supplier
     * @return int类型
     */
    @Transactional(readOnly = true)
    public int insertSupplier(Supplier supplier, MaxNo maxNo) {
        commandMethod.updateMax(maxNo);
        return  supplierDaoImpl.insertSupplier(supplier);
    }

    /**
     * 删除供货商
     * @param supID 所带参数String[] supID
     * @return int类型
     */
    public int deleteSupplier(String[] supID) {
        return supplierDaoImpl.deleteSupplier(supID);
    }

    /**
     * 编辑
     * @param supplier 所带参数Supplier supplier
     * @return int类型
     */
    public int updateSupplier(Supplier supplier) {
        return supplierDaoImpl.updateSupplier(supplier);
    }

    /**
     * 省
     * @return List<Province> 集合
     */
    public List<Province> selectAllprovince() {
        return supplierDaoImpl.selectAllprovince();
    }

    /**
     * 市
     * @param processId 所带参数String processId
     * @return List<City> 集合
     */
    public List<City> selectAllCity(String processId) {
        return supplierDaoImpl.selectAllCity(processId);
    }

    /**
     * 区
     * @param cityIds 所带参数 String cityIds
     * @return List<District> 集合
     */
    public List<District> selectAllArea(String cityIds) {
        return supplierDaoImpl.selectAllArea(cityIds);
    }

    /**
     * 获取地址表编号
     * @param proId
     * @param citId
     * @param disId
     * @return String类型
     */
    public String selectSupAddressNo(String proId,String citId,String disId) {
        return supplierDaoImpl.selectSupAddressNo(proId,citId,disId);
    }

    /**
     * 搜索框
     * @param search 所带参数String search,Page page
     * @return List<Supplier>集合
     */
    public List<Supplier> toProduct(String search,Page page) {
        return supplierDaoImpl.toProduct(search,page);
    }

    /**
     * 搜索内容条数
     * 所带参数String search
     * @return int类型
     */
    public int searchselectrows(String search) {
        return supplierDaoImpl.searchselectrows(search);
    }

    /**
     * 查询最大参数
     * @return String类型
     */
    public String searchSupplierIdMax() {
        String supplierIdMax=supplierDaoImpl.searchSupplierIdMax();
        int t=Integer.parseInt(supplierIdMax.substring(3));
        String supplierId2Max=new String();
        if((t+1)<9){
            supplierId2Max="000"+(t+1);
		}else if((t+1)<99){
            supplierId2Max="00"+(t+1);
		}else if((t+1)<999){
            supplierId2Max="0"+(t+1);
		}
        return supplierIdMax.substring(0,3)+supplierId2Max;
    }
}
