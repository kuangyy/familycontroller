package com.cn.hjh.module.Role.serv.RoleServImpl;

import com.cn.hjh.dao.IRoleDao;
import com.cn.hjh.module.Role.serv.RoleServ;
import com.cn.hjh.po.RoleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hehe on 2016/4/24.
 */
@Service("roleServ")
public class RoleServImpl implements RoleServ {

    @Resource
    private IRoleDao roleDao;
    public List<RoleVO> queryAll() {
        return roleDao.selectAll();
    }

    public int  delete(int roleId) {
        return roleDao.deleteByPrimaryKey(roleId);
    }

    public boolean updateRole(RoleVO role) {
        return roleDao.updateByPrimaryKeySelective(role) != 0;
    }
}
