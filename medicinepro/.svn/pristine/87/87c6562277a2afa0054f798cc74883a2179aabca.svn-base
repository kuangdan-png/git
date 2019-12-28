package com.medicine.handler;

import com.medicine.pojo.*;
import com.medicine.service.inter.MerchBillManagerServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.LayuiTree;
import net.sf.json.JSONArray;
import com.medicine.util.ResultMap;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 周宏伟
 * @Date: 2019-11-27 14:01
 * @Description: 采购进货中【老商品添加】的Handler类
 */
//springmvc 处理器bean
@Controller
@RequestMapping(value = "/merchBillManager")
public class MerchBillHandler {
    //1、依赖业务逻辑的接口引用指向实现类
    @Resource(name = "merchBillManagerServiceImpl")
    private MerchBillManagerServiceInter merchBillManagerServiceImpl;
    //2、通过setter方式注入
    public void setMerchBillManagerServiceImpl(MerchBillManagerServiceInter merchBillManagerServiceImpl) {
        this.merchBillManagerServiceImpl = merchBillManagerServiceImpl;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 1、查询商品清单的所有数据【根据商品名称或者编号模糊查询】
     * @return
     */
    //通过@RequestMapping关联至MerchBillMapper.xml中select的id名
    @RequestMapping(value = "/searchMerchBillList.action")
    public @ResponseBody List<RepertorySon> searchAllMerchBill(RepertorySon repertorySon){
        System.out.println("invoke MerchBillHandler searchAllMerchBill method ");
        //调用业务逻辑实现类中查询所有商品清单的方法，返回商品清单的集合
        List<RepertorySon> repertorySons = merchBillManagerServiceImpl.searchAllMerchBill(repertorySon);
        System.out.println(repertorySons.size());
        return repertorySons;
    }

    /**
     * 2、查询商品类别
     * @return
     */
    @RequestMapping("/searchCommodityParentType.action")
    public @ResponseBody List<LayuiTree<Category>>  searchCommodityParentType() {
        List<LayuiTree<Category>> layuiTreeList=new ArrayList<LayuiTree<Category>>();
        /*获取所有商品类别父类别*/
        List<Category> categoryList= merchBillManagerServiceImpl.searchCommodityType();
        //循环输出商品类别
        for (Category category :categoryList){
            /*根据商品父类别查找商品子类别*/
            List<Category> categoryList1=merchBillManagerServiceImpl.searchCommodity(category.getCatId());
            /*将父类别和子类别存入layuiTree实例中使传入前台的数据时树形结构能够解析的json格式*/
            LayuiTree<Category> layuiTree=new LayuiTree<Category>(category.getTitle(), category.getCatId(), categoryList1);
            //layuiTree添加至layuiTreeList中
            layuiTreeList.add(layuiTree);
        }
        return layuiTreeList;
    }

    /**
     * 3.根据商品编号查询商品所属类型[点商品类别查询商品列表的右边表格]
     * @param comTypeId
     * @return
     */
    @RequestMapping("/searchCommodityForType.action")
    public @ResponseBody ResultMap<List<RepertorySon>> searchCommodityForType(String comTypeId){
        System.out.println("invoke MerchBillHandler searchCommodityForType method");
        System.out.println("size:"+comTypeId);
        //查询所有商品信息
        List<Commodity> commodityList2=merchBillManagerServiceImpl.searchCommodityAllService();
        //查询所有商品类型信息
        List<RepertorySon> repertorySonList=merchBillManagerServiceImpl.searchCommodityForTypeService(comTypeId);
        for (RepertorySon repertorySon : repertorySonList){
            //com的作用：
            System.out.println("commodity==="+repertorySon.getCommodity().getCategory());
        }
        ResultMap<List<RepertorySon>> listResultMap=new ResultMap<List<RepertorySon>>("", repertorySonList, 0, commodityList2.size());
        return listResultMap;
    }

    /**
     * 4.查询最近进货的所有数据
     * @return
     */
    //通过@RequestMapping关联至RecentStockPurMapper.xml中select的id名
    @RequestMapping(value = "/searchRecentStockPurList.action")
    public @ResponseBody ResultMap<List<ReceiptsDetailed>> searchAllRecentStock(){
        System.out.println("invoke MerchBillHandler searchAllRecentStock method");
        //调用业务逻辑实现类中查询所有最近进货的方法，返回最近进货的集合
        List<ReceiptsDetailed> receiptsDetaileds = merchBillManagerServiceImpl.searchAllRecentStock();
        //循环输出
        for(ReceiptsDetailed receiptsDetailed : receiptsDetaileds){
            System.out.println(receiptsDetailed);
        }
        ResultMap<List<ReceiptsDetailed>> resultMap = new ResultMap<List<ReceiptsDetailed>>("",receiptsDetaileds,0,receiptsDetaileds.size());
        return resultMap;
    }

    /**
     * 5、生成采购进货的单号
     * @param request
     * @return String
     */
    @RequestMapping(value = "/searchStockOdd.action")
    public @ResponseBody String seachAllocationOdd(HttpServletRequest request){
        //声明变量 maxNo
        MaxNo maxNo= new MaxNo();
        maxNo.setManName("receipts");
        maxNo.setManQu(3);
        //获得最大单号
        String maxNo1 =commandMethod.getOddMaxNo(maxNo);
        //返回页面显示的最大编号
        return maxNo1;
    }

    /**
     * 6、增加单据信息
     * @return  List<Employees>
     */
    @RequestMapping("/addReceiptsMessage.action")
    @ResponseBody
    public String addReceipts(Receipts receipts,HttpServletRequest request){
        //当 receipts 不为null时，将其存在session
        if(null !=receipts ){
            request.getSession().setAttribute("receipts",receipts);
            return "success";
        }else{
            return "failure";
        }
    }

    /**
     * 7、增加单据明细信息
     * @return  List<Employees>
     */
    @RequestMapping("/addReceiptsDetailedMessage.action")
    @ResponseBody
    public String addReceiptsDetailed(@RequestBody List<RepertorySon> data, HttpServletRequest request){
        System.out.println("receipts" + data);
        //将单据明细存放至session中
        HttpSession session = request.getSession();
        Receipts receipts=(Receipts)session.getAttribute("receipts");
        //执行新增
        int rows=merchBillManagerServiceImpl.addReceiptsDetailed(receipts,data);
        //当rows大于0时，返回success
        if(rows>0){
            return "success";
        }else{
            return "failure";
        }
    }
}
