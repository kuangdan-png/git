package com.medicine.pojo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 刘涵
 * @String: 2019-11-25 14:28
 * @Description:角色信息
 * */
public class Role {
   /**
    * 角色编号
    */
   private String rolNo;
   /**
    * 角色名称
    */
   private String rolName;
   /**
    * 角色创建时间
    */
   private String rolCreatetime;
   /**
    * 角色排序
    */
   private int rolOrderNumber;
   /**
    * 角色描述
   */
   private String rolDesc;
   /**
    *角色状态
    * */
   private int rolStatus;
   /**
    *授权人编号
    * */
   private String rolAuthoEmployNo;
   /**
    * 父类角色
    * */
   private String rolParentNo;

   public Role() {
   }

   public Role(String rolNo, String rolName, String rolCreatetime, int rolOrderNumber, String rolDesc, int rolStatus, String rolAuthoEmployNo, String rolParentNo) {
      this.rolNo = rolNo;
      this.rolName = rolName;
      this.rolCreatetime = rolCreatetime;
      this.rolOrderNumber = rolOrderNumber;
      this.rolDesc = rolDesc;
      this.rolStatus = rolStatus;
      this.rolAuthoEmployNo = rolAuthoEmployNo;
      this.rolParentNo = rolParentNo;
   }

   @Override
   public String toString() {
      return "Role{" +
              "rolNo='" + rolNo + '\'' +
              ", rolName='" + rolName + '\'' +
              ", rolCreatetime=" + rolCreatetime +
              ", rolOrderNumber=" + rolOrderNumber +
              ", rolDesc='" + rolDesc + '\'' +
              ", rolStatus=" + rolStatus +
              ", rolAuthoEmployNo='" + rolAuthoEmployNo + '\'' +
              ", rolParentNo='" + rolParentNo + '\'' +
              '}';
   }

   public String getRolNo() {
      return rolNo;
   }

   public void setRolNo(String rolNo) {
      this.rolNo = rolNo;
   }

   public String getRolName() {
      return rolName;
   }

   public void setRolName(String rolName) {
      this.rolName = rolName;
   }

   public String getRolCreatetime() {
      return rolCreatetime;
   }

   public void setRolCreatetime(String rolCreatetime) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String format=null;
      try {
         Date parse = sdf.parse(rolCreatetime);
         format = sdf.format(parse);
      } catch (ParseException e) {
         e.printStackTrace();
      }
      this.rolCreatetime = format;
   }

   public int getRolOrderNumber() {
      return rolOrderNumber;
   }

   public void setRolOrderNumber(int rolOrderNumber) {
      this.rolOrderNumber = rolOrderNumber;
   }

   public String getRolDesc() {
      return rolDesc;
   }

   public void setRolDesc(String rolDesc) {
      this.rolDesc = rolDesc;
   }

   public int getRolStatus() {
      return rolStatus;
   }

   public void setRolStatus(int rolStatus) {
      this.rolStatus = rolStatus;
   }

   public String getRolAuthoEmployNo() {
      return rolAuthoEmployNo;
   }

   public void setRolAuthoEmployNo(String rolAuthoEmployNo) {
      this.rolAuthoEmployNo = rolAuthoEmployNo;
   }

    public String getRolParentNo() {
        return rolParentNo;
    }

    public void setRolParentNo(String rolParentNo) {
        this.rolParentNo = rolParentNo;
    }
}
