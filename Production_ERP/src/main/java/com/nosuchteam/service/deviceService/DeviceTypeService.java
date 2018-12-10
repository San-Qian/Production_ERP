package com.nosuchteam.service.deviceService;

import com.nosuchteam.bean.DeviceType;

import java.util.List;
import java.util.Map;

/**
 * @author: SanQian
 * @create: 2018-12-06 14:30
 */

public interface DeviceTypeService {

   

    int insertDeviceType(DeviceType deviceType);

    int deleteDeviceType(String ids);

    int updateDeviceType(DeviceType deviceType);

    
    Map<Object, Object> findOnePageOfDeviceType(String page, String rows);

    Map<Object, Object> searchDeviceTypeByDeviceTypeName(String page, String rows, String searchValue);

    Map<Object, Object> searchDeviceTypeByDeviceTypeId(String page, String rows, String searchValue);


    DeviceType findBeanOfDeviceType(String id);

    List<DeviceType> findAllDeviceType();
}
