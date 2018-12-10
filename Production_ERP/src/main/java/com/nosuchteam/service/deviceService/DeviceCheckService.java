package com.nosuchteam.service.deviceService;

import com.nosuchteam.bean.DeviceCheck;

import java.util.List;
import java.util.Map;

/**
 * @author: SanQian
 * @create: 2018-12-08 09:45
 */
public interface DeviceCheckService {
    Map<Object, Object> findOnePageOfDeviceCheck(String page, String rows);

    List<DeviceCheck> findAllDeviceCheck();

    DeviceCheck findBeanOfDeviceCheck(String id);

    int insertDeviceCheck(DeviceCheck deviceCheck);

    int deleteDeviceCheck(String s);

    int updateDeviceCheck(DeviceCheck deviceCheck);

    Map<Object, Object> searchDeviceCheckByDeviceCheckId(String page, String rows, String searchValue);

    Map<Object, Object> searchDeviceCheckByDeviceName(String page, String rows, String searchValue);
}
