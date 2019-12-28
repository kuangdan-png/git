package com.medicine.handler;

import com.medicine.pojo.*;
import com.medicine.service.inter.MerchBillReturnManagerServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.LayuiTree;
import com.medicine.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 郭念
 * @Date: 2019-11-27 14:01
 * @Description: 采购退货中【老商品添加】的商品清单的Handler类
 */
//springmvc 处理器bean
@Controller
@RequestMapping(value = "/MerchBillReturn")
public class MerchBillReturnHandler {
    //1、依赖业务逻辑的接口引用指向实现类
    @Resource(name = "merchBillReturnManagerServiceImpl")
    private MerchBillReturnManagerServiceInter merchBillReturnManagerServiceImpl;
    //2、通过setter方式注入
    public void setMerchBillManagerServiceImpl(MerchBillReturnManagerServiceInter merchBillReturnManagerServiceImpl) {
        this.merchBillReturnManagerServiceImpl = merchBillReturnManagerServiceImpl;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 1、查询商品清单的所有数据
     * @return
     */
    //通过@RequestMapping关联至MerchBillMapper.xml中select的id名
    @RequestMapping(value = "/searchMerchBillReturnList.action")
    public @ResponseBody List<RepertorySon> searchAllMerchBillReturn(Receipts receipts){
        System.out.println("invoke MerchBillReturnHandler searchAllMerchBillReturn method ");
        //调用业务逻辑实现类中查询所有商品清单的方法，返回商品清单的集合
        List<RepertorySon> repertorySons = merchBillReturnManagerServiceImpl.searchAllMerchBillReturn(receipts);
        System.err.println(repertorySons.size());
        return repertorySons;
    }

    /**
     * 2、根据商品类别编号查询商品信息
     * @param comTypeId
     * @return
     */
    @RequestMapping("/searchCommodityForType.action")
    public @ResponseBody
    ResultMap<List<RepertorySon>> searchCommodityForType(String comTypeId){
        System.out.println("");
        System.out.println("invoke CommodityHandler searchCommodityForType method");
        System.out.println("size:"+comTypeId);
        //调用业务逻辑层查询所有商品信息
        List<Commodity> commodityList2=merchBillReturnManagerServiceImpl.searchCommodityAllService();
        //调用业务逻辑层根据商品类别编号查询商品信息
        List<RepertorySon> repertorysonList=merchBillReturnManagerServiceImpl.searchCommodityForTypeService(comTypeId);
        for (RepertorySon repertoryson:repertorysonList){
            //com的作用：
            System.out.println("repertoryson==="+repertoryson.getCommodity().getCategory());
        }
        ResultMap<List<RepertorySon>> listResultMap=new ResultMap<List<RepertorySon>>("", repertorysonList, 0, commodityList2.size());
        return listResultMap;
    }

    /**
     * 3、查询商品类别
     * @return
     */
    @RequestMapping("/searchCommodityParentType.action")
    public @ResponseBody List<LayuiTree<Category>>  searchCommodityParentType() {
        //商品类别放入树形结构中显示
        List<LayuiTree<Category>> layuiTreeList=new ArrayList<LayuiTree<Category>>();

        /*获取所有商品类别父类别*/
        List<Category> categoryList= merchBillReturnManagerServiceImpl.searchCommodityType();
        for (Category category :categoryList){
            /*根据商品父类别查找商品子类别*/
            List<Category> categoryList1=merchBillReturnManagerServiceImpl.searchCommodity(category.getCatId());
            /*将父类别和子类别存入layuiTree实例中使传入前台的数据时树形结构能够解析的json格式*/
            LayuiTree<Category> layuiTree=new LayuiTree<Category>(category.getTitle(), category.getCatId(), categoryList1);
            layuiTreeList.add(layuiTree);
        }
        return layuiTreeList;
    }

    /**
     * 4、生成采购进货的单号
     * @param request
     * @return String
     */
    @RequestMapping(value = "/searchStockOdd.action")
    public @ResponseBody String seachAllocationOdd(HttpServletRequest request){
        //声明变量 maxNo
        MaxNo maxNo= new MaxNo();
        maxNo.setManName("receipts");
        maxNo.setManQu(7);
        //获得最大单号
        String maxNo1 =commandMethod.getOddMaxNo(maxNo);
        //返回页面显示的最大编号
        return maxNo1;
    }

    /**
     * 5、增加单据信息
     * @return  List<Employees>
     */
    @RequestMapping("/addReceiptsMessage.action")
    @ResponseBody
    public String addReceipts(Receipts receipts,HttpServletRequest request){
        if(null !=receipts ){//当 receipts 不为null时，将其存在session
            request.getSession().setAttribute("receipts",receipts);
            return "success";
        }else{
            return "failure";
        }
    }

    /**
     * 6、增加单据明细信息
     * @return  List<Employees>
     */
    @RequestMapping("/addReceiptsDetailedMessage.action")
    @ResponseBody
    public String addReceiptsDetailed(@RequestBody List<RepertorySon> data, HttpServletRequest request){
        System.out.println("receipts" + data);
        HttpSession session = request.getSession();
        Receipts receipts=(Receipts)session.getAttribute("receipts");
        //执行新增
        int rows=merchBillReturnManagerServiceImpl.addReceiptsDetailed(receipts,data);
        if(rows>0){
            return "success";
        }else{
            return "failure";
        }
    }

    /**
     * 6、增加单据明细信息
     * @return  List<Employees>
     */
    @RequestMapping("/addReceiptsDetailedMessageReturn.action")
    @ResponseBody
    public String addReceiptsDetailedReturn(@RequestBody List<ReceiptsDetailed> data, HttpServletRequest request){
        System.out.println("receipts" + data);
        HttpSession session = request.getSession();
        Receipts receipts=(Receipts)session.getAttribute("receipts");
        //执行新增
        int rows=merchBillReturnManagerServiceImpl.addReceiptsDetailedReturn(receipts,data);
        if(rows>0){
            return "success";
        }else{
            return "failure";
        }
    }
}
