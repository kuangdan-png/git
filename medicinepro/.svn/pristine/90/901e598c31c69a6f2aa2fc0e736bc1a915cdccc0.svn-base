package com.medicine.handler;

import com.medicine.pojo.Commodity;
import com.medicine.pojo.ReceiptsDetailed;
import com.medicine.service.inter.AllocationTableServiceInter;
import com.medicine.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import java.util.List;
import com.medicine.pojo.*;
import com.medicine.util.Page;

@Controller("allocationTableHandler")
@RequestMapping(value = "/allocationTableHandler")
public class AllocationTableHandler {
    @Resource(name = "allocationTableServiceImpl")
    private AllocationTableServiceInter allocationTableServiceInter;

    public void setAllocationTableServiceImpl(AllocationTableServiceInter allocationTableServiceImpl) {
        this.allocationTableServiceInter = allocationTableServiceImpl;
    }

    /**
     * 查询商品信息
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/searchAllocationTable.action")
    public @ResponseBody ResultMap<List<Commodity>> searchAllocationTable(Commodity commodity){
        System.err.println("invoke searchAllocationTable method");
        System.err.println(commodity);
        //调用业务逻辑实现类
        List<Commodity> commodityList=allocationTableServiceInter.searchAllocationTableList(commodity);

        //查询数量
        int count = allocationTableServiceInter.searchAllocationTableListSize(commodity);
        System.err.println(commodityList.size());
        ResultMap<List<Commodity>> resultMap=new ResultMap<List<Commodity>>("",  commodityList,  0,  count);
        return resultMap;
    }

    /**
     * 查询仓库信息
     * @return List<Warehouse>
     */
    @RequestMapping(value = "/searchWareHourseInfo.action")
    public @ResponseBody List<Warehouse>  searchWareHourseInfo(Model model,Warehouse warehouse)  {
        List<Warehouse> list = allocationTableServiceInter.searchWareHourseInfo(warehouse);
        return list;
    }

}
