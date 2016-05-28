package com.cn.hjh.module.User.serv.impl;

import com.cn.hjh.commom.Constants;
import com.cn.hjh.dao.IUserDao;
import com.cn.hjh.module.User.serv.UserServ;
import com.cn.hjh.po.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hehe on 2016/4/16.
 */
@Service("userServ")
public class UserServImpl implements UserServ {

    @Resource
    private IUserDao userDao;

    public void addUser(String name, String password) {
        UserVO user = new UserVO();
        user.setUserName(name);
        user.setUserPassword(password);
        userDao.insertSelective(user);
    }


    public int queryAccount(String userName, String password) {
        UserVO user = new UserVO();
        user.setUserName(userName.trim());
        user.setUserPassword(password.trim());
        List<UserVO> list = userDao.selectUsers(user);
        if (list.size() > 0) {
            return list.get(0).getUserId();
        }
        return -1;
    }


    public List<UserVO> list(UserVO userVO) {
        return userDao.selectUsers(userVO);
    }


}
