package com.medicine.handler;

import com.medicine.pojo.Category;
import com.medicine.pojo.Commodity;
import com.medicine.pojo.Manufacturer;
import com.medicine.service.inter.CommodityManagerServiceInter;
import com.medicine.util.LayuiTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Auther:陈涛
 * DATE: 2019-11-25-19:37
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
@Controller
@RequestMapping(value = "/commodityManager")
public class CommodityManagerHandler {
    @Resource(name="commodityManagerServiceImpl")
    private CommodityManagerServiceInter commodityTypeServiceImpl;
    /**
     * 查询商品类别
     * @return
     */
    @RequestMapping("/searchCommodityParentType.action")
    public @ResponseBody List<LayuiTree<Category>>  searchCommodityParentType() {
        List<LayuiTree<Category>> layuiTreeList=layuiTreeList=new ArrayList<LayuiTree<Category>>();
        /*假如seniorSeclct为空则证明是页面初始化时的类别查询*/

            /*获取所有商品类别父类别*/
        List<Category> categoryList= commodityTypeServiceImpl.searchCommodityType();
        for (Category category :categoryList){
            /*根据商品父类别查找商品子类别*/
            List<Category> categoryList1=commodityTypeServiceImpl.searchCommodity(category.getCatId());
            /*将父类别和子类别存入layuiTree实例中使传入前台的数据时树形结构能够解析的json格式*/
            LayuiTree<Category> layuiTree=new LayuiTree<Category>(category.getTitle(), category.getCatId(), categoryList1);
            layuiTreeList.add(layuiTree);
        }
        return layuiTreeList;
    }

    /**
     * 获取单位的下拉列表值
     * @return
     */
    @RequestMapping("/selectUnit.action")
    public @ResponseBody List<String> getUnitAndId(){
        List<String> stringList=commodityTypeServiceImpl.searchUnit();
        return stringList;
    }

    /**
     * 获取生产厂商信息复制给下拉列表
     * @return
     */
    @RequestMapping("/selectManufacturer.action")
    public @ResponseBody List<Manufacturer> getManufacturer(){
        List<Manufacturer> manufacturerList=commodityTypeServiceImpl.searchManufacturer();
        return manufacturerList;
    }

    /**
     * 返回下一个商品Id
     * @return
     */
    @RequestMapping("/returnCommodityId.action")
    public @ResponseBody String returnCommodityId(){
        String commodity=commodityTypeServiceImpl.returnCommodityIdService();
        return commodity;
    }

        /**
         * 新增商品信息
         * @param commodity
         * @return
         */
        @RequestMapping("/insertCommodity.action")
        public @ResponseBody int insertCommodity(Commodity commodity){
            System.out.print("sdfghj");
            String catName=commodity.getCategoryNo();
            //catName的作用：
            System.out.println("catName================="+commodity);
            //根据类别名称查询类别编号
            Category category=commodityTypeServiceImpl.searchCatId(catName);
            System.out.println("ategory================="+category);
            //的作用：
            System.out.println("==================="+category.getCatId());
            //将查询到的类别编号重新赋值给CategoryNo
            commodity.setCategoryNo(category.getCatId());
            //进行新增
            int rows=commodityTypeServiceImpl.insertCommodityService(commodity);
            return rows;
        }


    /*查询采购进货的供货商下拉框动态获取*/
    @RequestMapping(value = "/searchSupplierDao.action")
    public @ResponseBody List<String> searchSupplierDao(){
        System.out.println("invoke searchSupplierDao method");
        //3、调用业务逻辑实现类中查询所有图书类型列表的方法，返回图书类型的集合
        List<String> comUnitList = commodityTypeServiceImpl.searchSupplierDao();
        System.out.println(comUnitList);
        return comUnitList;
    }
    }
