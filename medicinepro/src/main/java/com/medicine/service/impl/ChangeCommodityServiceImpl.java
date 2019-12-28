package com.medicine.service.impl;

import com.medicine.dao.inter.ChangeCommodityDaoInter;
import com.medicine.pojo.Category;
import com.medicine.pojo.Commodity;
import com.medicine.pojo.Manufacturer;
import com.medicine.pojo.Supplier;
import com.medicine.service.inter.ChangeCommodityServiceInter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-30-8:16
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.service.impl
 */
@Service("changeCommodityServiceImpl")
public class ChangeCommodityServiceImpl implements ChangeCommodityServiceInter {
    @Resource(name = "changeCommodityDaoImpl")
    private ChangeCommodityDaoInter changeCommodityDaoImpl;

    public void setChangeCommodityDaoImpl(ChangeCommodityDaoInter changeCommodityDaoImpl) {
        this.changeCommodityDaoImpl = changeCommodityDaoImpl;
    }

    /**
     * 获取单位下拉列表的值
     * @return
     */
    @Override
    public List<String> searchUnit() {
       List<String> stringList=changeCommodityDaoImpl.searchUnitDao();
        return stringList;
    }

    /**
     * 新增商品信息
     * @param commodity
     * @return
     */
    @Override
    public int insertCommodityService(Commodity commodity) {
        int rows=changeCommodityDaoImpl.insertCommodityDao(commodity);
        return rows;
    }

    @Override
    public List<Manufacturer> searchManufacturer() {
        List<Manufacturer> manufacturerList=changeCommodityDaoImpl.searchManufacturer();
        return manufacturerList;
    }

    /**
     * 查询最大编号并自动生成下一个编号
     * @return
     */
    @Override
    public String returnCommodityIdService() {
        String commodityid=changeCommodityDaoImpl.returnCOmmodityidDao();
        int comId=Integer.parseInt(commodityid)+1;
        String comIdString =comId+"";
        return comIdString;
    }

    /**
     * 根据商品类别名称查询查询出对应的商品编号
     * @param catName
     * @return
     */
    @Override
    public Category searchCatId(String catName) {
        Category category=changeCommodityDaoImpl.searchCatId(catName);
        return category;
    }

    /**
     * 删除商品信息（将商品状态改为1）
     * @param comId
     * @return
     */
    @Override
    public int deleteCommodity(String comId) {
        List<String> comIds=new ArrayList<String>();
        String[] comIdso=comId.split(",");
        for(int i=0;comIdso.length>i;i++){
            comIds.add(comIdso[i]);
            //comIdso[i]的作用：
            System.out.println("comIdso[i]==="+comIdso[i]);
        }
        int rows=changeCommodityDaoImpl.deleteCommodity(comIds);
        return rows;
    }

    /**
     * 编辑时先删除原有商品信息
     * @param comId
     * @return
     */
    @Override
    public int deleteCommodity2(String comId) {

        int rows=changeCommodityDaoImpl.deleteCommodity2(comId);
        return rows;
    }

    /**
     * 查询所有供货商
     * @return
     */
    @Override
    public List<Supplier> searchSupplier() {
        List<Supplier> rows=changeCommodityDaoImpl.searchSupplier();
        return rows;
    }
}
