package com.nosuchteam.service.impl;

import com.nosuchteam.bean.Task;
import com.nosuchteam.mapper.TaskMapper;
import com.nosuchteam.service.TaskService;
import com.nosuchteam.util.commons.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @Author: Evan
 * @Date: 2018/12/5 16:30
 * @Description:
 */
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;


    @Override
    public void save(Task task) throws Exception {
        int insert = taskMapper.insert(task);
        if(insert != 1){
            throw new Exception();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public PageInfo selectByPage(Task task, Integer page, Integer rows) {
        HashMap<String, Object> params = new HashMap<>();

        if(page == null || page < 1){
            page = 1;
        }
        if(rows == null || rows < 10){
            rows = 10;
        }
        params.put("taskId","%" + task.getTaskId() + "%");
        params.put("manufactureSn","%" + task.getManufactureSn() + "%");
        params.put("workId","%" + task.getWorkId() + "%");

        int total = taskMapper.count(params);
        int offset = (page - 1)  * rows;

        params.put("limit",rows);
        params.put("offset",offset);

        return new PageInfo(total,taskMapper.select(params));
    }

    @Override
    public void update(Task task) throws Exception {
        int i = taskMapper.updateByPrimaryKey(task);
        if(i != 1){
            throw new Exception();
        }
    }

    @Override
    public void delete(String[] ids) throws Exception {
        for (String id : ids) {
            if(taskMapper.deleteByPrimaryKey(id) != 1){
                throw new Exception();
            }
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Task selectById(String taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }
}
