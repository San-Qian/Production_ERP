package com.nosuchteam.service.deviceService.deviceServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Device;
import com.nosuchteam.bean.vo.DeviceAccountVO;
import com.nosuchteam.mapper.DeviceMapper;
import com.nosuchteam.service.deviceService.DeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: SanQian
 * @create: 2018-12-06 16:13
 */
@Service
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class DeviceListServiceImpl implements DeviceListService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public Device findBeanOfDeviceList(String id) {
        Device device = deviceMapper.selectByPrimaryKey(id);
        return device;
    }

    @Override
    public List<Device> findAllDeviceList() {
        List<Device> allDevice = deviceMapper.findAllDevice();
        return allDevice;
    }

    @Override
    public int insertDeviceList(Device device) {
        int update = deviceMapper.updateByPrimaryKeySelective(device);
        return update;
    }

    @Override
    public int updateDeviceList(Device device) {
        int update = deviceMapper.updateByPrimaryKeySelective(device);
        return update;
    }

    @Override
    public Map<Object, Object> searchDeviceByDeviceId(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceAccountVO> allDeviceList = deviceMapper.searchDeviceByDeviceId(searchValue);
        PageInfo<DeviceAccountVO> pageInfo=new PageInfo<>(allDeviceList);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map<Object, Object> searchDeviceByDeviceName(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceAccountVO> allDeviceList = deviceMapper.searchDeviceByDeviceName(searchValue);
        PageInfo<DeviceAccountVO> pageInfo=new PageInfo<>(allDeviceList);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map<Object, Object> searchDeviceByDeviceTypeName(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceAccountVO> allDeviceList = deviceMapper.searchDeviceByDeviceTypeName(searchValue);
        PageInfo<DeviceAccountVO> pageInfo=new PageInfo<>(allDeviceList);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }



   /* public Map<Object, Object> searchDeviceTypeByDeviceTypeName(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceType> allDeviceType = deviceTypeMapper.searchDeviceTypeByDeviceTypeName(searchValue);
        PageInfo<DeviceType> pageInfo=new PageInfo<>(allDeviceType);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;

    }*/

    /*public Map<Object, Object> searchDeviceTypeByDeviceTypeId(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceType> allDeviceType = deviceTypeMapper.searchDeviceTypeByDeviceTypeId(searchValue);
        PageInfo<DeviceType> pageInfo=new PageInfo<>(allDeviceType);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;

    }*/

    @Override
    public Map<Object, Object> findOnePageOfDeviceList(String page, String rows) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceAccountVO> allDeviceType = deviceMapper.findAllDeviceList();
        PageInfo<DeviceAccountVO> pageInfo=new PageInfo<>(allDeviceType);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public int deleteDeviceList(String s) {
        int i = deviceMapper.deleteByPrimaryKey(s);
        return i;
    }


}
