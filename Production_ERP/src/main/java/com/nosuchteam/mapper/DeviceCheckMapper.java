package com.nosuchteam.mapper;

import com.nosuchteam.bean.DeviceCheck;
import com.nosuchteam.bean.vo.DeviceCheckVO;

import java.util.List;

public interface DeviceCheckMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);

    List<DeviceCheck> findAllDeviceCheck();


    List<DeviceCheckVO> findAllDeviceCheckVO();

    List<DeviceCheckVO> searchDeviceCheckByDeviceCheckId(String searchValue);

    List<DeviceCheckVO> searchDeviceCheckByDeviceName(String searchValue);
}