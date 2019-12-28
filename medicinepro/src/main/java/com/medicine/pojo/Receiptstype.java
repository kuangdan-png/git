package com.medicine.pojo;

import java.util.*;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-25 14:28
 * @Description:单据类型信息 */
public class Receiptstype {
   /** 单据类型编号
    *             
    * 
    * @pdOid 54a39e43-8bf2-4856-be28-90a968839a3e */
   private String retNo;
   /** 单据类型名称
    *             
    * 
    * @pdOid 96a329ff-7527-4090-b993-1512975daeb1 */
   private String retName;
   /** 单据类型排序
    *             
    * 
    * @pdOid 31d68254-2a1f-46aa-ad9b-2a8039e0045e */
   private int retSort;
   /** 单据类型备注
    *             
    * 
    * @pdOid 81b38907-b3f6-4594-848a-c615fc169c5d */
   private String retRemark;
   /** @pdOid 5fc39a61-1cc2-4a13-a847-34de20f56cc0 */
   private String duo1;
   /** @pdOid bdb3cfb1-bba7-42d1-823c-9b52a4b4c982 */
   private String duo2;
   /** @pdOid 6ed81ca4-e620-4f59-80c8-97e1ed6a3593 */
   private String duo3;

   public Receiptstype() {
   }

   public Receiptstype(String retNo, String retName, int retSort, String retRemark, String duo1, String duo2, String duo3) {
      this.retNo = retNo;
      this.retName = retName;
      this.retSort = retSort;
      this.retRemark = retRemark;
      this.duo1 = duo1;
      this.duo2 = duo2;
      this.duo3 = duo3;
   }

   @Override
   public String toString() {
      return "Receiptstype{" +
              "retNo='" + retNo + '\'' +
              ", retName='" + retName + '\'' +
              ", retSort=" + retSort +
              ", retRemark='" + retRemark + '\'' +
              ", duo1='" + duo1 + '\'' +
              ", duo2='" + duo2 + '\'' +
              ", duo3='" + duo3 + '\'' +
              '}';
   }

   public String getRetNo() {
      return retNo;
   }

   public void setRetNo(String retNo) {
      this.retNo = retNo;
   }

   public String getRetName() {
      return retName;
   }

   public void setRetName(String retName) {
      this.retName = retName;
   }

   public int getRetSort() {
      return retSort;
   }

   public void setRetSort(int retSort) {
      this.retSort = retSort;
   }

   public String getRetRemark() {
      return retRemark;
   }

   public void setRetRemark(String retRemark) {
      this.retRemark = retRemark;
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
