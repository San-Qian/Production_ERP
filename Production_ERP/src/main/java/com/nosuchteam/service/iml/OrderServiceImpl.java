package com.nosuchteam.service.impl;

import com.nosuchteam.bean.Order;
import com.nosuchteam.mapper.OrderMapper;
import com.nosuchteam.service.OrderService;
import com.nosuchteam.util.commons.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: Evan
 * @Date: 2018/12/5 16:01
 * @Description:
 */
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public void save(Order order) throws Exception {
        int insert = orderMapper.insert(order);
        if(insert != 1){
            throw new Exception();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Page selectByPage(Order order, Integer page, Integer rows) {
        HashMap<String, Object> params = new HashMap<>();

        if(page == null || page < 1){
            page = 1;
        }
        if(rows == null || rows < 10){
            rows = 10;
        }
        params.put("orderId","%" + order.getOrderId() + "%");

        String customName = order.getCustom() == null ? null : order.getCustom().getCustomName();
        params.put("customName","%" + customName + "%");

        String productName = order.getProduct() == null ? null : order.getProduct().getProductName();
        params.put("productName","%" + productName + "%");
        int total = orderMapper.count(params);
        int offset = (page - 1)  * rows;

        params.put("limit",rows);
        params.put("offset",offset);

        return new Page(total,orderMapper.select(params));
    }

    @Override
    public void updateSelective(Order order) throws Exception {
        int i = orderMapper.updateByPrimaryKeySelective(order);
        if(i != 1){
            throw new Exception();
        }
    }

    @Override
    public void delete(String[] ids) throws Exception {
        for (String id : ids) {
            if(orderMapper.deleteByPrimaryKey(id) != 1){
                throw new Exception();
            }
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Order selectById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
