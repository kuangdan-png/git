package com.medicine.handler;

import com.medicine.pojo.Category;
import com.medicine.pojo.Commodity;
import com.medicine.pojo.Manufacturer;
import com.medicine.pojo.Supplier;
import com.medicine.service.inter.ChangeCommodityServiceInter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-29-16:36
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
@Controller
@RequestMapping("/systemsetup")
public class ChangeCommodityHandler {
    @Resource(name = "changeCommodityServiceImpl")
    private ChangeCommodityServiceInter changeCommodityServiceImpl;

    public void setChangeCommodityServiceImpl(ChangeCommodityServiceInter changeCommodityServiceImpl) {
        this.changeCommodityServiceImpl = changeCommodityServiceImpl;
    }

    /**
     * 编辑商品信息
     * @param commodity
     * @return
     */
    @RequestMapping("/updateCommodity.action")
public @ResponseBody int updateCommodity(Commodity commodity){
 //commodity.getComId()的作用：
 System.out.println("commodity.getComId()==="+commodity.getComId());
        int rows=0;
        //删除要编辑的原商品信息
        int rowsd=changeCommodityServiceImpl.deleteCommodity2(commodity.getComId());
        if(rowsd>0){
        String catName=commodity.getCategoryNo();
        //catName的作用：
        System.out.println("catName==="+catName);
        Category category=changeCommodityServiceImpl.searchCatId(catName);
        //的作用：
        System.out.println("==="+category.getCatId());
        commodity.setCategoryNo(category.getCatId());
        //获取该商品编辑后的信息重新新增
        rows=changeCommodityServiceImpl.insertCommodityService(commodity);
        }
        return rows;
}
    /**
     * 新增商品信息
     * @param commodity
     * @return
     */
    @RequestMapping("/insertCommodity.action")
public @ResponseBody int insertCommodity(Commodity commodity){
        String catName=commodity.getCategoryNo();
        //catName的作用：
        System.out.println("catName==="+commodity);
        //根据类别名称查询类别编号
        Category category=changeCommodityServiceImpl.searchCatId(catName);
        //的作用：
        System.out.println("==="+category.getCatId());
        //将查询到的类别编号重新赋值给CategoryNo
        commodity.setCategoryNo(category.getCatId());
        //进行新增
        int rows=changeCommodityServiceImpl.insertCommodityService(commodity);
        return rows;
}

    /**
     * 获取单位的下拉列表值
     * @return
     */
    @RequestMapping("/selectUnit.action")
    public @ResponseBody List<String> getUnitAndId(){
        List<String> stringList=changeCommodityServiceImpl.searchUnit();
        return stringList;
    }

    /**
     * 查询所有供货商
     * @return
     */
    @RequestMapping("/getSupplier.action")
    public @ResponseBody List<Supplier> getSupplier(){
        List<Supplier> supplierList=changeCommodityServiceImpl.searchSupplier();
        return supplierList;
    }
    /**
     * 获取生产厂商信息复制给下拉列表
     * @return
     */
    @RequestMapping("/selectManufacturer.action")
    public @ResponseBody List<Manufacturer> getManufacturer(){
        List<Manufacturer> manufacturerList=changeCommodityServiceImpl.searchManufacturer();
        return manufacturerList;
    }

    /**
     * 返回下一个商品Id
     * @return
     */
    @RequestMapping("/returnCommodityId.action")
  public @ResponseBody String returnCommodityId(){
        String commodity=changeCommodityServiceImpl.returnCommodityIdService();
        return commodity;
  }

    /**
     * 删除商品信息(将商品状态从0改为1)
     * @return
     */
    @RequestMapping("/deleteCommodity.action")
  public @ResponseBody int deleteCommodity(@RequestParam("comId") String comId){
        //的作用：
        System.out.println("sadfghyjkuewrgtfhyjute45yr===");
        int rows=changeCommodityServiceImpl.deleteCommodity(comId);
        return rows;
  }
}
