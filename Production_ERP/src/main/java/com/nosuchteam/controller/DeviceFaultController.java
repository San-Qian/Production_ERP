package com.nosuchteam.controller;

import com.nosuchteam.bean.DeviceFault;
import com.nosuchteam.service.deviceService.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: SanQian
 * @create: 2018-12-08 22:10
 */
@Controller
@RequestMapping("/deviceFault")
public class DeviceFaultController {

    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge() {
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge() {
        return null;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge() {
        return null;
    }


    @RequestMapping("/add")
    public String addDeviceFault() {
        return "device_manage/deviceFault_add";
    }

    @RequestMapping("/edit")
    public String editDeviceFault() {
        return "device_manage/deviceFault_edit";
    }



    @RequestMapping("/insert")
    @ResponseBody
    public Map<Object, Object> insertDeviceFault(DeviceFault deviceFault) {
        int i = deviceFaultService.insertDeviceFault(deviceFault);
        Map<Object, Object> map = new HashMap<Object, Object>();
        if (i == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        } else {
            map.put("status", 500);
            map.put("msg", "error");
            map.put("data", null);
        }
        return map;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<Object, Object> deleteOneDeviceFault(String[] ids) {
        int sum = 0;
        for (String s : ids) {
            int i = deviceFaultService.deleteDeviceFault(s);
            if (i == 1) {
                sum++;
            }
        }
        Map<Object, Object> map = new HashMap<Object, Object>();
        if (sum == ids.length) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        } else {
            map.put("status", 500);
            map.put("msg", "error");
            map.put("data", null);
        }
        return map;
    }


    @RequestMapping("/update")
    @ResponseBody
    public Map<Object, Object> updateDeviceFault(DeviceFault deviceFault) {
        int i = deviceFaultService.updateDeviceFault(deviceFault);
        Map<Object, Object> map = new HashMap<Object, Object>();
        if (i == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        } else {
            map.put("status", 500);
            map.put("msg", "error");
            map.put("data", null);
        }
        return map;
    }


    @RequestMapping("/list")
    @ResponseBody
    public Map<Object,Object> findOnePageOfDeviceFault(String page, String rows) {
        Map<Object,Object> deviceFaultPage = deviceFaultService.findOnePageOfDeviceFault(page, rows);
        return deviceFaultPage;
    }
    /*根据URL 返回一个bean的json*/
    @RequestMapping("/get/{id}")
    @ResponseBody
    public DeviceFault findBeanOfDeviceType(@PathVariable String id) {
        DeviceFault deviceFault = deviceFaultService.findBeanOfDeviceFault(id);
        return deviceFault;
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceFault> findBeanOfDeviceType() {
        List<DeviceFault> deviceFault = deviceFaultService.findAllDeviceFault();
        return deviceFault;
    }

    /*设备故障编号*/
    @RequestMapping("/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public Map<Object,Object> searchDeviceFaultByDeviceFaultId(String page,String rows,String searchValue ) {

        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceFaultByDeviceFaultId = deviceFaultService.searchDeviceFaultByDeviceFaultId(page, rows, searchValue);
        return searchDeviceFaultByDeviceFaultId;
    }

    /*设备名称*/
    @RequestMapping("/search_deviceFault_by_deviceName")
    @ResponseBody
    public Map<Object,Object> searchDeviceFaultByDeviceName(String page,String rows,String searchValue) {

        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceFaultByDeviceName = deviceFaultService.searchDeviceFaultByDeviceName(page, rows, searchValue);
        return searchDeviceFaultByDeviceName;
    }

}
