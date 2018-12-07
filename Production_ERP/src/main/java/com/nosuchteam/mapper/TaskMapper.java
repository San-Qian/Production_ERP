package com.nosuchteam.mapper;

import com.nosuchteam.bean.Task;

import java.util.List;
import java.util.Map;

/**
 * @Author: Evan
 * @Date: 2018/12/5 22:32
 * @Description:
 */
public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task task);

    int insertSelective(Task task);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task task);

    int updateByPrimaryKey(Task task);

    int count(Map<String, Object> params);

    List<Task> select(Map<String, Object> params);


}
