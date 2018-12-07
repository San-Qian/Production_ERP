package com.nosuchteam.controller;

import com.nosuchteam.bean.Product;
import com.nosuchteam.service.ProductService;
import com.nosuchteam.util.commons.Data;
import com.nosuchteam.util.commons.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/{name}")
    public String forward(@PathVariable String name, HttpSession session) {
        if ("find".equals(name)) {
            ArrayList<String> sysPermissionList = new ArrayList<>();
            sysPermissionList.add("product:add");
            sysPermissionList.add("product:edit");
            sysPermissionList.add("product:delete");
            session.setAttribute("sysPermissionList", sysPermissionList);
            return "plan_scheduling/product_list";
        }
        return "plan_scheduling/product_" + name;
    }

    @ResponseBody
    @RequestMapping(path = {"/list"
            , "/search_product_by_productId"
            , "/search_product_by_productType"
            , "/search_product_by_productName"})
    public Object list(Product product, Integer page, HttpServletRequest request,String getData,
                     String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();
        if (searchValue != null && !searchValue.isEmpty()) {
           switch (requestURI.substring(requestURI.lastIndexOf("product") + "product".length())){
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
        Page pager = productService.selectByPage(product, page, rows);
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
    @RequestMapping({"/add_judge", "/insert"})
    public Data add(Product product, HttpServletRequest request) {
        if (request.getRequestURI().endsWith("insert")) {
            try {
                productService.save(product);
                return new Data(200, "OK", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Data(500, "操作失败", null);
            }
        }
        //....
        return check(request.getSession());
    }

    @ResponseBody
    @RequestMapping(path = {"/edit_judge", "/update_all", "/update_note"})
    public Data edit(Product product, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("update_all")
                || requestURI.endsWith("update_note")
                && product.getProductId() != null) {
            try {
                productService.updateSelective(product);
                return new Data(200, "OK", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Data(500, "操作失败", null);
            }
        }
        //....
        return check(request.getSession());
    }

    @ResponseBody
    @RequestMapping({"/delete", "/delete_judge", "/delete_batch"})
    public Data delete(String[] ids, HttpServletRequest request) {
        if (request.getRequestURI().endsWith("delete_batch") && ids != null && ids.length != 0) {
            try {
                productService.delete(ids);
                return new Data(200, "OK", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Data(500, "操作失败", null);
            }
        }
        //....
        return check(request.getSession());
    }

    private Data check(HttpSession session){
        /*if (session == null || session.getAttribute("user") == null){
            return new Data(500, "请先登录", null);
        }*/
        return null;
    }
}
