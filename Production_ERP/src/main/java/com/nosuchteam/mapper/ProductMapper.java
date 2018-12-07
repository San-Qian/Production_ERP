package com.nosuchteam.mapper;

import com.nosuchteam.bean.Product;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int count(Map<String, Object> params);

    List<Product> select(Map<String, Object> params);
}