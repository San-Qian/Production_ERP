package com.nosuchteam.mapper;

import com.nosuchteam.bean.DeviceFault;
import com.nosuchteam.bean.vo.DeviceFaultVO;

import java.util.List;

public interface DeviceFaultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);

    List<DeviceFaultVO> searchDeviceFaultByDeviceFaultId(String searchValue);

    List<DeviceFaultVO> searchDeviceFaultByDeviceName(String searchValue);

    List<DeviceFault> findAllDeviceFault();

    List<DeviceFaultVO> findAllDeviceFaultVO();

}