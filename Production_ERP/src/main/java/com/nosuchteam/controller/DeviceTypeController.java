package com.nosuchteam.controller;

import com.nosuchteam.bean.DeviceType;
import com.nosuchteam.service.deviceService.DeviceTypeService;
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
 * @create: 2018-12-06 23:12
 */
@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;

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
        return "device_manage/deviceType_add";
    }

    @RequestMapping("/edit")
    public String editDeviceType() {
        return "device_manage/deviceType_edit";
    }



    @RequestMapping("/insert")
    @ResponseBody
    public Map<Object, Object> insertDeviceType(DeviceType deviceType) {
        int i = deviceTypeService.insertDeviceType(deviceType);
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
    public Map<Object, Object> deleteOneDeviceType(String[] ids) {
        int sum = 0;
        for (String s : ids) {
            int i = deviceTypeService.deleteDeviceType(s);
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
    public Map<Object, Object> updateDeviceType(DeviceType deviceType) {
        int i = deviceTypeService.updateDeviceType(deviceType);
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
    public Map<Object,Object> findOnePageOfDeviceType(String page,String rows) {
        Map<Object,Object> DeviceTypePage = deviceTypeService.findOnePageOfDeviceType(page, rows);
        return DeviceTypePage;
    }
    /*根据URL 返回一个bean的json*/
    @RequestMapping("/get/{id}")
    @ResponseBody
    public DeviceType findBeanOfDeviceType(@PathVariable String id) {
        DeviceType deviceType = deviceTypeService.findBeanOfDeviceType(id);
        return deviceType;
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceType> findBeanOfDeviceType() {
        List<DeviceType> deviceTypeList = deviceTypeService.findAllDeviceType();
        return deviceTypeList;
    }



    /*设备种类名称*/
    @RequestMapping("/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public Map<Object,Object> searchDeviceTypeByDeviceTypeName(String page,String rows,String searchValue ) {

         searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceTypeByDeviceTypeName = deviceTypeService.searchDeviceTypeByDeviceTypeName(page, rows, searchValue);
        return searchDeviceTypeByDeviceTypeName;
    }

    /*设备种类编号*/
    @RequestMapping("/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public Map<Object,Object> searchDeviceTypeByDeviceTypeId(String page,String rows,String searchValue) {
        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceTypeByDeviceTypeId = deviceTypeService.searchDeviceTypeByDeviceTypeId(page, rows, searchValue);
        return searchDeviceTypeByDeviceTypeId;
    }


}
