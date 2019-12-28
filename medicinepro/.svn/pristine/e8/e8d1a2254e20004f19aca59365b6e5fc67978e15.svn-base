package com.medicine.handler;

import com.medicine.pojo.*;
import com.medicine.service.inter.WareHouseManagerServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-27 15:40
 * @Description: 药品过期
 */
@Controller("wareHouseManager")
@RequestMapping("/wareHouseManager")
public class WareHouseManagerHandler {
    @Resource(name = "wareHouseManagerServiceImpl")
    private WareHouseManagerServiceInter wareHouseManagerServiceInter=null;

    public void setWareHouseManagerServiceInter(WareHouseManagerServiceInter wareHouseManagerServiceInter) {
        this.wareHouseManagerServiceInter = wareHouseManagerServiceInter;
    }




    /**
     * 查询过期药品
     * @return List<RepertorySon>
     */
    @RequestMapping(value = "/searchStaleDated.action")
    public @ResponseBody ResultMap< List<RepertorySon>>
    searchStaleDated(RepertorySon repertorySon)  {
        //查询总条数：
        int i = wareHouseManagerServiceInter.searchTotalRows(repertorySon);
        System.err.println("=======总条数==========="+i);
        List<RepertorySon> list = wareHouseManagerServiceInter.searchStaleDted(repertorySon);
        ResultMap< List<RepertorySon>> resultMap = new ResultMap<List<RepertorySon>>( "成功",list ,200,i);
        return resultMap;
    }
    /**
     * 查询仓库信息
     * @return List<Warehouse>
     */
    @RequestMapping(value = "/searchWareHourseInfo.action")
    public @ResponseBody List<Warehouse>  searchWareHourseInfo()  {
        List<Warehouse> list = wareHouseManagerServiceInter.searchWareHourseInfo();
        return  list;
    }

    /**
     * 生成主键
     * @return
     */
    @RequestMapping(value = "/seachCheckOdd.action")
    public @ResponseBody String seachCheckOdd(){
        MaxNo maxNo= new MaxNo();
        maxNo.setManName("receipts");
        maxNo.setManQu(1);
        String maxNo1 = wareHouseManagerServiceInter.getMaxNo(maxNo);
        return maxNo1;
    }

    /**
     * 查询库存数为0的药品
     * @param repertorySon
     * @return
     */
    @RequestMapping(value = "/searchWarehouseNumIsZero.action")
    public @ResponseBody ResultMap<List<Commodity>>
    searchWarehouseNumIsZero(RepertorySon repertorySon)  {
        //查询总条数：
        int i = wareHouseManagerServiceInter.searchWarehouseNumIsZeroTotalRows();
        System.err.println("=======总条数==========="+i);
        List<Commodity> list = wareHouseManagerServiceInter.searchWarehouseNumIsZero(repertorySon);
        ResultMap< List<Commodity>> resultMap = new ResultMap<List<Commodity>>( "",list ,200,i);
        return resultMap;
    }

    /**
     * 查询进货销售明细
     * @param receiptsDetailed
     * @return
     */
    @RequestMapping(value = "/searchPurchaseAndSalesDetails.action")
    public @ResponseBody ResultMap< List<Receipts>>
    searchPurchaseAndSalesDetails(ReceiptsDetailed receiptsDetailed)  {
        System.err.println("--------invoke searchPurchaseAndSalesDetails method------------");
        //查询总条数：
        int i = wareHouseManagerServiceInter.searchPurchaseAndSalesDetailsTotalRows(receiptsDetailed);
        System.err.println("=======总条数==========="+i);
        List<Receipts> list = wareHouseManagerServiceInter.searchPurchaseAndSalesDetails(receiptsDetailed);
        ResultMap< List<Receipts>> resultMap = new ResultMap<List<Receipts>>( "成功",list ,200,i);
        return resultMap;
    }

}
