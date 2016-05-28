package com.cn.hjh.po;

public class EquipmentTypeVO {
    private Integer equipmentTypeId;

    private String equipmentTypeName;

    private String equipmentTypeClassName;

    public Integer getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Integer equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    public void setEquipmentTypeName(String equipmentTypeName) {
        this.equipmentTypeName = equipmentTypeName == null ? null : equipmentTypeName.trim();
    }

    public String getEquipmentTypeClassName() {
        return equipmentTypeClassName;
    }

    public void setEquipmentTypeClassName(String equipmentTypeClassName) {
        this.equipmentTypeClassName = equipmentTypeClassName == null ? null : equipmentTypeClassName.trim();
    }
}