package com.medicine.handler;

import com.medicine.pojo.Category;
import com.medicine.service.impl.CommodityTypeServiceImpl;
import com.medicine.service.inter.CommodityTypeServiceInter;
import com.medicine.util.LayuiTree;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Auther:刘双
 * DATE: 2019-11-25-19:37
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */
@Controller
@RequestMapping("/systemsetup")
public class CommodityTypeHandler {
    @Resource(name="commodityTypeServiceImpl")
    private CommodityTypeServiceInter commodityTypeServiceImpl;
    /**
     * 查询商品类别
     * @return
     */
    @RequestMapping("/searchCommodityParentType.action")
    public @ResponseBody List<LayuiTree<Category>>  searchCommodityParentType(HttpServletResponse resp, @RequestParam String seniorSeclct) throws UnsupportedEncodingException {
        //处理前提提交请求的乱码
        seniorSeclct = new String(seniorSeclct.getBytes("ISO-8859-1"),"UTF-8");
        List<LayuiTree<Category>> layuiTreeList=new ArrayList<LayuiTree<Category>>();
        /*假如seniorSeclct为空则证明是页面初始化时的类别查询*/
        if(seniorSeclct.equals("null")){
            /*获取所有商品类别父类别*/
        List<Category> categoryList= commodityTypeServiceImpl.searchCommodityType();
        for (Category category :categoryList){
            /*根据商品父类别查找商品子类别*/
            List<Category> categoryList1=commodityTypeServiceImpl.searchCommodity(category.getCatId());
            /*将父类别和子类别存入layuiTree实例中使传入前台的数据时树形结构能够解析的json格式*/
            LayuiTree<Category> layuiTree=new LayuiTree<Category>(category.getTitle(), category.getCatId(), categoryList1);
            layuiTreeList.add(layuiTree);
        }
        /*不为空则是按照条件高级查询的类别*/
        }else if(!seniorSeclct.equals("null")) {
            /*根据页面传输的条件查询类别*/
            List<Category> categoryList1 = commodityTypeServiceImpl.searchCommodityseniorSeclct(seniorSeclct);
            for(Category category:categoryList1) {
                /*将类别存入layuiTree实例中使传入前台的数据时树形结构能够解析的json格式*/
                LayuiTree<Category> layuiTree = new LayuiTree<Category>(category.getTitle(), category.getCatId(), null);
                layuiTreeList.add(layuiTree);
            }
        }
        return layuiTreeList;
    }
}
