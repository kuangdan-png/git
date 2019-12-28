package com.medicine.service.inter;

import com.medicine.pojo.*;

import java.util.List;

/**
 * Auther:龚成
 * DATE: 2019-11-27 10:29:41
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
public interface ReturnCommodityManageServiceInter {
    /**
     * 仓库
     * @return
     */
    List<Warehouse> allwarHName();

    /**
     * 查询销售单据中客户名称
     * @return
     */
    List<Client> clientNameList();

    /**
     * 根据商品ID或者名称和客户ID模糊查询可退货商品
     * @param val
     * @param cliID
     * @param oddNum
     * @return
     */
    List<Commodity> returncommodityByNameOrId(String val, String cliID, String oddNum);

    /**
     * 查询所编辑的商品退货数量是否大于销售数量
     * @param comId
     * @param oddNum
     * @return
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
     * @param commoditylist
     * @return
     */
    int insertReturnTableInfo(List<Commodity> commoditylist);

    /**
     * 保存退货单据的商品ID代入相应出货仓库表更新库存
     * @param commoditylist
     * @param redDepotNo
     * @return
     */
    int updateWoreHouse(List<Commodity> commoditylist, String redDepotNo);

    /**
     * 更新可退货数量
     * @param commoditylist
     * @param oddNum1
     * @return
     */
    int updateCanReturnNum(List<Commodity> commoditylist, String oddNum1);

    /**
     * 根据客户名称查询 单号下拉列表
     * @param cliID
     * @return
     */
    List<ReceiptsDetailed> searchReturnNumByCliID(String cliID);


}
