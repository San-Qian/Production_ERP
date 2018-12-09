package com.nosuchteam.mapper;

import com.nosuchteam.bean.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    List<Process> select();

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> selectByAmbiguousPrimaryKey(@Param("processId") String searchValue);


    List<Process> selectByAmbiguousForeignKey(@Param("technologyPlanId") String searchValue);
}