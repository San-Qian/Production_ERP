package com.nosuchteam.mapper;

import com.nosuchteam.bean.DeviceCheck;

public interface DeviceCheckMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);
}