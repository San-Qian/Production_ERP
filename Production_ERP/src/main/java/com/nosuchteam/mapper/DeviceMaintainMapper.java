package com.nosuchteam.mapper;

import com.nosuchteam.bean.DeviceMaintain;
import com.nosuchteam.bean.vo.DeviceMaintainVO;

import java.util.List;

public interface DeviceMaintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);

    List<DeviceMaintainVO> searchDeviceMaintainByDeviceMaintainId(String searchValue);

    List<DeviceMaintainVO> searchDeviceMaintainByDeviceFaultId(String searchValue);

    List<DeviceMaintainVO> findAllDeviceMaintainVO();


    List<DeviceMaintain> findAllDeviceMaintain();
}