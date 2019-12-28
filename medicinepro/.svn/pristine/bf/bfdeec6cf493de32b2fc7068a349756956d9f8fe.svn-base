package com.medicine.service.impl;

import com.medicine.dao.inter.CommodityManagerDaoInter;
import com.medicine.pojo.Category;
import com.medicine.pojo.Commodity;
import com.medicine.pojo.Manufacturer;
import com.medicine.service.inter.CommodityManagerServiceInter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Auther:陈涛
 * DATE: 2019-11-27-14:30
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.service.impl
 */
@Service("commodityManagerServiceImpl")
public class CommodityManagerServiceImpl implements CommodityManagerServiceInter {
    @Resource(name = "commodityManagerDaoImpl")
    private CommodityManagerDaoInter commodityTypeDaoImpl;

    public void setCommodityTypeDaoImpl(CommodityManagerDaoInter commodityTypeDaoImpl) {
        this.commodityTypeDaoImpl = commodityTypeDaoImpl;
    }

    /**
     * 查询商品类别父类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityType() {
        List<Category> categoryList=commodityTypeDaoImpl.searchCommodityTypeDao();
        return categoryList;
    }
    /**
     * 查询商品类别子类别
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodity(String catId) {
        List<Category> categoryList=commodityTypeDaoImpl.searchCommodityDao(catId);
        return categoryList;
    }
    /**
     * 根据页面传输的条件查询类别
     * @param seniorSeclct
     * @return List<Category>
     */
    @Override
    public List<Category> searchCommodityseniorSeclct(String seniorSeclct) {
        List<Category> categoryList=commodityTypeDaoImpl.searchCommodityseniorSeclct(seniorSeclct);
        return categoryList;
    }

    /**
     * 获取单位下拉列表的值
     * @return
     */
    @Override
    public List<String> searchUnit() {
        return commodityTypeDaoImpl.searchUnitDao();
    }

    /**
     * 获取所有工厂信息
     * @return
     */
    @Override
    public List<Manufacturer> searchManufacturer() {
        return commodityTypeDaoImpl.searchManufacturer();
    }

    /**
     * 查询最大编号并自动生成下一个编号
     * @return
     */
    @Override
    public String returnCommodityIdService() {
        String commodityid=commodityTypeDaoImpl.returnCOmmodityidDao();
        int comId=Integer.parseInt(commodityid)+1;
        String comIdString =comId+"";
        return comIdString;
    }


    /**
     * 新增商品信息
     * @param commodity
     * @return
     */
    @Override
    public int insertCommodityService(Commodity commodity) {
        return commodityTypeDaoImpl.insertCommodityDao(commodity);
    }

    /**
     * 根据商品类别名称查询查询出对应的商品编号
     * @param catName
     * @return
     */
    @Override
    public Category searchCatId(String catName) {
        return commodityTypeDaoImpl.searchCatId(catName);
    }

    /*查询采购进货的供货商下拉框动态获取*/
    @Override
    public List<String> searchSupplierDao() {
        return commodityTypeDaoImpl.searchSupplierDao();
    }
}
