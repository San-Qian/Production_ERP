package com.nosuchteam.mapper;

import com.nosuchteam.bean.ProcessMeasureCheck;

public interface ProcessMeasureCheckMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);
}