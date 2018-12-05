package com.nosuchteam.mapper;

import com.nosuchteam.bean.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(String pid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
}