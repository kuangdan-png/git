package com.medicine.service.inter;

import com.medicine.pojo.*;

import java.util.List;

/**
 * @Auther: 郭念
 * @Date: 2019-12-04 11:01
 * @Description: 采购退货中【老商品添加】的商品清单的Service接口类
 */
public interface MerchBillReturnManagerServiceInter {
    /**
     * 1、根据获取的商品编号或者名称模糊查询
     * @return
     * @param val
     */
    List<RepertorySon> searchAllMerchBillReturn(Receipts val);

    /**
     * 2、查询所有商品信息
     * @return
     */
    List<Commodity> searchCommodityAllService();

    /**
     * 3、根据商品类别编号查询商品信息
     * @param commodityzId
     * @return
     */
    List<RepertorySon> searchCommodityForTypeService(String commodityzId);

    /**
     * 4、查询商品类别父类别
     * @return
     */
    List<Category> searchCommodityType();

    /**
     * 5、查询商品类别子类别
     * @param catId
     * @return
     */
    List<Category> searchCommodity(String catId);

    /**
     * 6、对单据表进行新增
     * @param receipts 单据主表信息
     * @param data 单据明细数据
     * @return int 影响行数
     */
    int addReceiptsDetailed(Receipts receipts, List<RepertorySon> data);

    int addReceiptsDetailedReturn(Receipts receipts, List<ReceiptsDetailed> data);
}
