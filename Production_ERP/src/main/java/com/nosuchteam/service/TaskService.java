package com.nosuchteam.service;

import com.nosuchteam.bean.Task;
import com.nosuchteam.util.commons.PageInfo;

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:59
 * @Description:
 */
public interface TaskService {
    void save(Task task) throws Exception;

    PageInfo selectByPage(Task task, Integer page, Integer rows);

    void update(Task task) throws Exception;

    void delete(String[] ids) throws Exception;

    Task selectById(String taskId);
}
