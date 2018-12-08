package com.nosuchteam.controller;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.bean.Order;
import com.nosuchteam.bean.Product;
import com.nosuchteam.service.CustomService;
import com.nosuchteam.service.OrderService;
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
 * @Date: 2018/12/5 14:57
 * @Description:
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    @Qualifier("orderService")
    OrderService orderService;
    @Autowired
    @Qualifier("customService")
    CustomService customService;

    @RequestMapping("/{name}")
    public String forward(@PathVariable String name, HttpSession session) {
        if ("find".equals(name)) {
            ArrayList<String> sysPermissionList = new ArrayList<>();
            sysPermissionList.add("order:add");
            sysPermissionList.add("order:edit");
            sysPermissionList.add("order:delete");
            session.setAttribute("sysPermissionList", sysPermissionList);
            return "plan_scheduling/order_list";
        }
        return "plan_scheduling/order_" + name;
    }

    @ResponseBody
    @RequestMapping(path = {"/list", "/search_order_by_orderId"
            , "/search_order_by_orderCustom", "/search_order_by_orderProduct"})
    public Object list(Order order, Integer page, HttpServletRequest request, String getData,
                       String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();

        if (searchValue != null && !searchValue.isEmpty()) {
            switch (requestURI.substring(requestURI.lastIndexOf("order") + "order".length())) {
                case "Id":
                    order.setOrderId(searchValue);
                    break;
                case "Custom":
                    Custom custom = new Custom();
                    custom.setCustomName(searchValue);
                    order.setCustom(custom);
                    break;
                case "Product":
                    Product product = new Product();
                    product.setProductName(searchValue);
                    order.setProduct(product);
                    break;
            }
        }
        PageInfo pager = orderService.selectByPage(order, page, rows);
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
    public Data add(@Valid Order order, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
            }
            orderService.save(order);
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
    public Data edit(@Valid Order order, BindingResult bindingResult, HttpServletRequest request) {
        try {
            if(bindingResult.hasErrors()){
                if(bindingResult.hasFieldErrors("orderId") || request.getRequestURI().endsWith("/update_all")){
                    return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
                }
            }
            orderService.updateSelective(order);
            return new Data(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500, "操作失败", null);
        }

    }

    @ResponseBody
    @RequestMapping({"/delete", "/delete_batch"})
    public Data delete(String[] ids, HttpServletRequest request) {

        try {
            orderService.delete(ids);
            return new Data(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500, "操作失败", null);
        }

    }

}
