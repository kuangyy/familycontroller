package com.cn.hjh.module.Role.serv;

import com.cn.hjh.po.RoleVO;

import java.util.List;

/**
 * Created by hehe on 2016/4/24.
 */
public interface RoleServ {
    /**
     * 查询到所有
     */
    List<RoleVO> queryAll();

    /**
     * 通过roleId进行删除 角色
     * @param roleId
     */
    int delete(int roleId);

    /**
     * 修改权限
     * @param role
     * @return
     */
    boolean updateRole(RoleVO role);
}
