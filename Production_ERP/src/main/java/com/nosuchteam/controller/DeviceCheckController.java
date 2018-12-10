package com.nosuchteam.controller;

import com.nosuchteam.bean.DeviceCheck;
import com.nosuchteam.service.deviceService.DeviceCheckService;
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
@RequestMapping("/deviceCheck")
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

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
    public String addDeviceCheck() {
        return "device_manage/deviceCheck_add";
    }

    @RequestMapping("/edit")
    public String editDeviceCheck() {
        return "device_manage/deviceCheck_edit";
    }



   @RequestMapping("/insert")
    @ResponseBody
    public Map<Object, Object> insertDeviceCheck(DeviceCheck deviceCheck) {
        int i = deviceCheckService.insertDeviceCheck(deviceCheck);
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
    public Map<Object, Object> deleteOneDeviceCheck(String[] ids) {
        int sum = 0;
        for (String s : ids) {
            int i = deviceCheckService.deleteDeviceCheck(s);
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
    public Map<Object, Object> updateDeviceCheck(DeviceCheck deviceCheck) {
        int i = deviceCheckService.updateDeviceCheck(deviceCheck);
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
    public Map<Object,Object> findOnePageOfDeviceCheck(String page, String rows) {
        Map<Object,Object> deviceCheckPage = deviceCheckService.findOnePageOfDeviceCheck(page, rows);
        return deviceCheckPage;
    }
    /*根据URL 返回一个bean的json*/
    @RequestMapping("/get/{id}")
    @ResponseBody
    public DeviceCheck findBeanOfDeviceType(@PathVariable String id) {
        DeviceCheck deviceCheck = deviceCheckService.findBeanOfDeviceCheck(id);
        return deviceCheck;
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceCheck> findBeanOfDeviceType() {
        List<DeviceCheck> deviceCheck = deviceCheckService.findAllDeviceCheck();
        return deviceCheck;
    }

  /*设备例检编号*/
    @RequestMapping("/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public Map<Object,Object> searchDeviceCheckByDeviceCheckId(String page,String rows,String searchValue ) {

        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceCheckByDeviceCheckId = deviceCheckService.searchDeviceCheckByDeviceCheckId(page, rows, searchValue);
        return searchDeviceCheckByDeviceCheckId;
    }

    /*设备名称*/
    @RequestMapping("/search_deviceCheck_by_deviceName")
    @ResponseBody
    public Map<Object,Object> searchDeviceCheckByDeviceName(String page,String rows,String searchValue) {

        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceCheckByDeviceName = deviceCheckService.searchDeviceCheckByDeviceName(page, rows, searchValue);
        return searchDeviceCheckByDeviceName;
    }

}