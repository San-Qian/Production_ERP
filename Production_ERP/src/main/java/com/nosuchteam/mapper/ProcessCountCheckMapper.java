package com.nosuchteam.mapper;

import com.nosuchteam.bean.ProcessCountCheck;
import com.nosuchteam.bean.vo.ProcessCountCheckVo;
import com.nosuchteam.bean.vo.ProcessMeasureCheckVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProcessCountCheckMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record) throws Exception;

    int insertSelective(ProcessCountCheck record);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);

    //回显
    List<ProcessCountCheckVo> findAllProcessCountCheck();

    //通过p_count_check_id搜索指定不合格品
    List<ProcessCountCheckVo> searchProcessCountCheckByCheckId(@Param("checkId") String searchValue);
}