package com.medicine.service.inter;

import com.medicine.pojo.Category;

import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-27-14:30
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.service.inter
 */
public interface CommodityTypeServiceInter {
    /**
     * 查询商品类别父类别
     * @return List<Category>
     */
   public List<Category> searchCommodityType();
    /**
     * 根据商品类别父类别查询子类别
     * @return List<Category>
     */
    List<Category> searchCommodity(String catId);

    /**
     * 根据页面传输的条件查询类别
     * @param seniorSeclct
     * @return List<Category>
     */
    List<Category> searchCommodityseniorSeclct(String seniorSeclct);
}
