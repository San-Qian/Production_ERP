package com.nosuchteam.controller;

import com.nosuchteam.bean.DeviceMaintain;
import com.nosuchteam.service.deviceService.DeviceMaintainService;
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
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

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
    public String addDeviceMaintain() {
        return "device_manage/deviceMaintain_add";
    }

    @RequestMapping("/edit")
    public String editDeviceMaintain() {
        return "device_manage/deviceMaintain_edit";
    }



    @RequestMapping("/insert")
    @ResponseBody
    public Map<Object, Object> insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainService.insertDeviceMaintain(deviceMaintain);
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
    public Map<Object, Object> deleteOneDeviceMaintain(String[] ids) {
        int sum = 0;
        for (String s : ids) {
            int i = deviceMaintainService.deleteDeviceMaintain(s);
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
    public Map<Object, Object> updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainService.updateDeviceMaintain(deviceMaintain);
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
    public Map<Object,Object> findOnePageOfDeviceMaintain(String page, String rows) {
        Map<Object,Object> deviceMaintainPage = deviceMaintainService.findOnePageOfDeviceMaintain(page, rows);
        return deviceMaintainPage;
    }
    /*根据URL 返回一个bean的json*/
    @RequestMapping("/get/{id}")
    @ResponseBody
    public DeviceMaintain findBeanOfDeviceType(@PathVariable String id) {
        DeviceMaintain deviceMaintain = deviceMaintainService.findBeanOfDeviceMaintain(id);
        return deviceMaintain;
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceMaintain> findBeanOfDeviceType() {
        List<DeviceMaintain> deviceMaintain = deviceMaintainService.findAllDeviceMaintain();
        return deviceMaintain;
    }

    /*设备维修编号*/
    @RequestMapping("/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public Map<Object,Object> searchDeviceMaintainByDeviceMaintainId(String page,String rows,String searchValue ) {

        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceMaintainByDeviceMaintainId = deviceMaintainService.searchDeviceMaintainByDeviceMaintainId(page, rows, searchValue);
        return searchDeviceMaintainByDeviceMaintainId;
    }

    /*故障编号*/
    @RequestMapping("/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public Map<Object,Object> searchDeviceMaintainByDeviceFaultId(String page,String rows,String searchValue) {

        searchValue = "%" + searchValue + "%";
        Map<Object,Object> searchDeviceMaintainByDeviceFaultId = deviceMaintainService.searchDeviceMaintainByDeviceFaultId(page, rows, searchValue);
        return searchDeviceMaintainByDeviceFaultId;
    }

}
