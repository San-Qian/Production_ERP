package com.nosuchteam.service.deviceService;

import com.nosuchteam.bean.DeviceMaintain;

import java.util.List;
import java.util.Map;

/**
 * @author: SanQian
 * @create: 2018-12-08 09:43
 */
public interface DeviceMaintainService {
    Map<Object, Object> findOnePageOfDeviceMaintain(String page, String rows);

    int insertDeviceMaintain(DeviceMaintain deviceMaintain);

    int deleteDeviceMaintain(String s);

    int updateDeviceMaintain(DeviceMaintain deviceMaintain);

    DeviceMaintain findBeanOfDeviceMaintain(String id);

    List<DeviceMaintain> findAllDeviceMaintain();

    Map<Object, Object> searchDeviceMaintainByDeviceMaintainId(String page, String rows, String searchValue);

    Map<Object, Object> searchDeviceMaintainByDeviceFaultId(String page, String rows, String searchValue);
}
