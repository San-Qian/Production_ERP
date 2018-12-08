package com.nosuchteam.mapper;

import com.nosuchteam.bean.Work;

import java.util.List;
import java.util.Map;

/**
 * @Author: Evan
 * @Date: 2018/12/5 22:32
 * @Description:
 */
public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work work);

    int insertSelective(Work work);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work work);

    int updateByPrimaryKey(Work work);

    int count(Map<String, Object> params);

    List<Work> select(Map<String, Object> params);
}
