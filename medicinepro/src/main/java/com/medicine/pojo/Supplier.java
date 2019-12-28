package com.medicine.pojo;

/**
 * @Auther:匡佩
 * @Date: 2019/11/25 0025 16:22
 * @Description:该实体类为供货商实体类
 *
 */
public class Supplier {
    private String supID;//供货商编号
    private String supName;//供货商名称
    private String supLinkman;//联系人
    private String supPhone;//联系电话
    private Double supMoney;//我方应付金额
    private String supAddressNo;//联系地址编号
    private String supAddress;//详细地址
    private String supRegion;//所属地区
    private int supDefault;//默认供货商
    private String supComment;//备注
    private String disName;//区
    private String citName;//市
    private String proName;//省
    private Address address;
    private String disID;//区
    private String citID;//市
    private String proID;//省
    private String duo1;

    public String getDuo1() {
        return duo1;
    }

    public void setDuo1(String duo1) {
        this.duo1 = duo1;
    }

    public String getDisID() {
        return disID;
    }

    public void setDisID(String disID) {
        this.disID = disID;
    }

    public String getCitID() {
        return citID;
    }

    public void setCitID(String citID) {
        this.citID = citID;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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

    public String getSupID() {
        return supID;
    }

    public void setSupID(String supID) {
        this.supID = supID;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupLinkman() {
        return supLinkman;
    }

    public void setSupLinkman(String supLinkman) {
        this.supLinkman = supLinkman;
    }

    public String getSupPhone() {
        return supPhone;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone;
    }

    public Double getSupMoney() {
        return supMoney;
    }

    public void setSupMoney(Double supMoney) {
        this.supMoney = supMoney;
    }

    public String getSupAddressNo() {
        return supAddressNo;
    }

    public void setSupAddressNo(String supAddressNo) {
        this.supAddressNo = supAddressNo;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }

    public String getSupRegion() {
        return supRegion;
    }

    public void setSupRegion(String supRegion) {
        this.supRegion = supRegion;
    }

    public int getSupDefault() {
        return supDefault;
    }

    public void setSupDefault(int supDefault) {
        this.supDefault = supDefault;
    }

    public String getSupComment() {
        return supComment;
    }

    public void setSupComment(String supComment) {
        this.supComment = supComment;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supID='" + supID + '\'' +
                ", supName='" + supName + '\'' +
                ", supLinkman='" + supLinkman + '\'' +
                ", supPhone='" + supPhone + '\'' +
                ", supMoney=" + supMoney +
                ", supAddressNo='" + supAddressNo + '\'' +
                ", supAddress='" + supAddress + '\'' +
                ", supRegion='" + supRegion + '\'' +
                ", supDefault=" + supDefault +
                ", supComment='" + supComment + '\'' +
                '}';
    }

    public Supplier() {
    }

    public Supplier(String supID, String supName, String supLinkman, String supPhone, Double supMoney, String supAddressNo, String supAddress, String supRegion, int supDefault, String supComment) {
        this.supID = supID;
        this.supName = supName;
        this.supLinkman = supLinkman;
        this.supPhone = supPhone;
        this.supMoney = supMoney;
        this.supAddressNo = supAddressNo;
        this.supAddress = supAddress;
        this.supRegion = supRegion;
        this.supDefault = supDefault;
        this.supComment = supComment;
    }
}
