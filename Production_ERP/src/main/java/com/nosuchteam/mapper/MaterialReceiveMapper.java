package com.nosuchteam.mapper;

import com.nosuchteam.bean.MaterialReceive;

public interface MaterialReceiveMapper {
    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);
}