package com.nosuchteam.mapper;

import com.nosuchteam.bean.COrder;

public interface COrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    COrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);
}