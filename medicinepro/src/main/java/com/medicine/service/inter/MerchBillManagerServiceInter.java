package com.medicine.service.inter;

import com.medicine.pojo.*;

import java.util.List;

/**
 * @Auther: 周宏伟
 * @Date: 2019-11-27 11:29
 * @Description: 采购进货中【老商品添加】的Service接口类
 */
public interface MerchBillManagerServiceInter {
    /**
     * 1、查询【采购进货中的老商品添加】所有的商品清单【根据商品名称或者编号模糊查询】
     * @return
     * @param val
     */
    List<RepertorySon> searchAllMerchBill(RepertorySon val);

    /**
     * 2、查询商品类别父类别
     * @return List<Category>
     */
    public List<Category> searchCommodityType();
    /**
     * 3、根据商品类别父类别查询子类别
     * @return List<Category>
     */
    List<Category> searchCommodity(String catId);

    /**
     * 4.查询所有的商品
     * @return
     */
    public List<Commodity> searchCommodityAllService();

    /**
     * 5.根据商品编号查询商品所属类型
     * @param commodityzId
     * @return
     */
    public List<RepertorySon> searchCommodityForTypeService(String commodityzId);

    /**
     * 6、查询【采购进货中的老商品添加】所有的最近进货
     * @return
     */
    List<ReceiptsDetailed> searchAllRecentStock();

    /**
     * 7、对单据表进行新增
     * @param receipts 单据主表信息
     * @param data 单据明细数据
     * @return int 影响行数
     */
    int addReceiptsDetailed(Receipts receipts, List<RepertorySon> data);
}
