package com.nosuchteam.controller;

import com.nosuchteam.bean.Device;
import com.nosuchteam.bean.Product;
import com.nosuchteam.bean.Work;
import com.nosuchteam.service.WorkService;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:56
 * @Description:
 */
@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    @Qualifier("workService")
    WorkService workService;

    @RequestMapping("/{name}")
    public String forward(@PathVariable String name, HttpSession session) {
        if ("find".equals(name)) {
            ArrayList<String> sysPermissionList = new ArrayList<>();
            sysPermissionList.add("work:add");
            sysPermissionList.add("work:edit");
            sysPermissionList.add("work:delete");
            session.setAttribute("sysPermissionList", sysPermissionList);
            return "plan_scheduling/work_list";
        }
        return "plan_scheduling/work_" + name;
    }

    @ResponseBody
    @RequestMapping(path = {"/list", "/search_work_by_workId"
            , "/search_work_by_workProduct"
            ,"search_work_by_workProcess"
            ,"search_work_by_workDevice"})
    public Object list(Work work, Integer page, HttpServletRequest request,String getData,
                     String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();
        if (searchValue != null && !searchValue.isEmpty()) {
            switch (requestURI.substring(requestURI.lastIndexOf("work") + "work".length())){
                case "Id":
                    work.setWorkId(searchValue);
                    break;
                case "Product":
                    Product product = new Product();
                    product.setProductName(searchValue);
                    work.setProduct(product);
                    break;
                case "Process":
                    work.setProcessId(searchValue);
                    break;
                case "Device":
                    Device device = new Device();
                    device.setDeviceName(searchValue);
                    work.setDevice(device);
                    break;
            }
        }
        Page pager = workService.selectByPage(work, page, rows);
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
    public Data add(Work work, HttpServletRequest request) {
        if (request.getRequestURI().endsWith("insert")) {
            try {
                workService.save(work);
                return new Data(200, "OK", null);
            }catch (Exception e) {
                e.printStackTrace();
                return new Data(500, "操作失败", null);
            }
        }
        //....
        return check(request.getSession());
    }

    @ResponseBody
    @RequestMapping(path = {"/edit_judge", "/update_all", "/update_note"})
    public Data edit(Work work, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("update_all")
                && work.getWorkId() != null) {
            try {
                workService.update(work);
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
                workService.delete(ids);
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
