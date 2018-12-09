package com.nosuchteam.mapper;

import com.nosuchteam.bean.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {
    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    List<TechnologyRequirement> select();

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> selectByAmbiguousPrimaryKey(@Param("technologyRequirementId") String technologyRequirementId);

    List<TechnologyRequirement> selectByAmbiguousName(@Param("technologyName") String technologyName);
}