package com.medicine.dao.inter;

import com.medicine.pojo.Commodity;
import com.medicine.util.Page;

import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-29-8:05
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.dao.inter
 */
public interface CommodityDaoInter {
    /**
     * 查询所有商品信息
     * @return List<Commodity>
     */
    List<Commodity> searchCommodityDao(Page page);

    List<Commodity> searchCommodityAllDao();

    List<Commodity> searchCommodityForTypeAllDao(Page page, String commodityzId);

    List<Commodity> searchCommodityAllDao2(String comId);
}
