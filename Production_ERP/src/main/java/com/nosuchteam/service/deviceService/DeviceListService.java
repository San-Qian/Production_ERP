package com.nosuchteam.service.deviceService;

import com.nosuchteam.bean.Device;

import java.util.List;
import java.util.Map;

/**
 * @author: SanQian
 * @create: 2018-12-08 09:43
 */
public interface DeviceListService {
    Map<Object, Object> findOnePageOfDeviceList(String page, String rows);



    int deleteDeviceList(String s);


    Device findBeanOfDeviceList(String id);

    List<Device> findAllDeviceList();

    int insertDeviceList(Device device);

    int updateDeviceList(Device device);

    Map<Object, Object> searchDeviceByDeviceId(String page, String rows, String searchValue);

    Map<Object, Object> searchDeviceByDeviceName(String page, String rows, String searchValue);

    Map<Object, Object> searchDeviceByDeviceTypeName(String page, String rows, String searchValue);
}
