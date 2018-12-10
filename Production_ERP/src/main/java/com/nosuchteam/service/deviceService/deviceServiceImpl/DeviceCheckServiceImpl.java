package com.nosuchteam.service.deviceService.deviceServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.DeviceCheck;
import com.nosuchteam.bean.vo.DeviceCheckVO;
import com.nosuchteam.mapper.DeviceCheckMapper;
import com.nosuchteam.service.deviceService.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: SanQian
 * @create: 2018-12-06 16:13
 */
@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {
    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    public int insertDeviceCheck(DeviceCheck deviceCheck) {
        int insert = deviceCheckMapper.insert(deviceCheck);
        return insert;
    }

    public int deleteDeviceCheck(String ids) {
        int delete = deviceCheckMapper.deleteByPrimaryKey(ids);
        return delete;
    }

    public int updateDeviceCheck(DeviceCheck deviceCheck) {
        int update = deviceCheckMapper.updateByPrimaryKeySelective(deviceCheck);
        return update;
    }

    @Override
    public Map<Object, Object> searchDeviceCheckByDeviceCheckId(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceCheckVO> allDeviceCheck = deviceCheckMapper.searchDeviceCheckByDeviceCheckId(searchValue);
        PageInfo<DeviceCheckVO> pageInfo=new PageInfo<>(allDeviceCheck);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map<Object, Object> searchDeviceCheckByDeviceName(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceCheckVO> allDeviceCheck = deviceCheckMapper.searchDeviceCheckByDeviceName(searchValue);
        PageInfo<DeviceCheckVO> pageInfo=new PageInfo<>(allDeviceCheck);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    @Override
    public DeviceCheck findBeanOfDeviceCheck(String id) {
        DeviceCheck deviceCheck = deviceCheckMapper.selectByPrimaryKey(id);
        return deviceCheck;
    }

    @Override
    public List<DeviceCheck> findAllDeviceCheck() {
        List<DeviceCheck> allDeviceCheck = deviceCheckMapper.findAllDeviceCheck();
        return allDeviceCheck;
    }


    public Map<Object, Object> findOnePageOfDeviceCheck(String page, String rows) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceCheckVO> deviceCheckVO = deviceCheckMapper.findAllDeviceCheckVO();
        PageInfo<DeviceCheckVO> pageInfo=new PageInfo<>(deviceCheckVO);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
