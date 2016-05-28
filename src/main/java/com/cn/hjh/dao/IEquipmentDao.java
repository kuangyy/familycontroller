package com.cn.hjh.dao;

import com.cn.hjh.po.EquipmentVO;

public interface IEquipmentDao {
    int deleteByPrimaryKey(String equipmentId);

    int insert(EquipmentVO record);

    int insertSelective(EquipmentVO record);

    EquipmentVO selectByPrimaryKey(String equipmentId);

    int updateByPrimaryKeySelective(EquipmentVO record);

    int updateByPrimaryKey(EquipmentVO record);
}