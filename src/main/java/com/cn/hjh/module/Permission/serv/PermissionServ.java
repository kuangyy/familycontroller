package com.cn.hjh.module.Permission.serv;

import com.cn.hjh.po.PermissionVO;

import java.util.List;

/**
 * Created by hehe on 2016/4/22.
 */
public interface PermissionServ {
    /**
     * 通过userId得到他的权限
     * @param userId
     * @return
     */
    List<PermissionVO> selectPermissions(int userId);

    /**
     * 通过
     * @param
     * @return
     */
    List<PermissionVO> selectPermissionAllByUserId(int roleId);

    /**
     * 通过穿过来的修改的permission 就行修改权限
     * @param permissions
     * @return
     */
    boolean modifyPermission(PermissionVO[] permissions);
    
}
