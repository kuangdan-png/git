package com.medicine.dao.inter;

import com.medicine.pojo.*;

import java.util.List;
/**
 * Auther:龚成
 * DATE: 2019-11-27 10:29:41
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
public interface SaleCommodityManageDaoInter  {
    /**
     * 查询代售商品
     * @return
     * @param pagegation
     */
    public List<Commodity> saleCommodityInfo(Pagegation pagegation);


    /**
     * 根据商品名称或者编号模糊查询
     * @return
     * @param val
     * @param warID
     */
    List<Commodity> commodityByNameOrId(String val, String warID);
    /**
     * 查询商品类别父类别
     * @return List<Category>
     */
    List<Category> searchCommodityTypeDao();
    /**
     * 查询商品类别子类别
     * @return List<Category>
     */
    List<Category> searchCommodityDao(String catId);
    /**
     * 根据页面传输的条件查询类别
     * @param seniorSeclct
     * @return List<Category>
     */
    List<Category> searchCommodityseniorSeclct(String seniorSeclct);

    /**
     * 根据点击获取类型ID查询商品信息
     * @param comTypeId
     * @param warID
     * @return
     */
    List<Commodity> infoByClick(String comTypeId, String warID);

    /**
     * 获取客户名称下拉列表
     * @return
     */
    List<Client> clientNameList();

    /**
     * 获取仓库名称下拉列表
     * @return
     */
    List<Warehouse> allwarHName();
    /**
     * 新增销售单据表
     * @param receipts
     * @return
     */
    int insertFormInfo(Receipts receipts);

    /**
     * 新增销售单据明细表
     * @param receiptsDetailed
     * @return
     */
    int insertTableInfo(ReceiptsDetailed receiptsDetailed);

    /**
     * 根据商品ID查询库存
     *
     * @param comId
     * @param warID
     * @return
     */
    int ifNumBigRepertory(String comId, String warID);

    /**
     * 根据销售单据的商品ID代入相应仓库表更新库存
     * @param commodity
     */
    int updateWoreHouse(Commodity commodity);

    /**
     * 查询经办人下拉列表
     * @return
     */
    List<Employees> allEmployessName();
}
