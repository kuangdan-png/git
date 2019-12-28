package com.medicine.handler;

import com.medicine.pojo.Commodity;
import com.medicine.service.inter.CommodityServiceInter;
import com.medicine.util.Page;
import com.medicine.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-29-8:02
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
@Controller
@RequestMapping("/systemsetup")
public class CommodityHandler {
    @Resource(name = "commodityServiceImpl")
    private CommodityServiceInter commodityServiceImpl;

    /**
     * 查询所有商品信息
     * @return List<Commodity>
     */
    @RequestMapping("/searchCommodity.action")
    public @ResponseBody
    ResultMap<List<Commodity>> searchCommodity(Page page){
        int pa=page.getPage();
        int row=page.getlimit();
        page.setPage((pa-1)*row);
        //查询后的商品的总条数
       List<Commodity> commodityList2=commodityServiceImpl.searchCommodityAllService();
        //分页查询所有商品信息
        List<Commodity> commodityList=commodityServiceImpl.searchCommodityService(page);
        //将商品按指定格式存储方便前台取数据
        ResultMap<List<Commodity>> listResultMap=new ResultMap<List<Commodity>>("", commodityList, 0, commodityList2.size());
for (Commodity se:commodityList){
    //se的作用：
    System.out.println("se==="+se.getSupplier());
}
        return listResultMap;
    }

    /**
     * 根据点击左边商品编号查询商品信息
     * @param page
     * @param comTypeId
     * @return
     */
    @RequestMapping("/searchCommodityForType.action")
    public @ResponseBody ResultMap<List<Commodity>> searchCommodityForType(Page page,String comTypeId){
        int pa=page.getPage();
        int row=page.getlimit();
        page.setPage((pa-1)*row);
        //pa+row的作用：
        System.out.println("pa+row==="+pa+row);
        //条件查询后的商品的总条数
        List<Commodity> commodityList2=commodityServiceImpl.searchCommodityAllService2(comTypeId);
        //分页查询所有商品信息
        List<Commodity> commodityList=commodityServiceImpl.searchCommodityForTypeService(page,comTypeId);
        //将商品按指定格式存储方便前台取数据
        ResultMap<List<Commodity>> listResultMap=new ResultMap<List<Commodity>>("", commodityList, 0, commodityList2.size());

        return listResultMap;
    }
}
