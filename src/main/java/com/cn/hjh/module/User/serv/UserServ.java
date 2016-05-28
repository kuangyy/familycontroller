package com.cn.hjh.module.User.serv;

import com.cn.hjh.po.UserVO;

import java.util.List;

/**
 * Created by hehe on 2016/4/16.
 */
public interface UserServ {
    void addUser(String name, String password);

    /**
     * 验证用户
     * 返回类型为int  -1为错误没有找到  其他的为userId
     *
     * @param userName
     * @param password
     * @return
     */
    int queryAccount(String userName, String password);

    //用户列表
    List<UserVO> list(UserVO userVO);


}