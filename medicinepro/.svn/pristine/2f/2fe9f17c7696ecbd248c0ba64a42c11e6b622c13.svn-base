package com.medicine.pojo;

import java.util.*;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-25 14:28
 * @Description:区级信息
 */
public class District {
   /** 区级编号
    */
   private String disId;
   /** 区级名称
    */
   private String disName;
   /** 区级排序
    */
   private int disSort;
   /** 城市编号
    */
   private String disCityNo;
   /** 描述
    */
   private String disDescription;

 /*  @Override
   public String toString() {
      return "District{" +
              "disId='" + disId + '\'' +
              ", disName='" + disName + '\'' +
              ", disSort=" + disSort +
              ", disCityNo='" + disCityNo + '\'' +
              ", disDescription='" + disDescription + '\'' +
              '}';
   }*/

   public District() {
   }

   /*public District(String disId, String disName, int disSort, String disCityNo, String disDescription) {
      this.disId = disId;
      this.disName = disName;
      this.disSort = disSort;
      this.disCityNo = disCityNo;
      this.disDescription = disDescription;
   }
*/
   public String getDisId() {
      return disId;
   }

   public void setDisId(String disId) {
      this.disId = disId;
   }

   public String getDisName() {
      return disName;
   }

   public void setDisName(String disName) {
      this.disName = disName;
   }

   public int getDisSort() {
      return disSort;
   }

   public void setDisSort(int disSort) {
      this.disSort = disSort;
   }

   public String getDisCityNo() {
      return disCityNo;
   }

   public void setDisCityNo(String disCityNo) {
      this.disCityNo = disCityNo;
   }

   public String getDisDescription() {
      return disDescription;
   }

   public void setDisDescription(String disDescription) {
      this.disDescription = disDescription;
   }

   /**
    *
    * @param disId
    * @param disName
    */
   public District(String disId, String disName) {
      this.disId = disId;
      this.disName = disName;
   }

   @Override
   public String toString() {
      return "District{" +
              "disId='" + disId + '\'' +
              ", disName='" + disName + '\'' +
              '}';
   }

   public static void main(String[] args) {
      District district=new District("资阳区","D0001");
      City city =new City("益阳市","c0001",district);
      Province province=new Province("湖南省","p0001",city);
      System.out.println(province);
   }
}
