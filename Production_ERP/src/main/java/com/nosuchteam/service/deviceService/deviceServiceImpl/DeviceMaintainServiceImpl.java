package com.nosuchteam.service.deviceService.deviceServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.DeviceMaintain;
import com.nosuchteam.bean.vo.DeviceMaintainVO;
import com.nosuchteam.mapper.DeviceMaintainMapper;
import com.nosuchteam.service.deviceService.DeviceMaintainService;
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
public class DeviceMaintainServiceImpl implements DeviceMaintainService {
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    public int insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        int insert = deviceMaintainMapper.insert(deviceMaintain);
        return insert;
    }

    public int deleteDeviceMaintain(String ids) {
        int delete = deviceMaintainMapper.deleteByPrimaryKey(ids);
        return delete;
    }

    public int updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        int update = deviceMaintainMapper.updateByPrimaryKeySelective(deviceMaintain);
        return update;
    }

    @Override
    public Map<Object, Object> searchDeviceMaintainByDeviceMaintainId(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceMaintainVO> allDeviceMaintain = deviceMaintainMapper.searchDeviceMaintainByDeviceMaintainId(searchValue);
        PageInfo<DeviceMaintainVO> pageInfo=new PageInfo<>(allDeviceMaintain);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map<Object, Object> searchDeviceMaintainByDeviceFaultId(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceMaintainVO> allDeviceMaintain = deviceMaintainMapper.searchDeviceMaintainByDeviceFaultId(searchValue);
        PageInfo<DeviceMaintainVO> pageInfo=new PageInfo<>(allDeviceMaintain);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    @Override
    public DeviceMaintain findBeanOfDeviceMaintain(String id) {
        DeviceMaintain deviceMaintain = deviceMaintainMapper.selectByPrimaryKey(id);
        return deviceMaintain;
    }

    @Override
    public List<DeviceMaintain> findAllDeviceMaintain() {
        List<DeviceMaintain> allDeviceMaintain = deviceMaintainMapper.findAllDeviceMaintain();
        return allDeviceMaintain;
    }


    public Map<Object, Object> findOnePageOfDeviceMaintain(String page, String rows) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceMaintainVO> deviceMaintainVO = deviceMaintainMapper.findAllDeviceMaintainVO();
        PageInfo<DeviceMaintainVO> pageInfo=new PageInfo<>(deviceMaintainVO);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
