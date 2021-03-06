package com.cn.hjh.dao;

import com.cn.hjh.po.EquipmentTypeVO;

import java.util.List;

public interface IEquipmentTypeDao {
    int deleteByPrimaryKey(Integer equipmentTypeId);

    int insert(EquipmentTypeVO record);

    int insertSelective(EquipmentTypeVO record);

    EquipmentTypeVO selectByPrimaryKey(Integer equipmentTypeId);

    int updateByPrimaryKeySelective(EquipmentTypeVO record);

    int updateByPrimaryKey(EquipmentTypeVO record);

    List<EquipmentTypeVO> getList();
}