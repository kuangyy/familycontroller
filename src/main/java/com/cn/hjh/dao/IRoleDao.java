package com.cn.hjh.dao;

import com.cn.hjh.po.RoleVO;

import java.util.List;

public interface IRoleDao {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleVO record);

    int insertSelective(RoleVO record);

    RoleVO selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleVO record);

    int updateByPrimaryKey(RoleVO record);

    List<RoleVO> selectAll();
}