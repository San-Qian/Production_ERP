package com.nosuchteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author: SanQian
 * @create: 2018-12-06 16:15
 */
@Controller
@RequestMapping("/device")
public class DeviceController {

    @RequestMapping("/deviceType")
    public String findOnePageOfDeviceType() {
        return "device_manage/deviceType";
    }

    @RequestMapping("/deviceCheck")
    public String findOnePageOfDeviceCheck() {
        return "device_manage/deviceCheck";
    }
    @RequestMapping("/deviceList")
    public String findOnePageOfDeviceList() {
        return "device_manage/deviceList";
    }
    @RequestMapping("/deviceFault")
    public String findOnePageOfDeviceFault() {
        return "device_manage/deviceFault";
    }
    @RequestMapping("/deviceMaintain")
    public String findOnePageOfDeviceMaintain() {
        return "device_manage/deviceMaintain";
    }

}
