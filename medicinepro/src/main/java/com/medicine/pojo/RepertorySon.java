package com.medicine.pojo;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-25 14:28
 * @Description:仓库明细信息
 */
public class RepertorySon {
   /**
    * 库存明细编号
    */
   private String repId;
   /**
    * 商品编号
    */
   private String repComId;
   /**
    * 商品名称
    */
   private String repProName;
   /**
    * 库存数量
    */
   private int repNumber;
   /**
    * 销售总数
    */
   private int reqTotality;
   /** 成本价
    *             
    * 
    * @pdOid 713d64d4-424c-4f7b-87f8-56e6131e9882 */
   private double reqPrice;
   /** 预销售价
    *             
    * 
    * @pdOid bb1bc8f7-ba74-494c-aff9-276f329f438d */
   private double reqShouPrice;
   /** 当前库存
    *             
    * 
    * @pdOid e36b31e6-6b6c-423b-b324-246a2bb4c36f */
   private int reqCurrent;
   /** 最低库存
    *             
    * 
    *
    * */
   private int reqLowest;
   /** 仓库编号
    *             
    * 
    *  */
   private String reqWareNo;
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
   private String duo3;
   /**
    *
    * */
   private String duo4;
   /**
    *
    * */
   private String duo5;
   private Warehouse warehouse;
   private Commodity commodity;
   private Category category;

   private int page;
   private int limit;

   public RepertorySon(String repId, String repComId, String repProName, int repNumber, String reqWareNo, String duo1) {
      this.repId = repId;
      this.repComId = repComId;
      this.repProName = repProName;
      this.repNumber = repNumber;
      this.reqWareNo = reqWareNo;
      this.duo1 = duo1;
   }


    public int getLimit() {
      return limit;
   }

   public void setLimit(int limit) {
      this.limit = limit;
   }

   public int getPage() {
      return page;
   }

   public void setPage(int page) {
      this.page = page;
   }

   public Commodity getCommodity() {
      return commodity;
   }

   public void setCommodity(Commodity commodity) {
      this.commodity = commodity;
   }

   public Warehouse getWarehouse() {
      return warehouse;
   }

   public void setWarehouse(Warehouse warehouse) {
      this.warehouse = warehouse;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }
   /**
    * 根据商品ID与仓库ID查询库存
    * @param duo5
    * @param duo4
    */
   public RepertorySon(String duo4, String duo5) {
      this.duo4 = duo4;
      this.duo5 = duo5;
   }
   @Override
   public String toString() {
      return "RepertorySon{" +
              "repId='" + repId + '\'' +
              ", repComId='" + repComId + '\'' +
              ", repProName='" + repProName + '\'' +
              ", repNumber=" + repNumber +
              ", reqTotality=" + reqTotality +
              ", reqPrice=" + reqPrice +
              ", reqShouPrice=" + reqShouPrice +
              ", reqCurrent=" + reqCurrent +
              ", reqLowest=" + reqLowest +
              ", reqWareNo='" + reqWareNo + '\'' +
              ", duo1='" + duo1 + '\'' +
              ", duo2='" + duo2 + '\'' +
              ", duo3='" + duo3 + '\'' +
              ", duo4='" + duo4 + '\'' +
              ", duo5='" + duo5 + '\'' +
              ", warehouse=" + warehouse +
              ", commodity=" + commodity +
              '}';
   }

   public RepertorySon() {
   }

   public RepertorySon(String repId, String repComId, String repProName, int repNumber, int reqTotality, double reqPrice, double reqShouPrice, int reqCurrent, int reqLowest, String reqWareNo, String duo1, String duo2, String duo3, String duo4, String duo5) {
      this.repId = repId;
      this.repComId = repComId;
      this.repProName = repProName;
      this.repNumber = repNumber;
      this.reqTotality = reqTotality;
      this.reqPrice = reqPrice;
      this.reqShouPrice = reqShouPrice;
      this.reqCurrent = reqCurrent;
      this.reqLowest = reqLowest;
      this.reqWareNo = reqWareNo;
      this.duo1 = duo1;
      this.duo2 = duo2;
      this.duo3 = duo3;
      this.duo4 = duo4;
      this.duo5 = duo5;
   }

   public String getRepId() {
      return repId;
   }

   public void setRepId(String repId) {
      this.repId = repId;
   }

   public String getRepComId() {
      return repComId;
   }

   public void setRepComId(String repComId) {
      this.repComId = repComId;
   }

   public String getRepProName() {
      return repProName;
   }

   public void setRepProName(String repProName) {
      this.repProName = repProName;
   }

   public int getRepNumber() {
      return repNumber;
   }

   public void setRepNumber(int repNumber) {
      this.repNumber = repNumber;
   }

   public int getReqTotality() {
      return reqTotality;
   }

   public void setReqTotality(int reqTotality) {
      this.reqTotality = reqTotality;
   }

   public double getReqPrice() {
      return reqPrice;
   }

   public void setReqPrice(double reqPrice) {
      this.reqPrice = reqPrice;
   }

   public double getReqShouPrice() {
      return reqShouPrice;
   }

   public void setReqShouPrice(double reqShouPrice) {
      this.reqShouPrice = reqShouPrice;
   }

   public int getReqCurrent() {
      return reqCurrent;
   }

   public void setReqCurrent(int reqCurrent) {
      this.reqCurrent = reqCurrent;
   }

   public int getReqLowest() {
      return reqLowest;
   }

   public void setReqLowest(int reqLowest) {
      this.reqLowest = reqLowest;
   }

   public String getReqWareNo() {
      return reqWareNo;
   }

   public void setReqWareNo(String reqWareNo) {
      this.reqWareNo = reqWareNo;
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

   public String getDuo3() {
      return duo3;
   }

   public void setDuo3(String duo3) {
      this.duo3 = duo3;
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
