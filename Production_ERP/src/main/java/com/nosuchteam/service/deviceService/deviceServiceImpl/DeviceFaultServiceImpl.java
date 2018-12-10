package com.nosuchteam.service.deviceService.deviceServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.DeviceFault;
import com.nosuchteam.bean.vo.DeviceFaultVO;
import com.nosuchteam.mapper.DeviceFaultMapper;
import com.nosuchteam.service.deviceService.DeviceFaultService;
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
public class DeviceFaultServiceImpl implements DeviceFaultService {
    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    public int insertDeviceFault(DeviceFault deviceFault) {
        int insert = deviceFaultMapper.insert(deviceFault);
        return insert;
    }

    public int deleteDeviceFault(String ids) {
        int delete = deviceFaultMapper.deleteByPrimaryKey(ids);
        return delete;
    }

    public int updateDeviceFault(DeviceFault deviceFault) {
        int update = deviceFaultMapper.updateByPrimaryKeySelective(deviceFault);
        return update;
    }

    @Override
    public Map<Object, Object> searchDeviceFaultByDeviceFaultId(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceFaultVO> allDeviceFault = deviceFaultMapper.searchDeviceFaultByDeviceFaultId(searchValue);
        PageInfo<DeviceFaultVO> pageInfo=new PageInfo<>(allDeviceFault);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map<Object, Object> searchDeviceFaultByDeviceName(String page, String rows, String searchValue) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceFaultVO> allDeviceFault = deviceFaultMapper.searchDeviceFaultByDeviceName(searchValue);
        PageInfo<DeviceFaultVO> pageInfo=new PageInfo<>(allDeviceFault);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    @Override
    public DeviceFault findBeanOfDeviceFault(String id) {
        DeviceFault deviceFault = deviceFaultMapper.selectByPrimaryKey(id);
        return deviceFault;
    }

    @Override
    public List<DeviceFault> findAllDeviceFault() {
        List<DeviceFault> allDeviceFault = deviceFaultMapper.findAllDeviceFault();
        return allDeviceFault;
    }


    public Map<Object, Object> findOnePageOfDeviceFault(String page, String rows) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<DeviceFaultVO> deviceFaultVO = deviceFaultMapper.findAllDeviceFaultVO();
        PageInfo<DeviceFaultVO> pageInfo=new PageInfo<>(deviceFaultVO);
        Map<Object,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
