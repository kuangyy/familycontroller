package com.cn.hjh.module.Permission.serv.impl;

import com.cn.hjh.dao.IPermissionDao;
import com.cn.hjh.module.Permission.serv.PermissionServ;
import com.cn.hjh.po.PermissionVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hehe on 2016/4/22.
 */
@Service("permissionServ")
public class PermissionServImpl implements PermissionServ{

    @Resource
    private IPermissionDao permissionDao;

    public List<PermissionVO> selectPermissions(int userId) {
        return permissionDao.selectPermissionByUserId(userId);
    }

    public List<PermissionVO> selectPermissionAllByUserId(int roleId) {
        return permissionDao.selectPermissionAllByUserId(roleId);
    }

    public boolean modifyPermission(PermissionVO[] permissions) {
        for(PermissionVO p:permissions){
            if(p.getPermissionExtr().equals("true")){
                permissionDao.addPermission(p);
            }else{
                permissionDao.deletePermission(p);
            }
        }
        return true;
    }
}
