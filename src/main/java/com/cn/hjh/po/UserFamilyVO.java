package com.cn.hjh.po;

public class UserFamilyVO {
    private Integer userFamilyId;

    private Integer userId;

    private String familyId;

    public Integer getUserFamilyId() {
        return userFamilyId;
    }

    public void setUserFamilyId(Integer userFamilyId) {
        this.userFamilyId = userFamilyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId == null ? null : familyId.trim();
    }
}