package com.nosuchteam.mapper;

import com.nosuchteam.bean.DeviceType;

import java.util.HashMap;
import java.util.List;

public interface DeviceTypeMapper {
    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    List<DeviceType> findAllDeviceType();

    List<DeviceType> searchDeviceTypeByDeviceTypeName(String searchValue);

    List<DeviceType> searchDeviceTypeByDeviceTypeId(String searchValue);
   String selectDeviceTypeNameByPrimaryKey(String deviceTypeId);
}