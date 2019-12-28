package com.medicine.service.impl;

import com.medicine.dao.impl.CommodityTypeDaoImpl;
import com.medicine.dao.inter.CommodityTypeDaoInter;
import com.medicine.pojo.Category;
import com.medicine.service.inter.CommodityTypeServiceInter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-27-14:30
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.service.impl
 */
@Service("commodityTypeServiceImpl")
public class CommodityTypeServiceImpl implements CommodityTypeServiceInter {
    @Resource(name = "commodityTypeDaoImpl")
    private CommodityTypeDaoInter commodityTypeDaoImpl;

    public void setCommodityTypeDaoImpl(CommodityTypeDaoInter commodityTypeDaoImpl) {
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
        //catId的作用：
        System.out.println("catId==="+catId);
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
}
