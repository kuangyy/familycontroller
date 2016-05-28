package com.cn.hjh.po;

public class FamilyVO {
    private String familyId;

    private String familyName;

    private String familyDesc;

    private String familyExtr;

    private String familyExtr1;

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId == null ? null : familyId.trim();
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName == null ? null : familyName.trim();
    }

    public String getFamilyDesc() {
        return familyDesc;
    }

    public void setFamilyDesc(String familyDesc) {
        this.familyDesc = familyDesc == null ? null : familyDesc.trim();
    }

    public String getFamilyExtr() {
        return familyExtr;
    }

    public void setFamilyExtr(String familyExtr) {
        this.familyExtr = familyExtr == null ? null : familyExtr.trim();
    }

    public String getFamilyExtr1() {
        return familyExtr1;
    }

    public void setFamilyExtr1(String familyExtr1) {
        this.familyExtr1 = familyExtr1 == null ? null : familyExtr1.trim();
    }
}