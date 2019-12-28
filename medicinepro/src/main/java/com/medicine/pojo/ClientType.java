package com.medicine.pojo;

import java.util.*;
/**
 * @Auther: 刘涵
 * @Date: 2019-11-25 14:28
 * @Description:客户类型信息
 */
public class ClientType {
   /**
    * 客户类型编号
    */
   private String cltID;
   /**
    * 客户类型名称
    */
   private String cltName;
   /**
    * 客户类型状态
    */
   private int cltStatus;
   /**
    * 备注
    */
   private String cltRemark;

  /* @Override
   public String toString() {
      return "ClientType{" +
              "cltID='" + cltID + '\'' +
              ", cltName='" + cltName + '\'' +
              ", cltStatus=" + cltStatus +
              ", cltRemark='" + cltRemark + '\'' +
              '}';
   }*/

   public ClientType() {
   }

   /*public ClientType(String cltID, String cltName, int cltStatus, String cltRemark) {
      this.cltID = cltID;
      this.cltName = cltName;
      this.cltStatus = cltStatus;
      this.cltRemark = cltRemark;
   }*/

   public int getCltStatus() {
      return cltStatus;
   }

   public void setCltStatus(int cltStatus) {
      this.cltStatus = cltStatus;
   }

   public String getCltID() {
      return cltID;
   }

   public void setCltID(String cltID) {
      this.cltID = cltID;
   }

   public String getCltName() {
      return cltName;
   }

   public void setCltName(String cltName) {
      this.cltName = cltName;
   }

   public String getCltRemark() {
      return cltRemark;
   }

   public void setCltRemark(String cltRemark) {
      this.cltRemark = cltRemark;
   }
}
