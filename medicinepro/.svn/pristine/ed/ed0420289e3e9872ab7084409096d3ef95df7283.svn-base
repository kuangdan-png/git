package com.medicine.service.impl;

import com.medicine.dao.inter.WareHouseManagerDaoInter;
import com.medicine.pojo.*;
import com.medicine.service.inter.WareHouseManagerServiceInter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 刘涵、张如意
 * @Date: 2019-11-27 15:44
 * @Description:
 * 仓库管理业务逻辑实现类
 */
@Service("wareHouseManagerServiceImpl")
public class WareHouseManagerServiceImpl implements WareHouseManagerServiceInter {
    @Resource(name = "wareHouseManagerDaoImpl")
    private WareHouseManagerDaoInter wareHouseManagerDaoInter = null;

    public void setWareHouseManagerDaoInter(WareHouseManagerDaoInter wareHouseManagerDaoInter) {
        this.wareHouseManagerDaoInter = wareHouseManagerDaoInter;
    }

    /**
     * 查询药品过期数据
     *
     * @param repertorySon
     * @return List<RepertorySon>
     */
    @Override
    public List<RepertorySon> searchStaleDted(RepertorySon repertorySon) {
        repertorySon.setPage((repertorySon.getPage()-1)*repertorySon.getLimit());
        //1.取出repComId判断是否存储为编号
        String repComId = repertorySon.getRepComId();
        //获取仓库的编号
        String repProName = repertorySon.getRepProName();
        //判断搜索的字段长度
        if (repComId.length() > 0) {
            String id = repComId.substring(0, 1);
            //判断id
            if (id.equalsIgnoreCase("c")) {
                //说明是搜索商品的编号，将其赋值给repId
                repertorySon.setRepId(repComId);
                //再清空对象中的repComId
                repertorySon.setRepComId(null);
            }
        }
        //判断仓库字段的长度大于0
        if (repProName.length() > 0) {
            if (repProName.equals("WH0001")) {
                repertorySon.setRepProName(null);
            }
        }
        return wareHouseManagerDaoInter.searchStaleDated(repertorySon);
    }

    /**
     * 查询仓库信息
     *
     * @return List<Warehouse>
     */
    @Override
    public List<Warehouse> searchWareHourseInfo() {
        return wareHouseManagerDaoInter.searchWareHourseInfo();
    }

    /**
     * 查询总条数
     *
     * @return int
     */
    @Override
    public int searchTotalRows(RepertorySon repertorySon) {
        return wareHouseManagerDaoInter.searchTotalRows(repertorySon);
    }

    /**
     * 生成最大编号
     * @param maxNo
     * @return String
     */
    @Override
    public String getMaxNo(MaxNo maxNo) {
        //获得对象
        MaxNo searchNo = wareHouseManagerDaoInter.searchMaxNo(maxNo);
        StringBuilder max = new StringBuilder();
        //获得前缀
        String manPre = searchNo.getManPre();
        //获得当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String format = df.format(new Date());

        //判断searchNo.getManSort()不为null且长度大于0
        if (null != searchNo.getManSort() && 0 < searchNo.getManSort().length()) {
            //获得最大的编号
            String i = searchNo.getManSort();
            //获得包含日期行
            String substring = i.substring(2, 10);
            //添加前缀和日期
            max.append(manPre + format);

            //判断date等于当天说明已经存在当天的数据否则则无
            if (!format.equals(substring)) {
                //添加后缀
                max.append(searchNo.getManSt());
            } else {
                //获得后缀的长度
                int length = searchNo.getManSt().length();

                //获得不包含日期
                int number = Integer.parseInt(i.substring(10));
                //转换为String
                String numberString = number+"";
                //获得数字长度
                int length1 = numberString.length();

                //获得不包含数字的长度添加为0
                int noIncludeNumberLength=length-length1;
                for (int j = 0; j < noIncludeNumberLength; j++) {
                    max.append("0");
                }
                max.append(number);
            }
        }else{//为null
            max.append(manPre+format+searchNo.getManSt());
        }
        return max.toString();
    }

    /**
     * 查询库存为零的药品数量
     * @return int
     */
    @Override
    public int searchWarehouseNumIsZeroTotalRows() {
        return wareHouseManagerDaoInter.searchWarehouseNumIsZeroTotalRows();
    }

    /**
     * 查询库存为零的药品
     * @param repertorySon
     * @return List<Commodity>
     */
    @Override
    public List<Commodity> searchWarehouseNumIsZero(RepertorySon repertorySon) {
        repertorySon.setPage((repertorySon.getPage()-1)*repertorySon.getLimit());
        return wareHouseManagerDaoInter.searchWarehouseNumIsZero(repertorySon);
    }

    /**
     * 根据编号、开始日期、结束日期，查询进货销售明细的数量
     * @param receiptsDetailed
     * @return int
     */
    @Override
    public int searchPurchaseAndSalesDetailsTotalRows(ReceiptsDetailed receiptsDetailed) {
        return wareHouseManagerDaoInter.searchPurchaseAndSalesDetailsTotalRows(receiptsDetailed);
    }

    /**
     * 根据编号、开始日期、结束日期，查询进货销售明细的数量
     * @param  receiptsDetailed
     * @return List<Receipts>
     */
    @Override
    public List<Receipts> searchPurchaseAndSalesDetails(ReceiptsDetailed receiptsDetailed) {
        receiptsDetailed.setPage((receiptsDetailed.getPage()-1)*receiptsDetailed.getLimit());
        return wareHouseManagerDaoInter.searchPurchaseAndSalesDetails(receiptsDetailed);
    }

}
