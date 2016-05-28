package com.cn.hjh.dao;

import com.cn.hjh.po.FamilyVO;

import java.util.List;
import java.util.Map;

public interface IFamilyDao {
    int deleteByPrimaryKey(String familyId);

    int insert(FamilyVO record);

    int insertSelective(FamilyVO record);

    FamilyVO selectByPrimaryKey(String familyId);

    int updateByPrimaryKeySelective(FamilyVO record);

    int updateByPrimaryKey(FamilyVO record);


    List<FamilyVO> list(Map map);
}