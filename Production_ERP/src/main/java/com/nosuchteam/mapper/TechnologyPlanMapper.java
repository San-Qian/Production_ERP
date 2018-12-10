package com.nosuchteam.mapper;

import com.nosuchteam.bean.TechnologyPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyPlanMapper {
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    List<TechnologyPlan> select();

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlan> selectByAmbiguousPrimaryKey(@Param("technologyPlanId") String searchValue);

    List<TechnologyPlan> selectByAmbiguousName(@Param("technologyName") String searchValue);
}