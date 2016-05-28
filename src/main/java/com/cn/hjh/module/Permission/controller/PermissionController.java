package com.cn.hjh.module.Permission.controller;

import com.cn.hjh.module.Permission.serv.PermissionServ;
import com.cn.hjh.po.PermissionVO;
import com.cn.hjh.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hehe on 2016/4/22.
 */
@RequestMapping("permission")
@Controller("permissionController")
public class PermissionController {

    @Resource
    private PermissionServ permissionServ;

    public  void test(){
        int userId = 1;
        List<PermissionVO> permissions = permissionServ.selectPermissionAllByUserId(userId);
        for(PermissionVO permission:permissions){
            System.out.println(permission.getPermissions().get(0).getPermissionName());
        }
    }


    @RequestMapping("show/{roleId}")
    @ResponseBody
    public List<PermissionVO> showRolePermission(@PathVariable int roleId){
        return permissionServ.selectPermissionAllByUserId(roleId);
    }

    @RequestMapping(value="modifyPermissions")
    @ResponseBody
    public Map<String,Object> modifyPermission(@RequestBody String data) throws IOException {
        PermissionVO[] permissions = JsonUtils.jsonParsePo(data,PermissionVO[].class);
        boolean tj = permissionServ.modifyPermission(permissions);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("flg",tj);
        return map;
    }
}
