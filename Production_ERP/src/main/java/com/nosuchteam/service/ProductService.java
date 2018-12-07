package com.nosuchteam.service;

import com.nosuchteam.bean.Product;
import com.nosuchteam.util.commons.Page;

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:59
 * @Description:
 */
public interface ProductService {
    void save(Product product) throws Exception;

    Page selectByPage(Product product, Integer page, Integer rows);

    void updateSelective(Product product) throws Exception;

    void delete(String[] ids) throws Exception;

    Product selectById(String productId);
}
