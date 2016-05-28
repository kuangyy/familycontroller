package com.cn.hjh.dao;

import com.cn.hjh.po.UserFamilyVO;

public interface UserFamilyVOMapper {
    int deleteByPrimaryKey(Integer userFamilyId);

    int insert(UserFamilyVO record);

    int insertSelective(UserFamilyVO record);

    UserFamilyVO selectByPrimaryKey(Integer userFamilyId);

    int updateByPrimaryKeySelective(UserFamilyVO record);

    int updateByPrimaryKey(UserFamilyVO record);
}