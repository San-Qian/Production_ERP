package com.nosuchteam.controller;

import com.nosuchteam.bean.Device;

import com.nosuchteam.service.deviceService.DeviceListService;
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
 * @create: 2018-12-07 23:17
 */

@Controller
@RequestMapping("/deviceList")
public class DeviceListController {

    @Autowired
    DeviceListService deviceListService;

    /*返回给对方数据*//*
    @RequestMapping("/get_data")
    @ResponseBody
    public DeviceAccountVO returnData(String ) {
        deviceListService.
        return null;
    }*/


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
    public String addDeviceType() {
        return "device_manage/deviceList_add";
    }

    @RequestMapping("/edit")
    public String editDeviceType() {
        return "device_manage/deviceList_edit";
    }


    @RequestMapping("/insert")
    @ResponseBody
    public Map<Object, Object> insertDeviceList(Device device) {
        int i = deviceListService.insertDeviceList(device);
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
    public Map<Object, Object> deleteOneDeviceList(String[] ids) {
        int sum = 0;
        for (String s : ids) {
            int i = deviceListService.deleteDeviceList(s);
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
    public Map<Object, Object> updateDeviceList(Device device) {
        int i = deviceListService.updateDeviceList(device);
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
    public Map<Object, Object> findOnePageOfDeviceList(String page, String rows) {
        Map<Object, Object> deviceListPage = deviceListService.findOnePageOfDeviceList(page, rows);
        return deviceListPage;
    }
    /*根据URL 返回一个bean的json*/
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Device findBeanOfDeviceType(@PathVariable String id) {
        Device device = deviceListService.findBeanOfDeviceList(id);
        return device;
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Device> findBeanOfDeviceType() {
        List<Device> deviceList = deviceListService.findAllDeviceList();
        return deviceList;
    }

     /*设备编号*/
    @RequestMapping("/search_device_by_deviceId")
    @ResponseBody
    public Map<Object,Object> searchDeviceByDeviceId(String page,String rows,String searchValue ) {

        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceByDeviceId = deviceListService.searchDeviceByDeviceId(page, rows, searchValue);
        return searchDeviceByDeviceId;
    }
    /*设备名称*/
    @RequestMapping("/search_device_by_deviceName")
    @ResponseBody
    public Map<Object,Object> searchDeviceByDeviceName(String page,String rows,String searchValue ) {

        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceByDeviceName = deviceListService.searchDeviceByDeviceName(page, rows, searchValue);
        return searchDeviceByDeviceName;
    }

    /*设备编号*/
    @RequestMapping("/search_device_by_deviceTypeName")
    @ResponseBody
    public Map<Object,Object> searchDeviceByDeviceTypeName(String page,String rows,String searchValue ) {

        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceByDeviceTypeName = deviceListService.searchDeviceByDeviceTypeName(page, rows, searchValue);
        return searchDeviceByDeviceTypeName;
    }
    /* *//*设备种类编号*//*
    @RequestMapping("/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public Map<Object,Object> searchDeviceTypeByDeviceTypeId(String page,String rows,String searchValue) {

        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceTypeByDeviceTypeId = deviceTypeService.searchDeviceTypeByDeviceTypeId(page, rows, searchValue);
        return searchDeviceTypeByDeviceTypeId;
    }*/

}
