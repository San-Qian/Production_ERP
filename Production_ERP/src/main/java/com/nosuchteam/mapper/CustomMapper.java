package com.nosuchteam.mapper;


import com.nosuchteam.bean.Custom;

import java.util.List;
import java.util.Map;

public interface CustomMapper {
    int deleteByPrimaryKey(String customId);

    int insert(Custom custom);

    int insertSelective(Custom custom);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom custom);

    int updateByPrimaryKey(Custom custom);

    int count(Map<String, Object> params);

    List<Custom> select(Map<String, Object> params);
}