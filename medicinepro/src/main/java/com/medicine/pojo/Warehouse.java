package com.medicine.pojo;

import java.util.*;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-25 14:28
 * @Description:仓库信息
 */
public class Warehouse {
   /** 仓库编号
    *             
    * 
    * @pdOid 5c565708-02af-4706-9b0a-987943ed7eaa */
   private String warID;
   /** 仓库名称
    *             
    * 
    * @pdOid d0c5ca93-535b-4332-bc23-b08519bfa52d */
   private String warName;
   /** 负责人(员工)
    *             
    * 
    * @pdOid 6e62b494-f657-49e3-aa8d-b94f3e799015 */
   private String employeesNo;
   /** 联系电话
    *             
    * 
    * @pdOid bac9389a-913b-4a75-853c-1749c568a4d8 */
   private String warPhone;
   /** 仓库地址编号
    *             
    * 
    * @pdOid 5519fe5b-19ca-40ef-a6d4-d067bb4dd5e1 */
   private String warAddressNo;
   /** 仓库地址
    *             仓库地址
    *             
    * 
    * @pdOid f533213b-7d85-4124-bcfc-db3bcda4c3b1 */
   private String warAddress;
   /** 默认仓库
    *             
    * 
    * @pdOid 2f5dc1ec-9c51-4df0-9f97-e5b22a736a8a */
   private int warDefault;
   /** 状态
    *             
    * 
    * @pdOid 3df91103-6dac-4d11-942e-bff4edae5260 */
   private int warForbidNo;
   /** 备注
    *             
    * 
    * @pdOid 69d3e0d0-e0c5-44bd-86d5-faceef29c832 */
   private String warComment;
   /** 库存总数量
    *             
    * 
    * @pdOid bb7fa392-aeca-4489-92ac-d16fbdb7f347 */
   private int repNumber;
   /** 库存总值
    *             
    * 
    * @pdOid 31ef74d8-1f83-46d1-8ff9-648ea3851719 */
   private double warTotalValue;
   /** 当前库存
    *             
    * 
    * @pdOid 156d0313-dc0b-493b-8262-164af5f176d3 */
   private int warCurrent;
   /** 最低库存
    *             
    * 
    * @pdOid f96095c2-2b03-4c12-b43c-f4af7a4d9c81 */
   private int warLowest;
   /** @pdOid dd1b376e-2a47-48ed-9c13-f575bd0accce */
   private String duo1;
   /** @pdOid 43eb9184-c56d-4a5d-a7c0-e3261961c9f2 */
   private String duo2;
   /** @pdOid 5806bf4c-211b-4040-81dc-4253c35abe5b */
   private String duo3;
   /** 最低库存
    *
    *
    * @pdOid f96095c2-2b03-4c12-b43c-f4af7a4d9c81 */
   private String disName;//区
   private String citName;//市
   private String proName;//省
   private Address address;
   private String disNo;//区
   private String citNo;//市
   private String proNo;//省

   public String getDisName() {
      return disName;
   }

   public void setDisName(String disName) {
      this.disName = disName;
   }

   public String getCitName() {
      return citName;
   }

   public void setCitName(String citName) {
      this.citName = citName;
   }

   public String getProName() {
      return proName;
   }

   public void setProName(String proName) {
      this.proName = proName;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public String getDisNo() {
      return disNo;
   }

   public void setDisNo(String disNo) {
      this.disNo = disNo;
   }

   public String getCitNo() {
      return citNo;
   }

   public void setCitNo(String citNo) {
      this.citNo = citNo;
   }

   public String getProNo() {
      return proNo;
   }

   public void setProNo(String proNo) {
      this.proNo = proNo;
   }

   public Warehouse() {
   }

   public Warehouse(String warID, String warName, String employeesNo, String warPhone, String warAddressNo, String warAddress, int warDefault, int warForbidNo, String warComment, int repNumber, double warTotalValue, int warCurrent, int warLowest, String duo1, String duo2, String duo3) {
      this.warID = warID;
      this.warName = warName;
      this.employeesNo = employeesNo;
      this.warPhone = warPhone;
      this.warAddressNo = warAddressNo;
      this.warAddress = warAddress;
      this.warDefault = warDefault;
      this.warForbidNo = warForbidNo;
      this.warComment = warComment;
      this.repNumber = repNumber;
      this.warTotalValue = warTotalValue;
      this.warCurrent = warCurrent;
      this.warLowest = warLowest;
      this.duo1 = duo1;
      this.duo2 = duo2;
      this.duo3 = duo3;
   }

   @Override
   public String toString() {
      return "Warehouse{" +
              "warID='" + warID + '\'' +
              ", warName='" + warName + '\'' +
              ", employeesNo='" + employeesNo + '\'' +
              ", warPhone='" + warPhone + '\'' +
              ", warAddressNo='" + warAddressNo + '\'' +
              ", warAddress='" + warAddress + '\'' +
              ", warDefault=" + warDefault +
              ", warForbidNo=" + warForbidNo +
              ", warComment='" + warComment + '\'' +
              ", repNumber=" + repNumber +
              ", warTotalValue=" + warTotalValue +
              ", warCurrent=" + warCurrent +
              ", warLowest=" + warLowest +
              ", duo1='" + duo1 + '\'' +
              ", duo2='" + duo2 + '\'' +
              ", duo3='" + duo3 + '\'' +
              '}';
   }

   public String getWarID() {
      return warID;
   }

   public void setWarID(String warID) {
      this.warID = warID;
   }

   public String getWarName() {
      return warName;
   }

   public void setWarName(String warName) {
      this.warName = warName;
   }

   public String getEmployeesNo() {
      return employeesNo;
   }

   public void setEmployeesNo(String employeesNo) {
      this.employeesNo = employeesNo;
   }

   public String getWarPhone() {
      return warPhone;
   }

   public void setWarPhone(String warPhone) {
      this.warPhone = warPhone;
   }

   public String getWarAddressNo() {
      return warAddressNo;
   }

   public void setWarAddressNo(String warAddressNo) {
      this.warAddressNo = warAddressNo;
   }

   public String getWarAddress() {
      return warAddress;
   }

   public void setWarAddress(String warAddress) {
      this.warAddress = warAddress;
   }

   public int getWarDefault() {
      return warDefault;
   }

   public void setWarDefault(int warDefault) {
      this.warDefault = warDefault;
   }

   public int getWarForbidNo() {
      return warForbidNo;
   }

   public void setWarForbidNo(int warForbidNo) {
      this.warForbidNo = warForbidNo;
   }

   public String getWarComment() {
      return warComment;
   }

   public void setWarComment(String warComment) {
      this.warComment = warComment;
   }

   public int getRepNumber() {
      return repNumber;
   }

   public void setRepNumber(int repNumber) {
      this.repNumber = repNumber;
   }

   public double getWarTotalValue() {
      return warTotalValue;
   }

   public void setWarTotalValue(double warTotalValue) {
      this.warTotalValue = warTotalValue;
   }

   public int getWarCurrent() {
      return warCurrent;
   }

   public void setWarCurrent(int warCurrent) {
      this.warCurrent = warCurrent;
   }

   public int getWarLowest() {
      return warLowest;
   }

   public void setWarLowest(int warLowest) {
      this.warLowest = warLowest;
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
}
