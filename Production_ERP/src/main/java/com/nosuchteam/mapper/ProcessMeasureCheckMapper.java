package com.nosuchteam.mapper;

import com.nosuchteam.bean.ProcessMeasureCheck;
import com.nosuchteam.bean.vo.FinalCountCheckVo;
import com.nosuchteam.bean.vo.ProcessMeasureCheckVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProcessMeasureCheckMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);

    //回显
    List<ProcessMeasureCheckVo> findAllProcessMeasureCheck();

    //通过p_measure_check_id搜索指定不合格品
    List<ProcessMeasureCheckVo> searchProcessMeasureCheckByCheckId(@Param("checkId") String searchValue);

}