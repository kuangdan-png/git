package com.medicine.handler;

import com.medicine.pojo.*;
import com.medicine.service.inter.AllocationManagerServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.Page;
import com.medicine.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-07 15:24
 * @Description:库存调拨
 */
@Controller("allocationManager")
@RequestMapping("/allocationManager")
public class AllocationManagerHandler {
    @Resource(name = "allocationManagerServiceImpl")
    private AllocationManagerServiceInter allocationManagerServiceInter= null;

    public void setAllocationManagerServiceInter(AllocationManagerServiceInter allocationManagerServiceInter) {
        this.allocationManagerServiceInter = allocationManagerServiceInter;
    }
    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 生成库存调拨的单号
     * @param request
     * @return String
     */
    @RequestMapping(value = "/seachAllocationOdd.action")
    public @ResponseBody
    String seachAllocationOdd(HttpServletRequest request){

        //声明变量 maxNo
        MaxNo maxNo= new MaxNo();
        maxNo.setManName("receipts");
        maxNo.setManQu(2);

        //获得最大单号
        String maxNo1 =commandMethod.getOddMaxNo(maxNo);

        //将最大单号存入MaxNo_AllocationOdd中
        request.getSession().setAttribute("MaxNo_AllocationOdd",maxNo1);
        //返回页面显示的最大编号
        return maxNo1;
    }

    /**
     * 获得商品清单信息
     * @param repertorySon
     * @return ResultMap< List<RepertorySon>>
     */
    @RequestMapping(value = "/searchCommidyInfo.action")
    public @ResponseBody
    ResultMap< List<RepertorySon>> searchCommidyInfo(RepertorySon repertorySon, Page page){
        System.out.println("");
        System.out.println("" + repertorySon);
        //查询商品清单信息
        List<RepertorySon> list = allocationManagerServiceInter.searchCommidyInfo(repertorySon,page);

        //查询商品清单信息总条数
        int i = allocationManagerServiceInter.searchCommidyInfoSize(repertorySon);

        //将商品清单信息和商品清单信息的总条数，
        // 封装在 listResultMap 中传递给页面的table显示
        ResultMap< List<RepertorySon>> listResultMap = new ResultMap<List<RepertorySon>>("",list,0,i);

        //返回查询的数据
        return listResultMap;
    }

    /**
     * 查询经办人
     * @return  List<Employees>
     */
    @RequestMapping("/searchEmployeesJin.action")
    @ResponseBody
    public List<Employees> searchEmployeesJin(HttpServletRequest request){
        //获得当前用户的信息保存在 employees
        Employees employees=(Employees)request.getSession().getAttribute("Employees_Info");
        //将 employees 作为参数传递
        List<Employees> employees1 = allocationManagerServiceInter.searchEmployeesJin(employees);
        //返回经办人信息
        return employees1;
    }

    /**
     * 增加单据信息
     * @return  List<Employees>
     */
    @RequestMapping("/addReceipts.action")
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
     * 增加单据明细信息
     * @return  List<Employees>
     */
    @RequestMapping("/addReceiptsDetailed.action")
    @ResponseBody
    public String addReceiptsDetailed(@RequestBody List<RepertorySon> data,HttpServletRequest request){
        System.out.println("receipts" + data);
        HttpSession session = request.getSession();
        Receipts receipts=(Receipts)session.getAttribute("receipts");
        //执行新增
        int rows=allocationManagerServiceInter.addReceiptsDetailed(receipts,data);
//        System.err.println(""+rows);
        if(rows > 0){
            return "success";
        }else{
            return "failure";
        }
    }

    /**
     * 查询库存调拨主表信息
     * @return ResultMap<List<Receipts>>
     */
    @RequestMapping("/searchReceiptsInfo.action")
    @ResponseBody
    public ResultMap<List<Receipts>> searchReceiptsInfo(Receipts receipts,Page page){
        //对receipts赋值存入page
        receipts.setRecTiaoNumber((page.getPage()-1)*page.getlimit());
        receipts.setRecTotalNumber(page.getlimit());
        System.out.println("receipts" + receipts);
        //查询数据
        ResultMap<List<Receipts>> resultMap = allocationManagerServiceInter.searchReceiptsInfo(receipts);
        //响应回页面
        return resultMap;
    }

    /**
     * 查询库存调拨明细信息
     * @return ResultMap<List<Receipts>>
     */
    @RequestMapping("/searchReceiptsDetailedInfo.action")
    @ResponseBody
    public ResultMap<List<ReceiptsDetailed>> searchReceiptsDetailedInfo(Receipts receipts,Page page){
        System.out.println("");
        System.out.println(""+receipts);
        System.out.println("");
        //对receipts赋值存入page
        receipts.setRecTiaoNumber((page.getPage()-1)*page.getlimit());
        receipts.setRecTotalNumber(page.getlimit());
        System.out.println("receipts" + receipts);

        //封装在resultMap
        ResultMap<List<ReceiptsDetailed>> resultMap = allocationManagerServiceInter.searchRepertorySonInfo(receipts);
        //响应回页面
        return resultMap;
    }

}
