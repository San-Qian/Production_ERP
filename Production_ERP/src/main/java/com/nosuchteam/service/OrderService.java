package com.nosuchteam.service;

import com.nosuchteam.bean.Order;
import com.nosuchteam.util.commons.PageInfo;

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:58
 * @Description:
 */
public interface OrderService {
    void save(Order order) throws Exception;

    PageInfo selectByPage(Order order, Integer page, Integer rows);

    void updateSelective(Order order) throws Exception;

    void delete(String[] ids) throws Exception;

    Order selectById(String orderId);
}
