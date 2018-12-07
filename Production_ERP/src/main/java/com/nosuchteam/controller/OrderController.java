package com.nosuchteam.controller;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.bean.Order;
import com.nosuchteam.bean.Product;
import com.nosuchteam.service.OrderService;
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
            , "/search_order_by_orderCustom","/search_order_by_orderProduct"})
    public Object list(Order order, Integer page, HttpServletRequest request,String getData,
                     String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();

        if (searchValue != null && !searchValue.isEmpty()) {
            switch (requestURI.substring(requestURI.lastIndexOf("order") + "order".length())){
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
        Page pager = orderService.selectByPage(order, page, rows);
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
    public Data add(Order order, HttpServletRequest request) {
        if (request.getRequestURI().endsWith("insert")) {
            try {
                orderService.save(order);
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
    public Data edit(Order order, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("update_all")
                || requestURI.endsWith("update_note")
                && order.getOrderId() != null) {
            try {
                orderService.updateSelective(order);
                return new Data(200, "OK", null);
            }  catch (Exception e) {
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
                orderService.delete(ids);
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
