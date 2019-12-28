package com.medicine.dao.inter;

import com.medicine.pojo.*;

import java.util.List;

/**
 * @Auther: 周宏伟
 * @Date: 2019-11-26 20:52
 * @Description: 采购进货中【老商品添加】的Dao接口类
 */
public interface MerchBillManagerDaoInter {
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
    List<Category> searchCommodityTypeDao();

    /**
     *  3、根据父类查询父类的子类
     * @param catId
     * @return
     */
    List<Category> searchCommodityDao(String catId);

    /**
     * 4.查询所有的商品
     * @return
     */
    public List<Commodity> searchCommodityAllDao();

    /**
     * 5.根据商品编号查询商品所属类型
     * @param commodityzId
     * @return
     */
    public List<RepertorySon> searchCommodityForTypeAllDao(String commodityzId);

    /**
     * 6、查询【采购进货中的老商品添加】所有的最近进货
     * @return
     */
    List<ReceiptsDetailed> searchAllRecentStock();

    /**
     * 7、新增单据主表信息
     * @param receipts
     * @return int
     */
    int insertReceiptsInfo(Receipts receipts);

    /**
     * 8、新增单据明细表信息
     * @param receiptsDetailed
     * @return int
     */
    int insertReceiptsDetailedInfo(ReceiptsDetailed receiptsDetailed);


    /**
     * 9、修改入库库存明细表的信息
     * @param receiptsDetailed 条件
     * @return int
     */
    int updateRepertorySonInInfo(ReceiptsDetailed receiptsDetailed);

    /**
     * 10、查询是否存在该商品信息在库存中
     * @param commodity1 条件
     * @return int
     */
    String searchRepertorySonInfo(ReceiptsDetailed commodity1);

    /**
     * 11、新增库存明细信息
     * @return int
     * @param repertorySon 条件
     */
    int insertRepertorySonInfo(RepertorySon repertorySon);
}
