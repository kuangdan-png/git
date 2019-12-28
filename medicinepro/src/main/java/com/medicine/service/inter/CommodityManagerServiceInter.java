package com.medicine.service.inter;

import com.medicine.pojo.Category;
import com.medicine.pojo.Commodity;
import com.medicine.pojo.Manufacturer;

import java.util.List;

/**
 * @Auther: 陈涛
 * @Date: 2019-11-29 20:30
 * @Description:
 */
public interface CommodityManagerServiceInter {
    public List<Category> searchCommodityType();
    public List<Category> searchCommodity(String catId);
    public List<Category> searchCommodityseniorSeclct(String seniorSeclct);

    /**
     * 获取单位下拉列表的值
     * @return
     */
    public List<String> searchUnit();

    /**
     * 获取所有工厂信息
     * @return
     */
    public List<Manufacturer> searchManufacturer();

    /**
     * 查询最大编号并自动生成下一个编号
     * @return
     */
    public String returnCommodityIdService();

    /**
     * 新增商品信息
     * @param commodity
     * @return
     */
    public int insertCommodityService(Commodity commodity);

    /**
     * 根据商品类别名称查询查询出对应的商品编号
     * @param catName
     * @return
     */
    public Category searchCatId(String catName);

    /*查询采购进货的供货商下拉框动态获取*/
    public List<String> searchSupplierDao();
}
