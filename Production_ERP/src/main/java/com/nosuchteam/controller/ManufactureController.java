package com.nosuchteam.controller;

import com.nosuchteam.bean.Manufacture;
import com.nosuchteam.bean.Order;
import com.nosuchteam.bean.Technology;
import com.nosuchteam.service.ManufactureService;
import com.nosuchteam.util.commons.Data;
import com.nosuchteam.util.commons.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    @Autowired
    @Qualifier("manufactureService")
    ManufactureService manufactureService;

    @RequestMapping("/{name}")
    public String forward(@PathVariable String name, HttpSession session) {
        if ("find".equals(name)) {
            ArrayList<String> sysPermissionList = new ArrayList<>();
            sysPermissionList.add("manufacture:add");
            sysPermissionList.add("manufacture:edit");
            sysPermissionList.add("manufacture:delete");
            session.setAttribute("sysPermissionList", sysPermissionList);
            return "plan_scheduling/manufacture_list";
        }
        return "plan_scheduling/manufacture_" + name;
    }

    @ResponseBody
    @RequestMapping(path = {"/list"
            , "/search_manufacture_by_manufactureSn"
            , "/search_manufacture_by_manufactureOrderId"
            , "/search_manufacture_by_manufactureTechnologyName"})
    public Object list(Manufacture manufacture, Integer page, HttpServletRequest request, String getData,
                       String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();
        if (searchValue != null && !searchValue.isEmpty()) {
            switch (requestURI.substring(requestURI.lastIndexOf("manufacture") + "manufacture".length())) {
                case "Sn":
                    manufacture.setManufactureSn(searchValue);
                    break;
                case "OrderId":
                    Order order = new Order();
                    order.setOrderId(searchValue);
                    manufacture.setcOrder(order);
                    break;
                case "TechnologyName":
                    Technology technology = new Technology();
                    technology.setTechnologyName(searchValue);
                    manufacture.setTechnology(technology);
                    break;
            }
        }
        PageInfo pager = manufactureService.selectByPage(manufacture, page, rows);
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
    public Data add(Manufacture manufacture, HttpServletRequest request) {
        if (request.getRequestURI().endsWith("insert")) {
            try {
                manufactureService.save(manufacture);
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
    public Data edit(Manufacture manufacture, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("update_all")
                || requestURI.endsWith("update_note")
                && manufacture.getManufactureSn() != null) {
            try {
                manufactureService.update(manufacture);
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
                manufactureService.delete(ids);
                return new Data(200, "OK", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Data(500, "操作失败", null);
            }
        }
        //....
        return check(request.getSession());
    }

    private Data check(HttpSession session) {
        /*if (session == null || session.getAttribute("user") == null){
            return new Data(500, "请先登录", null);
        }*/
        return null;
    }

}
