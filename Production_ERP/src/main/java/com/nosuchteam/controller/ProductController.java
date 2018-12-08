package com.nosuchteam.controller;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.bean.Product;
import com.nosuchteam.service.ProductService;
import com.nosuchteam.util.commons.Data;
import com.nosuchteam.util.commons.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:55
 * @Description:
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("productService")
    ProductService productService;

    @ResponseBody
    @RequestMapping(path = {"/list"
            , "/search_product_by_productId"
            , "/search_product_by_productType"
            , "/search_product_by_productName"})
    public Object list(Product product, Integer page, HttpServletRequest request, String getData,
                       String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();
        if (searchValue != null && !searchValue.isEmpty()) {
            switch (requestURI.substring(requestURI.lastIndexOf("product") + "product".length())) {
                case "Id":
                    product.setProductId(searchValue);
                    break;
                case "Type":
                    product.setProductType(searchValue);
                    break;
                case "Name":
                    product.setProductName(searchValue);
                    break;
            }
        }
        PageInfo pager = productService.selectByPage(product, page, rows);
        getData = getData == null ? "" : getData;
        switch (getData) {
            case "List":
                return pager.getRows();
            case "Object":
                return pager.getRows().get(0);
            default:
                return pager;
        }
    }

    @ResponseBody
    @RequestMapping({"/insert"})
    public Data add(@Valid Product product, BindingResult bindingResult, HttpServletRequest request) {
        try {
            if (bindingResult.hasErrors()) {
                return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
            }
            productService.save(product);
            return new Data(200, "OK", null);
        } catch (DuplicateKeyException de) {
            de.printStackTrace();
            return new Data(500, "该编号已存在", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500, "操作失败", null);
        }
    }

    @ResponseBody
    @RequestMapping(path = {"/update_all", "/update_note"})
    public Data edit(@Valid Product product, BindingResult bindingResult, HttpServletRequest request) {
        try {
            if(bindingResult.hasErrors()){
                if(bindingResult.hasFieldErrors("productId") || request.getRequestURI().endsWith("/update_all")){
                    return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
                }
            }
            productService.updateSelective(product);
            return new Data(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500, "操作失败", null);
        }

    }

    @ResponseBody
    @RequestMapping({"/delete_judge", "/delete_batch"})
    public Data delete(String[] ids, HttpServletRequest request) {

        try {
            productService.delete(ids);
            return new Data(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500, "操作失败", null);
        }
    }
    @ResponseBody
    @RequestMapping({"/check"})
    public Object checkStatus(String productId){
        try{
            Product product = productService.selectById(productId);
            if(product.getStatus() == 2){
                return new Data(400, "警告！产品“" + product.getProductName() + "”已经停产",null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
