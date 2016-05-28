package com.cn.hjh.dao;

import com.cn.hjh.po.RoomVO;

public interface IRoomDao {
    int deleteByPrimaryKey(Integer roomId);

    int insert(RoomVO record);

    int insertSelective(RoomVO record);

    RoomVO selectByPrimaryKey(Integer roomId);

    int updateByPrimaryKeySelective(RoomVO record);

    int updateByPrimaryKey(RoomVO record);
}