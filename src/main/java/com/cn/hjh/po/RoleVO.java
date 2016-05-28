package com.cn.hjh.po;

import java.util.Date;

public class RoleVO {

    /**
     * 角色禁用
     */
    public static final int ROLEVO_LOCK = 1;
    /**
     * 角色正在使用中
     */
    public static final int ROLEVO_UNLOCK = 0;

    private Integer roleId;

    private String roleName;

    private Date roleCreateDate;

    private String roleDesc;

    private Integer isLock;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getRoleCreateDate() {
        return roleCreateDate;
    }

    public void setRoleCreateDate(Date roleCreateDate) {
        this.roleCreateDate = roleCreateDate;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    @Override
    public String toString() {
        return roleId+roleName +roleDesc;
    }
}