package com.medicine.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @Auther: 刘涵
 * @Date: 2019-11-25 14:28
 * @Description:商品明细表
 */
public class ReceiptsDetailed {
   /** 
    * 单据明细编号
    */
   private String redNo;
   /** 
    * 单据明细单号           
    */
   private String redOdd;
   /** 
    * 商品编号          
    */
   private String redProcutsNo;
   /** 
    * 商品名称
    */
   private String redName;
   /** 
    * 单位
    */
   private String redUnit;
   /** 
    * 产品规格
    */
   private String redredduct;
   /** 
    * 批准文号
    */
   private String redPermitNo;
   /** 
    * 生产日期
    */
   private Date redDate;
   /** 
    * 有效期至
    */
   private Date redValidUntil;
   /**  
    * 单价
    */
   private double redPrice;
   /**  
    * 数量
    */
   private int redCount;
   /**  
    * 生产厂商编号
    */
   private String redManufact;
   /**  
    * 生产厂商名字
    */
   private String redManufactName;
   /**  
    * 预设售价
    */
   private String redPreprice;
   /**   
    * 售价总额
    */
   private String redTotalPrice;
   /**  
    * 供货商编号
    */
   private String redSupplierNo;
   /**  
    * 入货仓库编号
    */
   private String redPutNo;
   /**  
    * 收货仓库编号(盘点仓库)
    */
   private String redDepotNo;
   /**  
    * 进货日期
    */
   private String redredchaseDate;
   /**  
    * 备注
    */
   private String redComment;
   /**  
    * 退货日期
    */
   private Date redReturnDate;
   /**  
    * 单据类型编号
    */
   private String redDocumentTypes;
   /**  
    * 商品类型编号
    */
   private String redProductTypeNo;
   /**  
    * 商品类型名称
    */
   private String redProductTypeName;
   /**  
    * 单据编号
    */
   private String redRecNo;
   /**  
    * 折扣率
    */
   private double redZhe;
   /**  
    * 规格型号
    */
   private String redModel;
   /**  
    * 库存数量
    */
   private int redQuanStock;
   /** 
    * 盘点数量
    */
   private int redCountedQuantity;
   private int page;
   private int limit;
   private Commodity commodity;
   private Receipts receipts;
   private Manufacturer manufacturer;
   private Supplier supplier;
   private Receiptstype receiptstype;
   /**  */
   private String duo1;
   /** */
   private String duo2;
   /**  */
   private String duo3;
   //可退数量
   private int duo4;
   //实收金额/实退金额
   private double duo5;
   /** */
   private String duo6;
   /**  */
   private String duo7;

   public Supplier getSupplier() {
      return supplier;
   }

   public void setSupplier(Supplier supplier) {
      this.supplier = supplier;
   }

   public Receiptstype getReceiptstype() {
      return receiptstype;
   }

   public void setReceiptstype(Receiptstype receiptstype) {
      this.receiptstype = receiptstype;
   }

   public Manufacturer getManufacturer() {
      return manufacturer;
   }

   public void setManufacturer(Manufacturer manufacturer) {
      this.manufacturer = manufacturer;
   }

   public Receipts getReceipts() {
      return receipts;
   }

   public void setReceipts(Receipts receipts) {
      this.receipts = receipts;
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

   public Commodity getCommodity() {
      return commodity;
   }

   public void setCommodity(Commodity commodity) {
      this.commodity = commodity;
   }

   public ReceiptsDetailed() {
   }
   public ReceiptsDetailed(String redNo, String redOdd, String redProcutsNo, String redName, String redUnit, String redredduct, String redPermitNo,String redredchaseDate, double redPrice, int redCount, String redManufact, String redRecNo) {
      this.redNo = redNo;
      this.redOdd = redOdd;
      this.redProcutsNo = redProcutsNo;
      this.redName = redName;
      this.redUnit = redUnit;
      this.redredduct = redredduct;
      this.redPermitNo = redPermitNo;
      this.redredchaseDate = redredchaseDate;
      this.redPrice = redPrice;
      this.redCount = redCount;
      this.redManufact = redManufact;
      this.redRecNo = redRecNo;
   }
   public ReceiptsDetailed(String redNo, String redOdd, String redProcutsNo, String redName, String redUnit, String redredduct, String redPermitNo, Date redDate, Date redValidUntil, double redPrice, int redCount, String redManufact, String redManufactName, String redPreprice, String redTotalPrice, String redSupplierNo, String redPutNo, String redDepotNo, String redredchaseDate, String redComment, Date redReturnDate, String redDocumentTypes, String redProductTypeNo, String redProductTypeName, String redRecNo, double redZhe, String redModel, int redQuanStock, int redCountedQuantity, String duo1, String duo2, String duo3, String duo6, String duo7) {
      this.redNo = redNo;
      this.redOdd = redOdd;
      this.redProcutsNo = redProcutsNo;
      this.redName = redName;
      this.redUnit = redUnit;
      this.redredduct = redredduct;
      this.redPermitNo = redPermitNo;
      this.redDate = redDate;
      this.redValidUntil = redValidUntil;
      this.redPrice = redPrice;
      this.redCount = redCount;
      this.redManufact = redManufact;
      this.redManufactName = redManufactName;
      this.redPreprice = redPreprice;
      this.redTotalPrice = redTotalPrice;
      this.redSupplierNo = redSupplierNo;
      this.redPutNo = redPutNo;
      this.redDepotNo = redDepotNo;
      this.redredchaseDate = redredchaseDate;
      this.redComment = redComment;
      this.redReturnDate = redReturnDate;
      this.redDocumentTypes = redDocumentTypes;
      this.redProductTypeNo = redProductTypeNo;
      this.redProductTypeName = redProductTypeName;
      this.redRecNo = redRecNo;
      this.redZhe = redZhe;
      this.redModel = redModel;
      this.redQuanStock = redQuanStock;
      this.redCountedQuantity = redCountedQuantity;
      this.duo1 = duo1;
      this.duo2 = duo2;
      this.duo3 = duo3;
      this.duo6 = duo6;
      this.duo7 = duo7;
   }
//   redNo,redOdd,redProcutsNo,redName,redUnit,redredduct,redPermitNo,redValidUntil,redPrice,redCount,redManufact,redRecNo
   public ReceiptsDetailed(String redNo, String redOdd, String redProcutsNo, String redName, String redUnit, String redredduct, String redPermitNo, double redPrice, int redCount, String redManufact, String redRecNo) {
      this.redNo = redNo;
      this.redOdd = redOdd;
      this.redProcutsNo = redProcutsNo;
      this.redName = redName;
      this.redUnit = redUnit;
      this.redredduct = redredduct;
      this.redPermitNo = redPermitNo;
      this.redPrice = redPrice;
      this.redCount = redCount;
      this.redManufact = redManufact;
      this.redRecNo = redRecNo;
   }

      @Override
   public String toString() {
      return "ReceiptsDetailed{" +
              "redNo='" + redNo + '\'' +
              ", redOdd='" + redOdd + '\'' +
              ", redProcutsNo='" + redProcutsNo + '\'' +
              ", redName='" + redName + '\'' +
              ", redUnit='" + redUnit + '\'' +
              ", redredduct='" + redredduct + '\'' +
              ", redPermitNo='" + redPermitNo + '\'' +
              ", redDate=" + redDate +
              ", redValidUntil=" + redValidUntil +
              ", redPrice=" + redPrice +
              ", redCount=" + redCount +
              ", redManufact='" + redManufact + '\'' +
              ", redManufactName='" + redManufactName + '\'' +
              ", redPreprice='" + redPreprice + '\'' +
              ", redTotalPrice='" + redTotalPrice + '\'' +
              ", redSupplierNo='" + redSupplierNo + '\'' +
              ", redPutNo='" + redPutNo + '\'' +
              ", redDepotNo='" + redDepotNo + '\'' +
              ", redredchaseDate=" + redredchaseDate +
              ", redComment='" + redComment + '\'' +
              ", redReturnDate=" + redReturnDate +
              ", redDocumentTypes='" + redDocumentTypes + '\'' +
              ", redProductTypeNo='" + redProductTypeNo + '\'' +
              ", redProductTypeName='" + redProductTypeName + '\'' +
              ", redRecNo='" + redRecNo + '\'' +
              ", redZhe=" + redZhe +
              ", redModel='" + redModel + '\'' +
              ", redQuanStock=" + redQuanStock +
              ", redCountedQuantity=" + redCountedQuantity +
              ", duo1='" + duo1 + '\'' +
              ", duo2='" + duo2 + '\'' +
              ", duo3='" + duo3 + '\'' +
              ", duo4='" + duo4 + '\'' +
              ", duo5='" + duo5 + '\'' +
              ", duo6='" + duo6 + '\'' +
              ", duo7='" + duo7 + '\'' +
              '}';
   }

   public String getRedNo() {
      return redNo;
   }
   
   
   public void setRedNo(String newRedNo) {
      redNo = newRedNo;
   }
   
   
   public String getRedOdd() {
      return redOdd;
   }
   
   
   public void setRedOdd(String newRedOdd) {
      redOdd = newRedOdd;
   }
   
   
   public String getRedProcutsNo() {
      return redProcutsNo;
   }
   
 
   public void setRedProcutsNo(String newRedProcutsNo) {
      redProcutsNo = newRedProcutsNo;
   }
   
   
   public String getRedName() {
      return redName;
   }
   
   
   public void setRedName(String newRedName) {
      redName = newRedName;
   }
   
   
   public String getRedUnit() {
      return redUnit;
   }
   
  
   public void setRedUnit(String newRedUnit) {
      redUnit = newRedUnit;
   }
   
  
   public String getRedredduct() {
      return redredduct;
   }
   
   
   public void setRedredduct(String newRedredduct) {
      redredduct = newRedredduct;
   }
   
   
   public String getRedPermitNo() {
      return redPermitNo;
   }
   
  
   public void setRedPermitNo(String newRedPermitNo) {
      redPermitNo = newRedPermitNo;
   }
   
   
   public Date getRedDate() {
      return redDate;
   }
   
   
   public void setRedDate(Date newRedDate) {
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date parse=null;
      try {
         if(null !=newRedDate){
            String format = sdf.format(newRedDate);
            parse = sdf.parse(format);
         }
      } catch (ParseException e) {
         e.printStackTrace();
      }
      redDate = parse;

   }
   
   
   public Date getRedValidUntil() {
      return redValidUntil;
   }
   
   public void setRedValidUntil(Date newRedValidUntil) {
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

      Date parse=null;
      try {
         if(null !=newRedValidUntil){
            String format = sdf.format(newRedValidUntil);
            parse = sdf.parse(format);
         }
      } catch (ParseException e) {
         e.printStackTrace();
      }
      redValidUntil = parse;
   }
   
   
   public double getRedPrice() {
      return redPrice;
   }
   
  
   public void setRedPrice(double newRedPrice) {
      redPrice = newRedPrice;
   }
  
   public int getRedCount() {
      return redCount;
   }
   
   public void setRedCount(int newRedCount) {
      redCount = newRedCount;
   }
   
   
   public String getRedManufact() {
      return redManufact;
   }
   
   
   public void setRedManufact(String newRedManufact) {
      redManufact = newRedManufact;
   }
   
   
   public String getRedManufactName() {
      return redManufactName;
   }
   
   
   public void setRedManufactName(String newRedManufactName) {
      redManufactName = newRedManufactName;
   }
   
   
   public String getRedPreprice() {
      return redPreprice;
   }
   
   
   public void setRedPreprice(String newRedPreprice) {
      redPreprice = newRedPreprice;
   }
   
  
   public String getRedTotalPrice() {
      return redTotalPrice;
   }
   
   public void setRedTotalPrice(String newRedTotalPrice) {
      redTotalPrice = newRedTotalPrice;
   }
   
  
   public String getRedSupplierNo() {
      return redSupplierNo;
   }
   
   public void setRedSupplierNo(String newRedSupplierNo) {
      redSupplierNo = newRedSupplierNo;
   }
   
   
   public String getRedPutNo() {
      return redPutNo;
   }
   
  
   public void setRedPutNo(String newRedPutNo) {
      redPutNo = newRedPutNo;
   }
   
  
   public String getRedDepotNo() {
      return redDepotNo;
   }
   
   
   public void setRedDepotNo(String newRedDepotNo) {
      redDepotNo = newRedDepotNo;
   }
   
  
   public String getRedredchaseDate() {
      return redredchaseDate;
   }
   
  
   public void setRedredchaseDate(String newRedredchaseDate) {
      redredchaseDate = newRedredchaseDate;
   }
   
   public String getRedComment() {
      return redComment;
   }
   
   
   public void setRedComment(String newRedComment) {
      redComment = newRedComment;
   }
   
   
   public Date getRedReturnDate() {
      return redReturnDate;
   }
   
  
   public void setRedReturnDate(Date newRedReturnDate) {
      redReturnDate = newRedReturnDate;
   }
   
   public String getRedDocumentTypes() {
      return redDocumentTypes;
   }
   
   
   public void setRedDocumentTypes(String newRedDocumentTypes) {
      redDocumentTypes = newRedDocumentTypes;
   }
   
  
   public String getRedProductTypeNo() {
      return redProductTypeNo;
   }
   
  
   public void setRedProductTypeNo(String newRedProductTypeNo) {
      redProductTypeNo = newRedProductTypeNo;
   }
   
   
   public String getRedProductTypeName() {
      return redProductTypeName;
   }
  
   public void setRedProductTypeName(String newRedProductTypeName) {
      redProductTypeName = newRedProductTypeName;
   }
   
   
   public String getRedRecNo() {
      return redRecNo;
   }
   
  
   public void setRedRecNo(String newRedRecNo) {
      redRecNo = newRedRecNo;
   }
   
  
   public double getRedZhe() {
      return redZhe;
   }
   
   
   public void setRedZhe(double newRedZhe) {
      redZhe = newRedZhe;
   }
   
  
   public String getRedModel() {
      return redModel;
   }
   
   
   public void setRedModel(String newRedModel) {
      redModel = newRedModel;
   }
   
   
   public int getRedQuanStock() {
      return redQuanStock;
   }
   
   
   public void setRedQuanStock(int newRedQuanStock) {
      redQuanStock = newRedQuanStock;
   }
   
  
   public int getRedCountedQuantity() {
      return redCountedQuantity;
   }
   
  
   public void setRedCountedQuantity(int newRedCountedQuantity) {
      redCountedQuantity = newRedCountedQuantity;
   }
   
   public String getDuo1() {
      return duo1;
   }
   
   
   public void setDuo1(String newDuo1) {
      duo1 = newDuo1;
   }
   
  
   public String getDuo2() {
      return duo2;
   }
   
   
   public void setDuo2(String newDuo2) {
      duo2 = newDuo2;
   }
   
   
   public String getDuo3() {
      return duo3;
   }
   
   
   public void setDuo3(String newDuo3) {
      duo3 = newDuo3;
   }


   public int getDuo4() {
      return duo4;
   }

   public void setDuo4(int duo4) {
      this.duo4 = duo4;
   }

   public double getDuo5() {
      return duo5;
   }

   public void setDuo5(double duo5) {
      this.duo5 = duo5;
   }

   public String getDuo6() {
      return duo6;
   }
   
   
   public void setDuo6(String newDuo6) {
      duo6 = newDuo6;
   }
   
   public String getDuo7() {
      return duo7;
   }
   
  
   public void setDuo7(String newDuo7) {
      duo7 = newDuo7;
   }

   /**
    * 新增销售单据明细(GC)
    * @param redNo
    * @param redOdd
    * @param redProcutsNo
    * @param redName
    * @param redUnit
    * @param redredduct
    * @param redPermitNo
    * @param redPrice
    * @param redCount
    * @param redDepotNo
    * @param redComment
    * @param redProductTypeNo
    * @param redRecNo
    * @param duo1
    * @param duo4
    */
   public ReceiptsDetailed(String redNo, String redOdd, String redProcutsNo, String redName, String redUnit, String redredduct, String redPermitNo, double redPrice, int redCount, String redDepotNo, String redComment, String redProductTypeNo, String redRecNo,String duo1,int duo4,double duo5) {
      this.redNo = redNo;
      this.redOdd = redOdd;
      this.redProcutsNo = redProcutsNo;
      this.redName = redName;
      this.redUnit = redUnit;
      this.redredduct = redredduct;
      this.redPermitNo = redPermitNo;
      this.redPrice = redPrice;
      this.redCount = redCount;
      this.redDepotNo = redDepotNo;
      this.redComment = redComment;
      this.redProductTypeNo = redProductTypeNo;
      this.redRecNo = redRecNo;
      this.duo1 = duo1;
      this.duo4 = duo4;
      this.duo2 = duo2;
      this.duo5 = duo5;
   }

   /**
    * 新增退货单据明细(GC)
    * @param redNo
    * @param redOdd
    * @param redProcutsNo
    * @param redName
    * @param redUnit
    * @param redredduct
    * @param redPermitNo
    * @param redPrice
    * @param redCount
    * @param redDepotNo
    * @param redComment
    * @param redProductTypeNo
    * @param redRecNo
    * @param duo1
    */
   public ReceiptsDetailed(String redNo, String redOdd, String redProcutsNo, String redName, String redUnit, String redredduct, String redPermitNo, double redPrice, int redCount, String redDepotNo, String redComment, String redProductTypeNo, String redRecNo,String duo1,double duo5) {
      this.redNo = redNo;
      this.redOdd = redOdd;
      this.redProcutsNo = redProcutsNo;
      this.redName = redName;
      this.redUnit = redUnit;
      this.redredduct = redredduct;
      this.redPermitNo = redPermitNo;
      this.redPrice = redPrice;
      this.redCount = redCount;
      this.redDepotNo = redDepotNo;
      this.redComment = redComment;
      this.redProductTypeNo = redProductTypeNo;
      this.redRecNo = redRecNo;
      this.duo1 = duo1;
      this.duo5 = duo5;
   }

   /**
    * 根据对应销售单据更新可退货数量
    * @param duo6
    * @param duo4
    */
   public ReceiptsDetailed(String duo6, int duo4,String duo7) {
      this.duo6 = duo6;
      this.duo4 = duo4;
      this.duo7 = duo7;
   }

   /**
    * 查询所编辑的商品退货数量是否大于销售数量（销售单据）
    * @param duo6
    * @param duo7
    */
   public ReceiptsDetailed(String duo6, String duo7) {
      this.duo6 = duo6;
      this.duo7 = duo7;
   }
}
