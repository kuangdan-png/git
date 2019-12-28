package com.medicine.pojo;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-11 15:49
 * @Description: 角色权限
 */
public class RoleAuthority {
    private String roleAuthNo;
    private String rolNo;
    private String authFirstMenuNo;
    private String authSecondMenuNo;
    private String authActionNo;
    private String roleAuthDesc;

    public RoleAuthority() {
    }

    @Override
    public String toString() {
        return "RoleAuthority{" +
                "roleAuthNo='" + roleAuthNo + '\'' +
                ", rolNo='" + rolNo + '\'' +
                ", authFirstMenuNo='" + authFirstMenuNo + '\'' +
                ", authSecondMenuNo='" + authSecondMenuNo + '\'' +
                ", authActionNo='" + authActionNo + '\'' +
                ", roleAuthDesc='" + roleAuthDesc + '\'' +
                '}';
    }

    public RoleAuthority(String roleAuthNo, String rolNo, String authFirstMenuNo) {
        this.roleAuthNo = roleAuthNo;
        this.rolNo = rolNo;
        this.authFirstMenuNo = authFirstMenuNo;
    }

    public RoleAuthority(String roleAuthNo, String rolNo, String authFirstMenuNo, String authSecondMenuNo, String authActionNo, String roleAuthDesc) {
        this.roleAuthNo = roleAuthNo;
        this.rolNo = rolNo;
        this.authFirstMenuNo = authFirstMenuNo;
        this.authSecondMenuNo = authSecondMenuNo;
        this.authActionNo = authActionNo;
        this.roleAuthDesc = roleAuthDesc;
    }

    public String getRoleAuthNo() {
        return roleAuthNo;
    }

    public void setRoleAuthNo(String roleAuthNo) {
        this.roleAuthNo = roleAuthNo;
    }

    public String getRolNo() {
        return rolNo;
    }

    public void setRolNo(String rolNo) {
        this.rolNo = rolNo;
    }

    public String getAuthFirstMenuNo() {
        return authFirstMenuNo;
    }

    public void setAuthFirstMenuNo(String authFirstMenuNo) {
        this.authFirstMenuNo = authFirstMenuNo;
    }

    public String getAuthSecondMenuNo() {
        return authSecondMenuNo;
    }

    public void setAuthSecondMenuNo(String authSecondMenuNo) {
        this.authSecondMenuNo = authSecondMenuNo;
    }

    public String getAuthActionNo() {
        return authActionNo;
    }

    public void setAuthActionNo(String authActionNo) {
        this.authActionNo = authActionNo;
    }

    public String getRoleAuthDesc() {
        return roleAuthDesc;
    }

    public void setRoleAuthDesc(String roleAuthDesc) {
        this.roleAuthDesc = roleAuthDesc;
    }
}
