package com.medicine.dao.inter;


import com.medicine.pojo.*;

import java.util.List;

/**
 * @Auther: 郭念
 * @Date: 2019-11-26 20:52
 * @Description: 采购退货中【老商品添加】的商品清单的接口类
 */
public interface MerchBillReturnManagerDaoInter {
    /**
     * 1、根据商品编号查询【采购退货中的老商品添加】商品清单
     * @return
     */
    List<RepertorySon> searchAllMerchBillReturn(Receipts val);

    /**
     * 2、查询所有商品信息
     * @return
     */
    public List<Commodity> searchCommodityAllDao();

    /**
     * 3、根据商品类别编号查询商品信息
     * @param commodityzId
     * @return
     */
    public List<RepertorySon> searchCommodityForTypeAllDao(String commodityzId);

    /**
     * 4、查询商品类别父类别
     * @return List<Category>
     */
    public List<Category> searchCommodityTypeDao();

    /**
     * 5、查询商品类别子类别
     * @return List<Category>
     */
    public List<Category> searchCommodityDao(String catId);

    /**
     * 6、新增单据主表信息
     * @param receipts
     * @return int
     */
    int insertReceiptsInfo(Receipts receipts);

    /**
     * 7、新增单据明细表信息
     * @param receiptsDetailed
     * @return int
     */
    int insertReceiptsDetailedInfo(ReceiptsDetailed receiptsDetailed);


    /**
     * 8、修改入库库存明细表的信息
     * @param receiptsDetailed 条件
     * @return int
     */
    int updateRepertorySonInInfo(ReceiptsDetailed receiptsDetailed);
}
