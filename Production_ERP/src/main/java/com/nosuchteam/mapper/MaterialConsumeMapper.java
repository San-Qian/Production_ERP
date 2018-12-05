package com.nosuchteam.mapper;

import com.nosuchteam.bean.MaterialConsume;

public interface MaterialConsumeMapper {
    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);
}