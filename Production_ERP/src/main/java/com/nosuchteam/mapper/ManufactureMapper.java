package com.nosuchteam.mapper;

import com.nosuchteam.bean.Manufacture;

import java.util.List;
import java.util.Map;

/**
 * @Author: Evan
 * @Date: 2018/12/5 22:31
 * @Description:
 */
public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureId);

    int insert(Manufacture manufacture);

    int insertSelective(Manufacture manufacture);

    Manufacture selectByPrimaryKey(String manufactureId);

    int updateByPrimaryKeySelective(Manufacture manufacture);

    int updateByPrimaryKey(Manufacture manufacture);

    int count(Map<String, Object> params);

    List<Manufacture> select(Map<String, Object> params);
}
