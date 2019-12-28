package com.medicine.service.impl;

import com.medicine.dao.inter.CommodityDaoInter;
import com.medicine.pojo.Commodity;
import com.medicine.service.inter.CommodityServiceInter;
import com.medicine.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-29-8:08
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.service.impl
 */
@Service("commodityServiceImpl")
public class CommodityServiceImpl implements CommodityServiceInter {
    @Resource(name = "commodityDaoImpl")
    private CommodityDaoInter commodityDaoImpl;

    /**
     * 查询所有商品信息
     * @return List<Commodity>
     */
    @Override
    public List<Commodity> searchCommodityService(Page page) {
        List<Commodity> commodityList=commodityDaoImpl.searchCommodityDao(page);
        return commodityList;
    }

    /**
     * 页面初始化时商品总条数
     * @return
     */
    @Override
    public List<Commodity> searchCommodityAllService() {
        List<Commodity> commodityList=commodityDaoImpl.searchCommodityAllDao();
        return commodityList;
    }

    /**
     * 根据商品类型查询商品信息
     * @param page
     * @param commodityzId
     * @return
     */
    @Override
    public List<Commodity> searchCommodityForTypeService(Page page,String commodityzId) {
        List<Commodity> commodityList=commodityDaoImpl.searchCommodityForTypeAllDao(page,commodityzId);
        return commodityList;
    }

    /**
     * 根据商品类别查询商品信息的总条数
     * @param comId
     * @return
     */
    @Override
    public List<Commodity> searchCommodityAllService2(String comId) {
        List<Commodity> commodityList=commodityDaoImpl.searchCommodityAllDao2(comId);
        return commodityList;
    }
}
