package com.nosuchteam.controller;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.service.CustomService;
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
import java.lang.reflect.Method;
import java.util.ArrayList;

@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    @Qualifier("customService")
    CustomService customService;

    @RequestMapping("/{name}")
    public String forward(@PathVariable String name, HttpSession session) {
        if ("find".equals(name)) {
            ArrayList<String> sysPermissionList = new ArrayList<>();
            sysPermissionList.add("custom:add");
            sysPermissionList.add("custom:edit");
            sysPermissionList.add("custom:delete");
            session.setAttribute("sysPermissionList", sysPermissionList);
            name = "list";
        }
        return "plan_scheduling/custom_" + name;
    }

    @ResponseBody
    @RequestMapping(path = {"/list"
            , "/search_custom_by_customId"
            , "/search_custom_by_customName"})
    public Object list(Custom custom, Integer page, HttpServletRequest request, String getData,
                       String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();
        if (searchValue != null && !searchValue.isEmpty()) {
            String methodName = "set" + (requestURI.endsWith("customId") ? "CustomId" : "CustomName");
            Method method = Custom.class.getMethod(methodName, String.class);
            method.invoke(custom, searchValue);
        }
        PageInfo pager = customService.selectByPage(custom, page, rows);
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
    public Data add(Custom custom, HttpServletRequest request) {
        if (request.getRequestURI().endsWith("insert")) {
            try {
                customService.save(custom);
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
    public Data edit(Custom custom, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("update_all")
                || requestURI.endsWith("update_note")
                && custom.getCustomId() != null) {
            try {
                customService.updateSelective(custom);
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
                customService.delete(ids);
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
