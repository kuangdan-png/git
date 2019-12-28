package com.medicine.dao.inter;

import com.medicine.pojo.*;

import java.util.List;

/**
 * Auther:龚成
 * DATE: 2019-11-27 10:29:41
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
public interface ReturnCommodityManageDaoInter {

    /**
     * 仓库
     * @return
     */
    List<Warehouse> allwarHName();

    /**
     * 根据销售单据查询客户名称
     * @return
     */
    List<Client> clientNameList();

    /**
     * 据商品ID或者名称和客户ID模糊查询可退货商品
     * @param val
     * @param cliID
     * @param oddNum
     * @return
     */
    List<Commodity> returncommodityByNameOrId(String val, String cliID, String oddNum);

    /**
     * 查询所编辑的商品退货数量是否大于销售数量
     * @return
     * @param comId
     * @param oddNum
     */
    int ifNumBigRepertory(String comId, String oddNum);

    /**
     * 新增退货主表信息
     * @param receipts
     * @return
     */
    int insertReturnFormInfo(Receipts receipts);

    /**
     * 新增退货单据明细表
     * @param receiptsDetailed1
     * @return
     */
    int insertReturnTableInfo(ReceiptsDetailed receiptsDetailed1);

    /**
     * 保存退货单据的商品ID代入相应出货仓库表更新库存
     * @param commodity
     * @return
     */
    int updateWoreHouse(Commodity commodity);

    /**
     * 保存退货单据的商品ID代入相应出货仓库表更新库存（根据收货仓库ID增加库存 如收货仓库没有退货商品则新增一条数据 库存为退货数）
     * @param repertorySon
     */
    int insertWoreHouse(RepertorySon repertorySon);

    /**
     * 更新可退货数量
     * @param receiptsDetailed
     * @return
     */
    int updateCanReturnNum(ReceiptsDetailed receiptsDetailed);

    /**
     * 根据客户名称查询 单号下拉列表
     * @param cliID
     * @return
     */
    List<ReceiptsDetailed> searchReturnNumByCliID(String cliID);
}
