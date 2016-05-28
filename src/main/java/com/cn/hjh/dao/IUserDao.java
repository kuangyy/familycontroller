package com.cn.hjh.dao;

import com.cn.hjh.po.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserVO record);

    int insertSelective(UserVO record);

    UserVO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserVO record);

    int updateByPrimaryKey(UserVO record);

    List<UserVO> selectUsers(UserVO userVO);
}