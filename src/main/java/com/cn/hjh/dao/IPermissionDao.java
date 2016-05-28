package com.cn.hjh.dao;

import com.cn.hjh.po.PermissionVO;

import java.util.List;

public interface IPermissionDao {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(PermissionVO record);

    int insertSelective(PermissionVO record);

    PermissionVO selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(PermissionVO record);

    int updateByPrimaryKey(PermissionVO record);

    List<PermissionVO> selectPermissionByUserId(int userId);

    List<PermissionVO> selectPermissionAllByUserId(int roleId);

    int addPermission(PermissionVO p);

    int deletePermission(PermissionVO p);

}