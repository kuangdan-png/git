package com.medicine.dao.inter;

import com.medicine.pojo.Category;

import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-27-14:38
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.dao.impl
 */
public interface CommodityTypeDaoInter {
    /**
     * 查询商品类别父类别
     * @return List<Category>
     */
    List<Category> searchCommodityTypeDao();

    List<Category> searchCommodityDao(String catId);
    /**
     * 根据页面传输的条件查询类别
     * @param seniorSeclct
     * @return List<Category>
     */
    List<Category> searchCommodityseniorSeclct(String seniorSeclct);
}
