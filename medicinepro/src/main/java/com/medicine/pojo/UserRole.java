package com.medicine.pojo;

import java.util.Date;
/**
 * table name:  user_role
 * author name: ZRY
 * create time: 2019-11-25 20:39:02
 */ 
public class UserRole{

	private String userRoleNo;
	private String userNo;
	private String roleNo;

	public void setUserRoleNo(String userRoleNo){
		this.userRoleNo=userRoleNo;
	}
	public String getUserRoleNo(){
		return userRoleNo;
	}
	public void setUserNo(String userNo){
		this.userNo=userNo;
	}
	public String getUserNo(){
		return userNo;
	}
	public void setRoleNo(String roleNo){
		this.roleNo=roleNo;
	}
	public String getRoleNo(){
		return roleNo;
	}
}

