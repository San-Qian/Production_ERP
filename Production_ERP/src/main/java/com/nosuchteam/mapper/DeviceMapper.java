package com.nosuchteam.mapper;

import com.nosuchteam.bean.Device;
import com.nosuchteam.bean.vo.DeviceAccountVO;

import java.util.List;

public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    List<Device> findAllDevice();


    List<DeviceAccountVO> findAllDeviceList();

    List<DeviceAccountVO> searchDeviceByDeviceId(String searchValue);

    List<DeviceAccountVO> searchDeviceByDeviceName(String searchValue);

    List<DeviceAccountVO> searchDeviceByDeviceTypeName(String searchValue);
    String selectDeviceNameByPrimaryKey(String deviceId);
}