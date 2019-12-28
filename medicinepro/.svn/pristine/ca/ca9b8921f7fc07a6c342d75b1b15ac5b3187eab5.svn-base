package com.medicine.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-25 14:28
 * @Description:单据信息
 */
public class Receipts {
   /** 单据编号
    *             
    * 
    * @pdOid 2e6cb1b5-f4b9-4a79-8cda-cc3995c0de55 */
   private String recNo;
   /** 单据单号
    * 
    * @pdOid 076834e6-77de-48f7-b7fe-74f0afb28ee2 */
   private String recOdd;
   /** 单据类型编号
    *             
    * 
    * @pdOid 2516eee2-de5c-4b19-8162-47ff79b7c841 */
   private String recDocumentTypes;
   /** 开单日期
    *             
    * 
    * @pdOid c516f1c6-7e10-4c4c-a5e8-59bb7082e311 */
   private String recDate;
   /** 经办人(员工)
    *             
    * 
    * @pdOid 3399dc90-f4ab-466b-b2a6-ccd40fe58b52 */
   private String recEmployeeNo;
   /** 备注
    *             
    * 
    * @pdOid 20fb6d9d-62b1-4e4d-986a-2d5ad8f00226 */
   private String recRemark;
   /** 仓库编号
    *             
    * 
    * @pdOid 2f224876-9353-4646-ac7d-bbdae91364fc */
   private String recWareNo;
   /** 商品条数
    *             
    * 
    * @pdOid 0e74cfb3-9b3c-4d8b-bbd3-e32ac211ed38 */
   private int recTiaoNumber;
   /** 商品总数
    *             
    * 
    * @pdOid f87e58f3-1fef-4687-9080-01d1af2b13df */
   private int recTotalNumber;
   /** 入库仓库编号
    *             
    * 
    * @pdOid 25648447-6b4a-45b2-a110-479be811c46d */
   private String redPutNo;
   /** 出库仓库编号
    *             
    * 
    * @pdOid 3dea43c4-327c-4a80-9073-d38c2ab64436 */
   private String redDepotNo;
   /** 单据父类编号
    * 
    * @pdOid 25c18d34-9fbf-4888-98b0-32495e257efe */
   private String redFatherNo;
   /** @pdOid 040baa83-e157-4187-85c6-6a192517d40e */
   private String duo1;
   /** @pdOid d5340837-477b-4823-af92-9a2e7b96f6ea */
   private String duo2;
   /** @pdOid c8f0556d-ef65-4f4a-b5c1-2e68c2d25652 */
   private String duo4;
   /** @pdOid ffa5f68f-0274-487f-9f59-8c6d825db885 */
   private String duo5;
   private String startTime;
   private String endTime;
   private Employees employees;
   private String recDateSale;

   private int page;
   private int limit;

   public String getRecDateSale() {
      return recDateSale;
   }

   public void setRecDateSale(String recDateSale) {
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String format=null;
      try {
         Date parse = sdf.parse(recDateSale);
         format = sdf.format(parse);
      } catch (ParseException e) {
         e.printStackTrace();
      }
      this.recDateSale = format;
   }

   public String getStartTime() {
      return startTime;
   }

   public void setStartTime(String startTime) {
      this.startTime = startTime;
   }

   public String getEndTime() {
      return endTime;
   }

   public void setEndTime(String endTime) {
      this.endTime = endTime;
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

   private ReceiptsDetailed receiptsDetailed;


   private Warehouse warehouse;

   private Receiptstype receiptstype;

   public ReceiptsDetailed getReceiptsDetailed() {
      return receiptsDetailed;
   }

   public void setReceiptsDetailed(ReceiptsDetailed receiptsDetailed) {
      this.receiptsDetailed = receiptsDetailed;
   }

   public Employees getEmployees() {
      return employees;
   }

   public void setEmployees(Employees employees) {
      this.employees = employees;
   }

   public Warehouse getWarehouse() {
      return warehouse;
   }

   public void setWarehouse(Warehouse warehouse) {
      this.warehouse = warehouse;
   }

   public Receiptstype getReceiptstype() {
      return receiptstype;
   }

   public void setReceiptstype(Receiptstype receiptstype) {
      this.receiptstype = receiptstype;
   }

   public Receipts() {
   }

   public Receipts(String recNo, String recOdd, String recDocumentTypes, String recDate, String recEmployeeNo, String recRemark, String recWareNo, int recTiaoNumber, int recTotalNumber, String redPutNo, String redDepotNo, String redFatherNo, String duo1, String duo2, String duo4, String duo5) {
      this.recNo = recNo;
      this.recOdd = recOdd;
      this.recDocumentTypes = recDocumentTypes;
      this.recDate = recDate;
      this.recEmployeeNo = recEmployeeNo;
      this.recRemark = recRemark;
      this.recWareNo = recWareNo;
      this.recTiaoNumber = recTiaoNumber;
      this.recTotalNumber = recTotalNumber;
      this.redPutNo = redPutNo;
      this.redDepotNo = redDepotNo;
      this.redFatherNo = redFatherNo;
      this.duo1 = duo1;
      this.duo2 = duo2;
      this.duo4 = duo4;
      this.duo5 = duo5;
   }



   public String getRecNo() {
      return recNo;
   }

   public void setRecNo(String recNo) {
      this.recNo = recNo;
   }

   public String getRecOdd() {
      return recOdd;
   }

   public void setRecOdd(String recOdd) {
      this.recOdd = recOdd;
   }

   public String getRecDocumentTypes() {
      return recDocumentTypes;
   }

   public void setRecDocumentTypes(String recDocumentTypes) {
      this.recDocumentTypes = recDocumentTypes;
   }

   public String getRecDate() {
      return recDate;
   }

   public void setRecDate(String recDate) {
      this.recDate = recDate;
   }

   public String getRecEmployeeNo() {
      return recEmployeeNo;
   }

   public void setRecEmployeeNo(String recEmployeeNo) {
      this.recEmployeeNo = recEmployeeNo;
   }

   public String getRecRemark() {
      return recRemark;
   }

   public void setRecRemark(String recRemark) {
      this.recRemark = recRemark;
   }

   public String getRecWareNo() {
      return recWareNo;
   }

   public void setRecWareNo(String recWareNo) {
      this.recWareNo = recWareNo;
   }

   public int getRecTiaoNumber() {
      return recTiaoNumber;
   }

   public void setRecTiaoNumber(int recTiaoNumber) {
      this.recTiaoNumber = recTiaoNumber;
   }

   public int getRecTotalNumber() {
      return recTotalNumber;
   }

   public void setRecTotalNumber(int recTotalNumber) {
      this.recTotalNumber = recTotalNumber;
   }

   public String getRedPutNo() {
      return redPutNo;
   }

   public void setRedPutNo(String redPutNo) {
      this.redPutNo = redPutNo;
   }

   public String getRedDepotNo() {
      return redDepotNo;
   }

   public void setRedDepotNo(String redDepotNo) {
      this.redDepotNo = redDepotNo;
   }

   public String getRedFatherNo() {
      return redFatherNo;
   }

   public void setRedFatherNo(String redFatherNo) {
      this.redFatherNo = redFatherNo;
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
}
