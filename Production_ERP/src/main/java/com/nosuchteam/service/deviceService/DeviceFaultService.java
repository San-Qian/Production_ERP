package com.nosuchteam.service.deviceService;

import com.nosuchteam.bean.DeviceFault;

import java.util.List;
import java.util.Map;

/**
 * @author: SanQian
 * @create: 2018-12-08 09:44
 */
public interface DeviceFaultService {
    Map<Object, Object> findOnePageOfDeviceFault(String page, String rows);

    int insertDeviceFault(DeviceFault deviceFault);

    int deleteDeviceFault(String s);

    int updateDeviceFault(DeviceFault deviceFault);

    DeviceFault findBeanOfDeviceFault(String id);

    List<DeviceFault> findAllDeviceFault();

    Map<Object, Object> searchDeviceFaultByDeviceFaultId(String page, String rows, String searchValue);

    Map<Object, Object> searchDeviceFaultByDeviceName(String page, String rows, String searchValue);
}
