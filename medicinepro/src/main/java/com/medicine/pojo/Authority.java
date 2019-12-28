package com.medicine.pojo;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-25 14:28
 * @Description:权限信息
 */
public class Authority {
   /**
    * 权限编号
    */
   private String autNo;
   /**
    * 权限名称
    */
   private String autName;
   /**
    * 父权限编号
    */
   private String autParentNo;
   /**
    * 权限描述
    */
   private String autDesc;
   /**
    * 权限功能按钮
    */
   private String autButton;
   /**
    * 权限图片
    */
   private String autImg;
   /**
    * 权限地址
    */
   private String autUrl;
   /**
    * 权限排序
    */
   private int autOrderNumber;
   /**
    *
    * */
   private String autFilter;
   /**
    *
    * */
   private int autStatus;
   /**
    *
    * */
   private String aut3;

   public Authority() {
   }

   @Override
   public String toString() {
      return "Authority{" +
              "autNo='" + autNo + '\'' +
              ", autName='" + autName + '\'' +
              ", autParentNo='" + autParentNo + '\'' +
              ", autDesc='" + autDesc + '\'' +
              ", autButton='" + autButton + '\'' +
              ", autImg='" + autImg + '\'' +
              ", autUrl='" + autUrl + '\'' +
              ", autOrderNumber=" + autOrderNumber +
              ", autFilter='" + autFilter + '\'' +
              ", autStatus='" + autStatus + '\'' +
              ", aut3='" + aut3 + '\'' +
              '}';
   }

   public Authority(String autNo, String autName, String autParentNo, String autDesc, String autButton, String autImg, String autUrl, int autOrderNumber, String autFilter, int autStatus, String aut3) {
      this.autNo = autNo;
      this.autName = autName;
      this.autParentNo = autParentNo;
      this.autDesc = autDesc;
      this.autButton = autButton;
      this.autImg = autImg;
      this.autUrl = autUrl;
      this.autOrderNumber = autOrderNumber;
      this.autFilter = autFilter;
      this.autStatus = autStatus;
      this.aut3 = aut3;
   }

   /**
    *
    * */
   public String getAutNo() {
      return autNo;
   }
   
   public void setAutNo(String newAutNo) {
      autNo = newAutNo;
   }
   
   public String getAutName() {
      return autName;
   }
   
   public void setAutName(String newAutName) {
      autName = newAutName;
   }
   
   public String getAutParentNo() {
      return autParentNo;
   }
   
   public void setAutParentNo(String newAutParentNo) {
      autParentNo = newAutParentNo;
   }
   
   public String getAutDesc() {
      return autDesc;
   }
   public void setAutDesc(String newAutDesc) {
      autDesc = newAutDesc;
   }
   
   public String getAutButton() {
      return autButton;
   }
   
   public void setAutButton(String newAutButton) {
      autButton = newAutButton;
   }
   
   public String getAutImg() {
      return autImg;
   }
   
   public void setAutImg(String newAutImg) {
      autImg = newAutImg;
   }
   
   public String getAutUrl() {
      return autUrl;
   }
   
   public void setAutUrl(String newAutUrl) {
      autUrl = newAutUrl;
   }
   
   public int getAutOrderNumber() {
      return autOrderNumber;
   }
   
   public void setAutOrderNumber(int newAutOrderNumber) {
      autOrderNumber = newAutOrderNumber;
   }

   public String getAutFilter() {
      return autFilter;
   }

   public void setAutFilter(String autFilter) {
      this.autFilter = autFilter;
   }

   public int getAutStatus() {
      return autStatus;
   }

   public void setAutStatus(int autStatus) {
      this.autStatus = autStatus;
   }

   public String getAut3() {
      return aut3;
   }
   
   public void setAut3(String newAut3) {
      aut3 = newAut3;
   }

}
