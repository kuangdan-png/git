package com.medicine.handler;

import com.medicine.pojo.*;
import com.medicine.service.inter.SupplierServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.Page;
import com.medicine.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther:匡佩
 * @Date: 2019/11/25 0025 16:54
 * @Description:供货商handle类
 */
@Controller//spring(控制器组件bean)
public class SupplierHandle {
    @Autowired
    @Qualifier(value = "supplierServiceImpl")
    //1、依赖于业务逻辑接口引用(最终注入的是由spring容器完成业务逻辑实现实例的注入)
    private SupplierServiceInter supplierServiceInter;

    //2、通过提供setter方式进行注入
    public void setSupplierServiceInter(SupplierServiceInter supplierServiceInter) {
        this.supplierServiceInter = supplierServiceInter;
    }

    @Resource(name = "commandMethod")
    //1、依赖于业务逻辑接口引用(最终注入的是由spring容器完成业务逻辑实现实例的注入)
    private CommandMethod commandMethod;
    //2、通过提供setter方式进行注入
    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }
    /**
     * 获取最大的编号
     * @return String
     * value:/searchSupplierIdMax.action
     */
    @RequestMapping("/supplieManager/searchSupplierIdMax.action")
    public @ResponseBody String searchSupplierIdMax(HttpServletRequest request){
        /*//获得查询编号
        String supplierIdMax=supplierServiceInter.searchSupplierIdMax();
        //System.out.println("qwertyui"+supplierIdMax);
        //返回值*/
        MaxNo maxNo = new MaxNo();
        maxNo.setManName("supplier");
        //获得最大参数
        String supplierIdMax=commandMethod.getPuMaxNo(maxNo);
        maxNo.setManSort(supplierIdMax);
        request.getSession().setAttribute("supplier_max",maxNo);
        //System.out.println("qwertyui"+warehouseIdMax);
        //返回值
        return supplierIdMax;
    }

    /**
     * 查询供货商所以数据
     *
     * @param page 所带参数Page page
     * @return ResultMap<List<Supplier>>
     * value:/searchSuppliermapList.action
     * 与页面layui的关联
     */
    @RequestMapping(value = "/supplieManager/searchSuppliermapList.action")
    public @ResponseBody
    ResultMap<List<Supplier>> searchSupplier(Page page) {
        //关于分页的公式
        int t=page.getPage();
        int u=page.getlimit();
        page.setPage((t-1)*u);
        //返回总条数
        int rows=supplierServiceInter.currentPageNumber();

        //查询所有数据,并分页
          List<Supplier> suppliers = supplierServiceInter.searchSupplier(page);
         /* for (Supplier supplier : suppliers) {
            System.out.println(supplier);
        }*/
        //利用工具类ResultMap与把数据传至layui页面
      ResultMap<List<Supplier>> resultMap = new ResultMap<List<Supplier>>("", suppliers,0, rows);
        //返回数据
      return resultMap;
    }
    /**
     * 新增供货商信息
     * @param supplier2
     * @param proId
     * @param citId
     * @param disId
     * @return String
     * value:/supplierInsert.action
     */
    @RequestMapping(value = "/supplieManager/supplierInsert.action")
    public @ResponseBody
    String supplierInsert(@RequestBody Supplier supplier2,HttpServletRequest request,@RequestParam("proId") String proId,@RequestParam("citId") String citId,@RequestParam("disId") String disId) {
        //System.out.println("=================invoke supplierInsert method");
        //System.out.println("suasd" + supplier2);
        //System.out.println("pppppppppppppppppppppppppppp"+proId);
        //System.out.println("pppppppppppppppppppppppppppp"+citId);
        //System.out.println("pppppppppppppppppppppppppppp"+disId);
        //3、调用业务逻辑实现类的方式
        //3-1.根据页面传递是省市区编号，查询出地址表编号
        String supplier=supplierServiceInter.selectSupAddressNo(proId,citId,disId);
        //System.out.println("新增-------------------"+supplier);
        //3-2.把地址表编号赋值给供货商地址编号
        supplier2.setSupAddressNo(supplier);
        //System.out.println("新增-------------------");
        //3-3.执行新增操作
        MaxNo maxNo = (MaxNo) request.getSession().getAttribute("supplier_max");
        int rows = supplierServiceInter.insertSupplier(supplier2,maxNo);
        //System.out.println("返回条数" + rows);

        if (0 < rows) {
            return "[\"success\"]";
        } else {
            return "[\"no\"]";
        }
    }

    /**
     * 删除供货商信息
     * @param supID 所带参数@RequestParam("supID") String[] supID
     * @return String
     * value：supplierDelete.action
     */
    @RequestMapping(value = "/supplieManager/supplierDelete.action")
    public @ResponseBody
    String supplierDelete(@RequestParam("supID") String[] supID){
        //System.out.println("删除"+supID);
        //根据主键编号执行删除操作
        int rows=supplierServiceInter.deleteSupplier(supID);
        //System.out.println("删除"+rows);
        if (0 < rows) {
            return "[\"success\"]";
        } else {
            return "[\"no\"]";
        }
    }

    /**
     * 编辑
     * @param supplier
     * @param proId
     * @param citId
     * @param disId
     * @return String
     * value：supplierUpdate.action
     */
    @RequestMapping(value = "/supplieManager/supplierUpdate.action")
    public @ResponseBody
    String supplierUpdate(@RequestBody Supplier supplier,@RequestParam("proId") String proId,@RequestParam("citId") String citId,@RequestParam("disId") String disId){//@RequestParam("supplier")
        //System.out.println("=================invoke supplierInsert method");
        //System.out.println("suasd" + supplier);

        //3、调用业务逻辑实现类的方式
            //System.out.println("pppppppppppppppppppppppppppp"+proId);
            //System.out.println("pppppppppppppppppppppppppppp"+citId);
            //System.out.println("pppppppppppppppppppppppppppp"+disId);
        int rows;
        if(citId==null){
            rows = supplierServiceInter.updateSupplier(supplier);
        }else {
            //关于省市区的编辑
            String supplier2=supplierServiceInter.selectSupAddressNo(proId,citId,disId);
            //System.out.println("编辑-------------------"+supplier2);
            //判读是否进行编辑
            if(supplier2==null){
                supplier.getSupAddressNo();
            }else {
                supplier.setSupAddressNo(supplier2);
            }
            //进行编辑操作
            rows = supplierServiceInter.updateSupplier(supplier);
        }
            if (0 < rows) {
                return "[\"success\"]";
            } else {
                return "[\"no\"]";
            }

    }
    /**
     * 省
     * @return List<Province>集合
     * value：/selectAllprovince.action
     */
    @RequestMapping(value = "/supplieManager/selectAllprovince.action")
    public @ResponseBody
    List<Province> selectAllprovince() {
        //System.out.println("selectAllprovince");
        //查询所有数据
        List<Province> provinces = supplierServiceInter.selectAllprovince();

        /*for (Province province : provinces) {
            System.out.println(province);
        }*/
        //System.out.print("dfg"+provinces.size());
        //返回值
        return provinces;
    }
    /**
     * 市
     * @param processId
     * @return List<City> 集合
     * value：/selectAllCity.action
     */
    @RequestMapping(value = "/supplieManager/selectAllCity.action")
    public @ResponseBody
    List<City> selectAllCity(@RequestParam("processId") String processId) {
        //System.out.println("selectAllCity");
        //根据省编号查询所有数据
        String processIds=processId.substring(1,processId.length()-1);
        List<City> cities = supplierServiceInter.selectAllCity(processIds);
       /* for (City city : cities) {
            System.out.println(city);
        }*/
       //返回值
        return cities;
    }
    /**
     * 区
     * @return List<District> 集合
     * 所带参数cityId
     * value：/selectAllArea.action
     */
    @RequestMapping(value = "/supplieManager/selectAllArea.action")
    public @ResponseBody
    List<District> selectAllArea(@RequestParam("cityId") String cityId) {
        //System.out.println("selectAllArea");
        //根据市编号查询所有数据
        List<District> districts = supplierServiceInter.selectAllArea(cityId);

        /*for (District district : districts) {
            System.out.println(district);
        }*/
        //返回值
        return districts;
    }

    /**
     * 搜索及分页
     * @param search
     * @param page
     * @return ResultMap<List<Supplier>>
     * value：/searchselect.action
     */
    @RequestMapping(value = "/supplieManager/searchselect.action")
    public @ResponseBody
    ResultMap<List<Supplier>> searchselect(String search,Page page) {
        //关于分页
        int t = page.getPage();//当前页
        int u = page.getlimit();//每页条数
        page.setPage((t - 1) * u);
        //根据查询参数查询所有数据，及分页
        List<Supplier> suppliers = supplierServiceInter.toProduct(search,page);
        //返回所查询的总条数
        int rows = supplierServiceInter.searchselectrows(search);
        /*System.out.println("模糊查询总条数"+rows);
        for (Supplier supplier : suppliers) {
            System.out.println(supplier);
        }*/
        //利用工具类ResultMap与把数据传至layui页面
        ResultMap<List<Supplier>> resultMap = new ResultMap<List<Supplier>>("", suppliers, 0, rows);
        return resultMap;
    }
}
