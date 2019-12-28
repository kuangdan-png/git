package com.medicine.pojo;

import java.util.Date;
import java.util.List;

/**
 * table name:  employees
 * author name: cxc
 * create time: 2019-11-25 14:41:33
 */ 
public class Employees{

	/**员工编号*/
	private String empNo;
	/**员工姓名*/
	private String empName;
	private String empCardId;
	/**性别*/
	private String empSex;
	/**练习电话*/
	private String empTel;
	/**电子邮箱*/
	private String empEmail;
	/**提成比例*/
	private double empRatio;
	/**所任职务*/
	private String empDutyNo;
	/**备注*/
	private String empRemark;
	/**薪水*/
	private double empSalary;
	/**家庭住址编号*/
	private String empAddressNo;
	private String empPoliticsStatus;
	private String empEducation;
	private String empNativePlace;
	private String empNation;
	/**出生日期*/
	private Date empBirthday;
	/**入职日期*/
	private Date empHiredate;
	private String empMaritalStatus;
	private String empManagerNo;
	private int empState;
	private String empWareNo;
	private String empDeparmentId;
	private String userName;
	private String userPass;
	private String duo3;
	private String duo4;
	private List<Role> role;

	private DutyList dutyList;

	public DutyList getDutyList() {
		return dutyList;
	}

	public void setDutyList(DutyList dutyList) {
		this.dutyList = dutyList;
	}

	/**家庭住址编号*/
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	private String empBirthdayStr;
	private String empHiredateStr;

	private String dutName;

	private String empProId;
	/**省份信息*/
	private Province province;

	private String empCitId;
	/**城市信息*/
	private City city;

	private String empDisId;
	/**区级信息*/
	private District district;
	private int page;
	private int limit;

	public Employees() {
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public Employees(String empNo, String empName, String empCardId, String empSex, String empTel, String empEmail, double empRatio, String empDutyNo, String empRemark, double empSalary, String empAddressNo, String empPoliticsStatus, String empEducation, String empNativePlace, String empNation, Date empBirthday, Date empHiredate, String empMaritalStatus, String empManagerNo, int empState, String empWareNo, String empDeparmentId, String userName, String userPass, String duo3, String duo4, int page, int limit) {
		this.empNo = empNo;
		this.empName = empName;
		this.empCardId = empCardId;
		this.empSex = empSex;
		this.empTel = empTel;
		this.empEmail = empEmail;
		this.empRatio = empRatio;
		this.empDutyNo = empDutyNo;
		this.empRemark = empRemark;
		this.empSalary = empSalary;
		this.empAddressNo = empAddressNo;
		this.empPoliticsStatus = empPoliticsStatus;
		this.empEducation = empEducation;
		this.empNativePlace = empNativePlace;
		this.empNation = empNation;
		this.empBirthday = empBirthday;
		this.empHiredate = empHiredate;
		this.empMaritalStatus = empMaritalStatus;
		this.empManagerNo = empManagerNo;
		this.empState = empState;
		this.empWareNo = empWareNo;
		this.empDeparmentId = empDeparmentId;
		this.userName = userName;
		this.userPass = userPass;
		this.duo3 = duo3;
		this.duo4 = duo4;
		this.page = page;
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "Employees{" +
				"empNo='" + empNo + '\'' +
				", empName='" + empName + '\'' +
				", empCardId='" + empCardId + '\'' +
				", empSex='" + empSex + '\'' +
				", empTel='" + empTel + '\'' +
				", empEmail='" + empEmail + '\'' +
				", empRatio=" + empRatio +
				", empDutyNo='" + empDutyNo + '\'' +
				", empRemark='" + empRemark + '\'' +
				", empSalary=" + empSalary +
				", empAddressNo='" + empAddressNo + '\'' +
				", empPoliticsStatus='" + empPoliticsStatus + '\'' +
				", empEducation='" + empEducation + '\'' +
				", empNativePlace='" + empNativePlace + '\'' +
				", empNation='" + empNation + '\'' +
				", empBirthday=" + empBirthday +
				", empHiredate=" + empHiredate +
				", empMaritalStatus='" + empMaritalStatus + '\'' +
				", empManagerNo='" + empManagerNo + '\'' +
				", empState=" + empState +
				", empWareNo='" + empWareNo + '\'' +
				", empDeparmentId='" + empDeparmentId + '\'' +
				", userName='" + userName + '\'' +
				", userPass='" + userPass + '\'' +
				", duo3='" + duo3 + '\'' +
				", duo4='" + duo4 + '\'' +
				", page=" + page +
				", limit=" + limit +
				'}';
	}

	public String getEmpBirthdayStr() {
		return empBirthdayStr;
	}

	public void setEmpBirthdayStr(String empBirthdayStr) {
		this.empBirthdayStr = empBirthdayStr;
	}

	public String getEmpHiredateStr() {
		return empHiredateStr;
	}

	public void setEmpHiredateStr(String empHiredateStr) {
		this.empHiredateStr = empHiredateStr;
	}

	public String getDutName() {
		return dutName;
	}

	public void setDutName(String dutName) {
		this.dutName = dutName;
	}

	public String getEmpProId() {
		return empProId;
	}

	public void setEmpProId(String empProId) {
		this.empProId = empProId;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getEmpCitId() {
		return empCitId;
	}

	public void setEmpCitId(String empCitId) {
		this.empCitId = empCitId;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getEmpDisId() {
		return empDisId;
	}

	public void setEmpDisId(String empDisId) {
		this.empDisId = empDisId;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
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

	public void setEmpNo(String empNo){
		this.empNo=empNo;
	}
	public String getEmpNo(){
		return empNo;
	}
	public void setEmpName(String empName){
		this.empName=empName;
	}
	public String getEmpName(){
		return empName;
	}
	public void setEmpCardId(String empCardId){
		this.empCardId=empCardId;
	}
	public String getEmpCardId(){
		return empCardId;
	}
	public void setEmpSex(String empSex){
		this.empSex=empSex;
	}
	public String getEmpSex(){
		return empSex;
	}
	public void setEmpTel(String empTel){
		this.empTel=empTel;
	}
	public String getEmpTel(){
		return empTel;
	}
	public void setEmpEmail(String empEmail){
		this.empEmail=empEmail;
	}
	public String getEmpEmail(){
		return empEmail;
	}
	public void setEmpRatio(double empRatio){
		this.empRatio=empRatio;
	}
	public double getEmpRatio(){
		return empRatio;
	}
	public void setEmpDutyNo(String empDutyNo){
		this.empDutyNo=empDutyNo;
	}
	public String getEmpDutyNo(){
		return empDutyNo;
	}
	public void setEmpRemark(String empRemark){
		this.empRemark=empRemark;
	}
	public String getEmpRemark(){
		return empRemark;
	}
	public void setEmpSalary(double empSalary){
		this.empSalary=empSalary;
	}
	public double getEmpSalary(){
		return empSalary;
	}
	public void setEmpAddressNo(String empAddressNo){
		this.empAddressNo=empAddressNo;
	}
	public String getEmpAddressNo(){
		return empAddressNo;
	}
	public void setEmpPoliticsStatus(String empPoliticsStatus){
		this.empPoliticsStatus=empPoliticsStatus;
	}
	public String getEmpPoliticsStatus(){
		return empPoliticsStatus;
	}
	public void setEmpEducation(String empEducation){
		this.empEducation=empEducation;
	}
	public String getEmpEducation(){
		return empEducation;
	}
	public void setEmpNativePlace(String empNativePlace){
		this.empNativePlace=empNativePlace;
	}
	public String getEmpNativePlace(){
		return empNativePlace;
	}
	public void setEmpNation(String empNation){
		this.empNation=empNation;
	}
	public String getEmpNation(){
		return empNation;
	}
	public void setEmpBirthday(Date empBirthday){
		this.empBirthday=empBirthday;
	}
	public Date getEmpBirthday(){
		return empBirthday;
	}
	public void setEmpHiredate(Date empHiredate){
		this.empHiredate=empHiredate;
	}
	public Date getEmpHiredate(){
		return empHiredate;
	}
	public void setEmpMaritalStatus(String empMaritalStatus){
		this.empMaritalStatus=empMaritalStatus;
	}
	public String getEmpMaritalStatus(){
		return empMaritalStatus;
	}
	public void setEmpManagerNo(String empManagerNo){
		this.empManagerNo=empManagerNo;
	}
	public String getEmpManagerNo(){
		return empManagerNo;
	}
	public void setEmpState(int empState){
		this.empState=empState;
	}
	public int getEmpState(){
		return empState;
	}
	public void setEmpWareNo(String empWareNo){
		this.empWareNo=empWareNo;
	}
	public String getEmpWareNo(){
		return empWareNo;
	}
	public void setEmpDeparmentId(String empDeparmentId){
		this.empDeparmentId=empDeparmentId;
	}
	public String getEmpDeparmentId(){
		return empDeparmentId;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public void setDuo3(String duo3){
		this.duo3=duo3;
	}
	public String getDuo3(){
		return duo3;
	}
	public void setDuo4(String duo4){
		this.duo4=duo4;
	}
	public String getDuo4(){
		return duo4;
	}
}

