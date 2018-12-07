package com.nosuchteam.service.impl;

import com.nosuchteam.bean.Work;
import com.nosuchteam.mapper.WorkMapper;
import com.nosuchteam.service.WorkService;
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
@Service("workService")
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;


    @Override
    public void save(Work work) throws Exception {
        int insert = workMapper.insert(work);
        if(insert != 1){
            throw new Exception();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public PageInfo selectByPage(Work work, Integer page, Integer rows) {
        HashMap<String, Object> params = new HashMap<>();

        if(page == null || page < 1){
            page = 1;
        }
        if(rows == null || rows < 10){
            rows = 10;
        }
        params.put("workId","%" + work.getWorkId() + "%");

        String deviceName = work.getDevice() == null ? null : work.getDevice().getDeviceName();
        params.put("deviceName","%" + deviceName + "%");

        params.put("processId","%" + work.getProcessId() + "%");

        String productName = work.getProduct() == null ? null : work.getProduct().getProductName();
        params.put("productName","%" + productName + "%");
        int total = workMapper.count(params);
        int offset = (page - 1)  * rows;

        params.put("limit",rows);
        params.put("offset",offset);

        return new PageInfo(total,workMapper.select(params));
    }

    @Override
    public void update(Work work) throws Exception {
        int i = workMapper.updateByPrimaryKey(work);
        if(i != 1){
            throw new Exception();
        }
    }

    @Override
    public void delete(String[] ids) throws Exception {
        for (String id : ids) {
            if(workMapper.deleteByPrimaryKey(id) != 1){
                throw new Exception();
            }
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Work selectById(String workId) {
        return workMapper.selectByPrimaryKey(workId);
    }
}
