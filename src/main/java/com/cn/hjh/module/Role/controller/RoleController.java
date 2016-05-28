package com.cn.hjh.module.Role.controller;

import com.cn.hjh.module.Role.serv.RoleServ;
import com.cn.hjh.po.RoleVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hehe on 2016/4/24.
 */
@Controller
@RequestMapping("role")
public class RoleController {
    @Resource
    private RoleServ roleServ;
    /**
     * 进行显示
     * @return
     */
    @RequestMapping("showRoles")
    public ModelAndView showRoles(){
        List<RoleVO> roleList = roleServ.queryAll();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("roleList",roleList);
        return new ModelAndView("backage/role/role_show",map);
    }
    /**
     * 进行删除
     * @param roleId
     * @return
     */
    @RequestMapping("delete/{roleId}")
    public ModelAndView delete(@PathVariable int roleId){
        roleServ.delete(roleId);
        return showRoles();
    }

    @RequestMapping("updateRole")
    public ModelAndView update(RoleVO role){
        System.out.println(123);
        System.out.println(role);
        boolean tj = roleServ.updateRole(role);
        return showRoles();
    }
}
