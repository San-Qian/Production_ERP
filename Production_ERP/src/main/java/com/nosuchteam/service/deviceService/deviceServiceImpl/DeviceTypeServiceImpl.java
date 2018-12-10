package com.nosuchteam.service.deviceService.deviceServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.DeviceType;
import com.nosuchteam.mapper.DeviceTypeMapper;
import com.nosuchteam.service.deviceService.DeviceTypeService;
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
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;


    public int insertDeviceType(DeviceType deviceType) {
        int insert = deviceTypeMapper.insert(deviceType);
        return insert;
    }

    public int deleteDeviceType(String ids) {
        int delete = deviceTypeMapper.deleteByPrimaryKey(ids);
        return delete;
    }

    public int updateDeviceType(DeviceType deviceType) {
        int update = deviceTypeMapper.updateByPrimaryKeySelective(deviceType);
        return update;
    }

    public Map<Object, Object> searchDeviceTypeByDeviceTypeName(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceType> allDeviceType = deviceTypeMapper.searchDeviceTypeByDeviceTypeName(searchValue);
        PageInfo<DeviceType> pageInfo=new PageInfo<>(allDeviceType);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;



       /*
        DeviceTypeVO deviceTypeVO = new DeviceTypeVO();
        int limit = Integer.parseInt(rows);
        int offset = (Integer.parseInt(page) - 1) * Integer.parseInt(rows);
        List<DeviceType> deviceTypeList = deviceTypeMapper.searchDeviceTypeByDeviceTypeName(searchValue, limit, offset);
        deviceTypeVO.setTotal(deviceTypeList.size());
        deviceTypeVO.setRows(deviceTypeList);
        return deviceTypeVO;*/
    }

    public Map<Object, Object> searchDeviceTypeByDeviceTypeId(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceType> allDeviceType = deviceTypeMapper.searchDeviceTypeByDeviceTypeId(searchValue);
        PageInfo<DeviceType> pageInfo=new PageInfo<>(allDeviceType);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;


    }

    @Override
    public DeviceType findBeanOfDeviceType(String id) {
        List<DeviceType> deviceTypeList = deviceTypeMapper.searchDeviceTypeByDeviceTypeId(id);
        return deviceTypeList.get(0);
    }

    @Override
    public List<DeviceType> findAllDeviceType() {
        List<DeviceType> allDeviceType = deviceTypeMapper.findAllDeviceType();
        return allDeviceType;
    }


    public Map<Object, Object> findOnePageOfDeviceType(String page, String rows) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceType> allDeviceType = deviceTypeMapper.findAllDeviceType();
        PageInfo<DeviceType> pageInfo=new PageInfo<>(allDeviceType);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
