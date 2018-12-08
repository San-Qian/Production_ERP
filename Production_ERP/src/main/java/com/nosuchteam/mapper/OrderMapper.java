package com.nosuchteam.mapper;

import com.nosuchteam.bean.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int count(Map<String, Object> params);

    List<Order> select(Map<String, Object> params);
}