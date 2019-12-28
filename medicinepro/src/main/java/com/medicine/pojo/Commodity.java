package com.medicine.pojo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-25 14:28
 * @Description:商品信息
 */
public class Commodity {
   /** 商品编号
    */
   private String comId;
   /** 商品名称
    */
   private String comName;
   /** 简码
    */
   private String comSimpleCode;
   private String comTypeId;
   private String categoryNo;

   /** 商品类型
    */

   private Category category;
   /** 通用名
    */
   private String comGenericName;
   /** 商品条码
    */
   private String comBarCode;
   /** 单位
    */
   private String comUnit;
   /** 含有麻黄碱
    */
   private int comEpherine;
   /** 电子监管
    */
   private int comElectonic;
   /** 产品规格
    */
   private String comProduct;
   /** 药剂类型
    */
   private String comMedicame;
   /** 注册证号
    */
   private String comRegister;
   /** 批准文号
    */
   private String comApproval;
   /** 保质期
    */
   private String comQuality;
   /** 状态
    */
   private int comState;
   /** 特价商品
    */
   private int comSpecial;
   /** 预设进价
    */
   private double comPurchase;
   /** 预设售价
    */
   private double comPrice;
   /** 生产厂商编号
    */
   private String comManufact;
   private Manufacturer manufacturer;
   private String manId;
   private Warehouse warehouse;
   private RepertorySon repertorySon;
   private String comStarTime;
   private String comEndTime;
   /**
    *供货商名字
    * */
   private Supplier supplier;


   /** 备注
    */
   private String comRemarks;
   /** 最低库存
    */
   private int comMinKuNumber;
   /**
    *
    * */
   private String duo1;
   /**
    *
    * */
   private String duo2;
   /**
    *
    * */
   private String duo4;
   /**
    *
    * */
   private String duo5;
   private int page;
   private int limit;

   public String getCategoryNo() {
      return categoryNo;
   }

   public void setCategoryNo(String categoryNo) {
      this.categoryNo = categoryNo;
   }

   public String getManId() {
      return manId;
   }

   public void setManId(String manId) {
      this.manId = manId;
   }

   public Warehouse getWarehouse() {
      return warehouse;
   }

   public void setWarehouse(Warehouse warehouse) {
      this.warehouse = warehouse;
   }

   public RepertorySon getRepertorySon() {
      return repertorySon;
   }

   public void setRepertorySon(RepertorySon repertorySon) {
      this.repertorySon = repertorySon;
   }

   public String getComStarTime() {
      return comStarTime;
   }

   public void setComStarTime(String comStarTime) {
      this.comStarTime = comStarTime;
   }

   public String getComEndTime() {
      return comEndTime;
   }

   public void setComEndTime(String comEndTime) {
      this.comEndTime = comEndTime;
   }

   public Supplier getSupplier() {
      return supplier;
   }

   public void setSupplier(Supplier supplier) {
      this.supplier = supplier;
   }

   public String getComTypeId() {
      return comTypeId;
   }

   public void setComTypeId(String comTypeId) {
      this.comTypeId = comTypeId;
   }

   public int getPage() {
      return page;
   }

   public void setPage(int page) {
      this.page = page;
   }

   public int getLimit() {
      return limit;
   }

   public void setLimit(int limit) {
      this.limit = limit;
   }

   public Commodity() {
   }

   public String getComManufact() {
      return comManufact;
   }

   public void setComManufact(String comManufact) {
      this.comManufact = comManufact;
   }

   @Override
   public String toString() {
      return "Commodity{" +
              "comId='" + comId + '\'' +
              ", comName='" + comName + '\'' +
              ", comSimpleCode='" + comSimpleCode + '\'' +
              ", category=" + category +
              ", comGenericName='" + comGenericName + '\'' +
              ", comBarCode='" + comBarCode + '\'' +
              ", comUnit='" + comUnit + '\'' +
              ", comEpherine=" + comEpherine +
              ", comElectonic=" + comElectonic +
              ", comProduct='" + comProduct + '\'' +
              ", comMedicame='" + comMedicame + '\'' +
              ", comRegister='" + comRegister + '\'' +
              ", comApproval='" + comApproval + '\'' +
              ", comQuality=" + comQuality +
              ", comState=" + comState +
              ", comSpecial=" + comSpecial +
              ", comPurchase=" + comPurchase +
              ", comPrice=" + comPrice +
              ", manufacturer=" + manufacturer +
              ", comRemarks='" + comRemarks + '\'' +
              ", comMinKuNumber=" + comMinKuNumber +
              ", duo1='" + duo1 + '\'' +
              ", duo2='" + duo2 + '\'' +
              ", duo4='" + duo4 + '\'' +
              ", duo5='" + duo5 + '\'' +
              '}';
   }

   public String getComId() {
      return comId;
   }

   public void setComId(String comId) {
      this.comId = comId;
   }

   public String getComName() {
      return comName;
   }

   public void setComName(String comName) {
      this.comName = comName;
   }

   public String getComSimpleCode() {
      return comSimpleCode;
   }

   public void setComSimpleCode(String comSimpleCode) {
      this.comSimpleCode = comSimpleCode;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public String getComGenericName() {
      return comGenericName;
   }

   public void setComGenericName(String comGenericName) {
      this.comGenericName = comGenericName;
   }

   public String getComBarCode() {
      return comBarCode;
   }

   public void setComBarCode(String comBarCode) {
      this.comBarCode = comBarCode;
   }

   public String getComUnit() {
      return comUnit;
   }

   public void setComUnit(String comUnit) {
      this.comUnit = comUnit;
   }

   public int getComEpherine() {
      return comEpherine;
   }

   public void setComEpherine(int comEpherine) {
      this.comEpherine = comEpherine;
   }

   public int getComElectonic() {
      return comElectonic;
   }

   public void setComElectonic(int comElectonic) {
      this.comElectonic = comElectonic;
   }

   public String getComProduct() {
      return comProduct;
   }

   public void setComProduct(String comProduct) {
      this.comProduct = comProduct;
   }

   public String getComMedicame() {
      return comMedicame;
   }

   public void setComMedicame(String comMedicame) {
      this.comMedicame = comMedicame;
   }

   public String getComRegister() {
      return comRegister;
   }

   public void setComRegister(String comRegister) {
      this.comRegister = comRegister;
   }

   public String getComApproval() {
      return comApproval;
   }

   public void setComApproval(String comApproval) {
      this.comApproval = comApproval;
   }

   public String getComQuality() {
      return comQuality;
   }

   public void setComQuality(String comQuality) {
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//      String format=null;
//      try {
//         if(null !=comQuality && !comQuality.equals("")){
//            Date parse = sdf.parse(comQuality);
//            format = sdf.format(parse);
//         }
//      } catch (ParseException e) {
//         e.printStackTrace();
//      }
      this.comQuality = comQuality;
   }

   public int getComState() {
      return comState;
   }

   public void setComState(int comState) {
      this.comState = comState;
   }

   public int getComSpecial() {
      return comSpecial;
   }

   public void setComSpecial(int comSpecial) {
      this.comSpecial = comSpecial;
   }

   public double getComPurchase() {
      return comPurchase;
   }

   public void setComPurchase(double comPurchase) {
      this.comPurchase = comPurchase;
   }

   public double getComPrice() {
      return comPrice;
   }

   public void setComPrice(double comPrice) {
      this.comPrice = comPrice;
   }

   public Manufacturer getManufacturer() {
      return manufacturer;
   }

   public void setManufacturer(Manufacturer manufacturer) {
      this.manufacturer = manufacturer;
   }

   public String getComRemarks() {
      return comRemarks;
   }

   public void setComRemarks(String comRemarks) {
      this.comRemarks = comRemarks;
   }

   public int getComMinKuNumber() {
      return comMinKuNumber;
   }

   public void setComMinKuNumber(int comMinKuNumber) {
      this.comMinKuNumber = comMinKuNumber;
   }

   public String getDuo1() {
      return duo1;
   }

   public void setDuo1(String duo1) {
      this.duo1 = duo1;
   }

   public String getDuo2() {
      return duo2;
   }

   public void setDuo2(String duo2) {
      this.duo2 = duo2;
   }

   public String getDuo4() {
      return duo4;
   }

   public void setDuo4(String duo4) {
      this.duo4 = duo4;
   }

   public String getDuo5() {
      return duo5;
   }

   public void setDuo5(String duo5) {
      this.duo5 = duo5;
   }

   public Commodity(String comId, String comName, String comSimpleCode, Category category, String comGenericName, String comBarCode, String comUnit, int comEpherine, int comElectonic, String comProduct, String comMedicame, String comRegister, String comApproval, String comQuality, int comState, int comSpecial, double comPurchase, double comPrice, Manufacturer manufacturer, String comRemarks, int comMinKuNumber, String duo1, String duo2, String duo4, String duo5) {
      this.comId = comId;
      this.comName = comName;
      this.comSimpleCode = comSimpleCode;
      this.category = category;
      this.comGenericName = comGenericName;
      this.comBarCode = comBarCode;
      this.comUnit = comUnit;
      this.comEpherine = comEpherine;
      this.comElectonic = comElectonic;
      this.comProduct = comProduct;
      this.comMedicame = comMedicame;
      this.comRegister = comRegister;
      this.comApproval = comApproval;
      this.comQuality = comQuality;
      this.comState = comState;
      this.comSpecial = comSpecial;
      this.comPurchase = comPurchase;
      this.comPrice = comPrice;
      this.manufacturer = manufacturer;
      this.comRemarks = comRemarks;
      this.comMinKuNumber = comMinKuNumber;
      this.duo1 = duo1;
      this.duo2 = duo2;
      this.duo4 = duo4;
      this.duo5 = duo5;
   }

   /**
    * 根据商品Id/名称和仓库ID查询信息(GC)
    * @param duo2 商品Id/名称
    * @param duo4 仓库ID
    */
   public Commodity(String duo2, String duo4) {
      this.duo2 = duo2;
      this.duo4 = duo4;
   }

   /**
    *  (根据商品Id/名称和客户I与销售单据查询信息(GC))
    * @param duo2
    * @param duo4
    * @param duo5
    */
   public Commodity(String duo2, String duo4,String duo5) {
      this.duo2 = duo2;
      this.duo4 = duo4;
      this.duo5 = duo5;
   }
   /**
    *  根据商品ID、仓库ID、数量修改库存(GC)
    * @param comId 商品ID
    * @param duo1 数量修改库存
    * @param duo4 仓库ID
    */
   public Commodity(String comId, int duo1, String duo4) {
      this.comId = comId;
      this.duo1 = duo1+"";
      this.duo4 = duo4;
   }
}
