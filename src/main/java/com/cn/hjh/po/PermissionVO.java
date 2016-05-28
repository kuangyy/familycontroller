package com.cn.hjh.po;


import java.util.List;
public class PermissionVO {
    private Integer permissionId;

    private String permissionName;

    private String permissionUrl;

    private Integer permissionParentId;

    private String permissionExtr;

    private String permissionExtr2;

    private List<PermissionVO> permissions;

    public PermissionVO(){

    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
    }

    public Integer getPermissionParentId() {
        return permissionParentId;
    }

    public void setPermissionParentId(Integer permissionParentId) {
        this.permissionParentId = permissionParentId;
    }

    public String getPermissionExtr() {
        return permissionExtr;
    }

    public void setPermissionExtr(String permissionExtr) {
        this.permissionExtr = permissionExtr == null ? null : permissionExtr.trim();
    }

    public String getPermissionExtr2() {
        return permissionExtr2;
    }

    public void setPermissionExtr2(String permissionExtr2) {
        this.permissionExtr2 = permissionExtr2 == null ? null : permissionExtr2.trim();
    }

    public List<PermissionVO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionVO> permissions) {
        this.permissions = permissions;
    }
}