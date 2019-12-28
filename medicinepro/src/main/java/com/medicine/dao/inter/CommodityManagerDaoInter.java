package com.medicine.dao.inter;

import com.medicine.pojo.Category;
import com.medicine.pojo.Commodity;
import com.medicine.pojo.Manufacturer;

import java.util.List;

/**
 * @Auther: 陈涛
 * @Date: 2019-11-29 20:26
 * @Description:
 */
public interface CommodityManagerDaoInter {
    public List<Category> searchCommodityTypeDao();
    public List<Category> searchCommodityseniorSeclct(String seniorSeclct);
    public List<Category> searchCommodityDao(String catId);
    /**
     * 获取单位下拉列表的值
     * @return List<String>
     */
    public List<String> searchUnitDao();
    /**
     * 获取所有工厂信息
     * @return
     */
    public List<Manufacturer> searchManufacturer();

    /**
     * 获得商品最大编号
     * @return
     */
    public String returnCOmmodityidDao();

    /**
     * 新增商品信息
     * @param commodity
     * @return
     */
    public int insertCommodityDao(Commodity commodity);

    /**
     * 根据商品类别名称查询商品类别编号
     * @param catName
     * @return
     */
    public Category searchCatId(String catName);

    /*查询采购进货的供货商下拉框动态获取*/
    public List<String> searchSupplierDao();
}
