package com.medicine.handler;

import com.medicine.pojo.*;
import com.medicine.service.inter.SupplierServiceInter;
import com.medicine.service.inter.WarehouseServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.Page;
import com.medicine.util.ResultMap;
import net.sf.ehcache.search.aggregator.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther:匡佩
 * @Date: 2019/11/28 0028 17:22
 * @Description:仓库管理
 */
@Controller//spring(控制器组件bean)
public class WarehouseHandle {
    @Autowired
    @Qualifier(value = "warehouseServiceImpl")
    //1、依赖于业务逻辑接口引用(最终注入的是由spring容器完成业务逻辑实现实例的注入)
    private WarehouseServiceInter warehouseServiceImpl;
    //2、通过提供setter方式进行注入
    public void setWarehouseServiceImpl(WarehouseServiceInter warehouseServiceImpl) {
        this.warehouseServiceImpl = warehouseServiceImpl;
    }

    @Resource(name = "commandMethod")
    //1、依赖于业务逻辑接口引用(最终注入的是由spring容器完成业务逻辑实现实例的注入)
    private CommandMethod commandMethod;
    //2、通过提供setter方式进行注入
    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 查询仓库所有数据及分页
     * @param page
     * @return ResultMap<List<Warehouse>>
     *  value:/searchwarehousemapList.action
     */
    @RequestMapping(value = "/warehouseManager/searchwarehousemapList.action")
    public @ResponseBody
    ResultMap<List<Warehouse>> searchWarehouses(Page page) {
        //关于分页
        int t=page.getPage();//当前页
        int u=page.getlimit();//每页条数
        page.setPage((t-1)*u);
        //查询所有数据，并分页
        List<Warehouse> warehouses = warehouseServiceImpl.searchWarehouse(page);
        //返回总条数
        int rows=warehouseServiceImpl.currentPageNumber();
        /*for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse);
        }*/
        //利用工具类ResultMap与把数据传至layui页面
        ResultMap<List<Warehouse>> resultMap = new ResultMap<List<Warehouse>>("", warehouses,0, rows);
        //返回值
        return resultMap;
    }

    /**
     * 查询仓库负责人
     * @return List<Warehouse>
     * value：/searchwarehouseempName.action
     */
    @RequestMapping(value = "/warehouseManager/searchwarehouseempName.action")
    public @ResponseBody
    List<Employees> searchwarehouseempName() {
        //System.out.println("searchwarehouseempName");
        //查询所有数据
        List<Employees> warehouses = warehouseServiceImpl.searchwarehouseempName();

        /*for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse);
        }*/
        //返回值
        return warehouses;
    }

    /**
     * 获取最大的编号
     * @return String
     * value：searchwarehouseIdMax.action
     */
    @RequestMapping("/warehouseManager/searchwarehouseIdMax.action")
    public @ResponseBody String searchwarehouseIdMax(HttpServletRequest request){
        MaxNo maxNo = new MaxNo();
        maxNo.setManName("warehouse");
        //获得最大参数
        String warehouseIdMax=commandMethod.getPuMaxNo(maxNo);
        maxNo.setManSort(warehouseIdMax);
        request.getSession().setAttribute("warehouse_max",maxNo);
        //System.out.println("qwertyui"+warehouseIdMax);
        //返回值
        return warehouseIdMax;
    }
    /**
     * 新增供货商信息
     * @param warehouse
     * @param proId
     * @param citId
     * @param disId
     * @return String
     * value：/warehouseInsert.action
     */
    @RequestMapping(value = "/warehouseManager/warehouseInsert.action")
    public @ResponseBody
    String supplierInsert(@RequestBody Warehouse warehouse,@RequestParam("proId") String proId,HttpServletRequest request,@RequestParam("citId") String citId,@RequestParam("disId") String disId) {
        //System.out.println("=================invoke supplierInsert method");
        //System.out.println("suasd" + warehouse);
        //System.out.println("pppppppppppppppppppppppppppp"+proId);
        //System.out.println("pppppppppppppppppppppppppppp"+citId);
        //System.out.println("pppppppppppppppppppppppppppp"+disId);
        //3、调用业务逻辑实现类的方式
        //3-1.根据省市区查询地址表编号

        String warehouses=warehouseServiceImpl.selectSupAddressNo(proId,citId,disId);
        //System.out.println("新增-------------------"+warehouses);
        //3-2.把地址表编号赋值给仓库表地址编号
        warehouse.setWarAddressNo(warehouses);
        //执行新增
        MaxNo maxNo = (MaxNo) request.getSession().getAttribute("warehouse_max");
        int rows = warehouseServiceImpl.insertWarehouse(warehouse,maxNo);
        //System.out.println("返回条数" + rows);
        if (0 < rows) {
            return "[\"success\"]";
        } else {
            return "[\"no\"]";
        }
    }

    /**
     * 删除供货商信息
     * @param warID String[]
     * @return String
     * value:/warehouseDelete.action
     */
    @RequestMapping(value = "/warehouseManager/warehouseDelete.action")
    public @ResponseBody
    String supplierDelete(@RequestParam("warID") String[] warID){
        //System.out.println("删除"+warID);
        //执行删除
        int rows=warehouseServiceImpl.deleteWarehouse(warID);
        //System.out.println("删除"+rows);
        if (0 < rows) {
            return "[\"success\"]";
        } else {
            return "[\"no\"]";
        }
    }

    /**
     * 编辑数据
     * @param warehouse
     * @param proId
     * @param citId
     * @param disId
     * @return String
     * value:/warehouseUpdate.action
     */
    @RequestMapping(value = "/warehouseManager/warehouseUpdate.action")
    public @ResponseBody
    String supplierUpdate(@RequestBody Warehouse warehouse,@RequestParam("proId") String proId,@RequestParam("citId") String citId,@RequestParam("disId") String disId){//@RequestParam("supplier")
       /* String a=warehouse.getEmployeesName();
        warehouse.setEmployeesNo(a);*/
       /*System.out.println("qqqqqqqqqqqqqqqqq"+warehouse.getEmployeesNo());
        System.out.println("pppppppppppppppppppppppppppp"+proId);
        System.out.println("pppppppppppppppppppppppppppp"+citId);
        System.out.println("pppppppppppppppppppppppppppp"+disId);*/

        int rows;
        if(citId==null){
            rows = warehouseServiceImpl.updateWarehouse(warehouse);
        }else {
            //根据省市区编号得到地址表编号
            String warehouses=warehouseServiceImpl.selectSupAddressNo(proId,citId,disId);
            //System.out.println("新增-------------------"+warehouses);
            //判断是否编辑地址
            if(warehouses==null){
                warehouse.getWarAddressNo();
            }else {
                warehouse.setWarAddressNo(warehouses);
            }
            //执行编辑
            rows = warehouseServiceImpl.updateWarehouse(warehouse);
        }
        //System.out.println("编辑"+rows);
        //System.out.println("编辑"+warehouse);

        if (0 < rows) {
            return "[\"success\"]";
        } else {
            return "[\"no\"]";
        }
    }

    /**
     * 省
     * @return List<Province>
     * value:/warehouseAllprovince.action
     */
    @RequestMapping(value = "/warehouseManager/warehouseAllprovince.action")
    public @ResponseBody
    List<Province> selectAllprovince() {
        System.out.println("selectAllprovince");
        //查询所有数据
        List<Province> provinces = warehouseServiceImpl.selectAllprovince();
        /*for (Province province : provinces) {
            System.out.println("省省省省省省省省省省省省省省省省省省省省省省省省省"+province);
        }*/
        //返回值
        return provinces;
    }
    /**
     * 市
     * @param processId
     * @return List<City>
     * value:/warehouseAllCity.action
     */
    @RequestMapping(value = "/warehouseManager/warehouseAllCity.action")
    public @ResponseBody
    List<City> selectAllCity(@RequestParam("processId") String processId) {
        //System.out.println("selectAllCity");
        //根据省编号查询所有数据
        String processIds=processId.substring(1,processId.length()-1);
        List<City> cities = warehouseServiceImpl.selectAllCity(processIds);
        /*for (City city : cities) {
            System.out.println(city);
        }*/
        //返回值
        return cities;
    }
    /**
     * 区
     * @param cityId
     * @return List<District>
     *  value:/warehouseAllArea.action
     */
    @RequestMapping(value = "/warehouseManager/warehouseAllArea.action")
    public @ResponseBody
    List<District> selectAllArea(@RequestParam("cityId") String cityId) {
        //System.out.println("selectAllArea");
        //根据市编号查询所有数据
        List<District> districts = warehouseServiceImpl.selectAllArea(cityId);

        /*for (District district : districts) {
            System.out.println(district);
        }*/
        //返回值
        return districts;
    }
}
