package com.nosuchteam.service.impl;

import com.nosuchteam.bean.Product;
import com.nosuchteam.mapper.ProductMapper;
import com.nosuchteam.service.ProductService;
import com.nosuchteam.util.commons.PageInfo;
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
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;


    @Override
    public void save(Product product) throws Exception {
        int insert = productMapper.insert(product);
        if(insert != 1){
            throw new Exception();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public PageInfo selectByPage(Product product, Integer page, Integer rows) {
        HashMap<String, Object> params = new HashMap<>();

        if(page == null || page < 1){
            page = 1;
        }
        if(rows == null || rows < 10){
            rows = 10;
        }
        params.put("productId","%" + product.getProductId() + "%");
        params.put("productName","%" + product.getProductName() + "%");
        params.put("productType","%" + product.getProductType() + "%");
        int total = productMapper.count(params);
        int offset = (page - 1)  * rows;

        params.put("limit",rows);
        params.put("offset",offset);

        return new PageInfo(total,productMapper.select(params));
    }

    @Override
    public void updateSelective(Product product) throws Exception {
        int i = productMapper.updateByPrimaryKeySelective(product);
        if(i != 1){
            throw new Exception();
        }
    }

    @Override
    public void delete(String[] ids) throws Exception {
        for (String id : ids) {
            if(productMapper.deleteByPrimaryKey(id) != 1){
                throw new Exception();
            }
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Product selectById(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }
}
