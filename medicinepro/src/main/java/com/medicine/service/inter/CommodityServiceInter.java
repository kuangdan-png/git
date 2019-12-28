package com.medicine.service.inter;

import com.medicine.pojo.Commodity;
import com.medicine.util.Page;

import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-29-8:08
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.service.inter
 */
public interface CommodityServiceInter {
    /**
     * 查询所有商品信息
     * @return List<Commodity>
     */
    List<Commodity> searchCommodityService(Page page);

    List<Commodity> searchCommodityAllService();

    List<Commodity> searchCommodityForTypeService(Page page, String commodityzId);

    List<Commodity> searchCommodityAllService2(String comId);

}
