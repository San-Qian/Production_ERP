package com.nosuchteam.service.impl;

import com.nosuchteam.bean.Manufacture;
import com.nosuchteam.mapper.ManufactureMapper;
import com.nosuchteam.service.ManufactureService;
import com.nosuchteam.util.commons.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @Author: Evan
 * @Date: 2018/12/5 16:29
 * @Description:
 */
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("manufactureService")
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    ManufactureMapper manufactureMapper;


    @Override
    public void save(Manufacture manufacture) throws Exception {
        int insert = manufactureMapper.insert(manufacture);
        if(insert != 1){
            throw new Exception();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Page selectByPage(Manufacture manufacture, Integer page, Integer rows) {
        HashMap<String, Object> params = new HashMap<>();

        if(page == null || page < 1){
            page = 1;
        }
        if(rows == null || rows < 10){
            rows = 10;
        }
        params.put("manufactureSn","%" + manufacture.getManufactureSn() + "%");

        params.put("technologyId","%" + manufacture.getTechnologyId() + "%");

        String orderId = manufacture.getcOrder() == null ? null : manufacture.getcOrder().getOrderId();
        params.put("orderId","%" + orderId + "%");

        int total = manufactureMapper.count(params);
        int offset = (page - 1)  * rows;

        params.put("limit",rows);
        params.put("offset",offset);

        return new Page(total,manufactureMapper.select(params));
    }

    @Override
    public void update(Manufacture manufacture) throws Exception {
        int i = manufactureMapper.updateByPrimaryKey(manufacture);
        if(i != 1){
            throw new Exception();
        }
    }

    @Override
    public void delete(String[] ids) throws Exception {
        for (String id : ids) {
            if(manufactureMapper.deleteByPrimaryKey(id) != 1){
                throw new Exception();
            }
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Manufacture selectById(String manufactureId) {
        return manufactureMapper.selectByPrimaryKey(manufactureId);
    }
}
