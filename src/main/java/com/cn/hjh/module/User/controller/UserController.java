package com.cn.hjh.module.User.controller;

import com.cn.hjh.commom.Constants;
import com.cn.hjh.module.Permission.controller.PermissionController;
import com.cn.hjh.module.Permission.serv.PermissionServ;
import com.cn.hjh.module.User.serv.UserServ;
import com.cn.hjh.po.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by hehe on 2016/4/16.
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController  {

    @Resource
    private UserServ userServ;
    @Resource
    private PermissionServ permissionServ;


    @RequestMapping("/test")
    public String  test(){
        return "login";
    }

    @RequestMapping("/login")
    public ModelAndView  login(String userName ,String password,HttpServletRequest request) {
        int  key = userServ.queryAccount(userName, password);
        ModelAndView view = new ModelAndView();
        if(key != -1){
            request.getSession().setAttribute(Constants.User_SESSION_KEY,key);
            request.getSession().setAttribute(Constants.PERMISSION_SESSION_KEY,permissionServ.selectPermissions(key));
            request.getSession().setAttribute(Constants.ITEM_NAME,request.getContextPath());
            view.setViewName("backage/index");
        }else{
            view.addObject("message","false");
            view.setViewName("login");
        }
        return view;
    }


    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request){
        request.getSession().invalidate();
        return new ModelAndView("login");

    }

    public void insertUser(String name, String password) {
            userServ.addUser("黄辉","123123");
    }




    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, UserVO model){

        Map<String,Object> map = new HashMap<>();

        map.put("list", userServ.list(model));

        return new ModelAndView("backage/user/list",map);
    }


}
