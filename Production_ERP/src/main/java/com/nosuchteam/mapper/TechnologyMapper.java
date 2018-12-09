package com.nosuchteam.mapper;

import com.nosuchteam.bean.Technology;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyMapper {
    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    List<Technology> select();

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    List<Technology> selectByAmbiguousPrimaryKey(@Param("technologyId") String technologyId);

    List<Technology> selectByAmbiguousName(@Param("technologyName") String technologyName);
}