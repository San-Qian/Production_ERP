package com.nosuchteam.mapper;

import com.nosuchteam.bean.Technology;

public interface TechnologyMapper {
    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);
}