package com.nosuchteam.service.impl;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.mapper.CustomMapper;
import com.nosuchteam.service.CustomService;
import com.nosuchteam.util.commons.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Evan
 * @Date: 2018/12/5 16:29
 * @Description:
 */
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("customService")
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;


    @Override
    public void save(Custom custom) throws Exception {
        int insert = customMapper.insert(custom);
        if(insert != 1){
            throw new Exception();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Page selectByPage(Custom custom,Integer page, Integer rows) {
        HashMap<String, Object> params = new HashMap<>();

        if(page == null || page < 1){
            page = 1;
        }
        if(rows == null || rows < 10){
            rows = 10;
        }
        params.put("customId","%" + custom.getCustomId() + "%");

        params.put("customName","%" + custom.getCustomName() + "%");

        int total = customMapper.count(params);
        int offset = (page - 1)  * rows;

        params.put("limit",rows);
        params.put("offset",offset);

        return new Page(total,customMapper.select(params));
    }

    @Override
    public void updateSelective(Custom custom) throws Exception {
        int i = customMapper.updateByPrimaryKeySelective(custom);
        if(i != 1){
            throw new Exception();
        }
    }

    @Override
    public void delete(String[] ids) throws Exception {
        for (String id : ids) {
            if(customMapper.deleteByPrimaryKey(id) != 1){
                throw new Exception();
            }
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Custom selectById(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }
}
