package com.nosuchteam.controller;

import com.nosuchteam.bean.Task;
import com.nosuchteam.service.TaskService;
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

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:55
 * @Description:
 */
@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    @Qualifier("taskService")
    TaskService taskService;

    @RequestMapping("/{name}")
    public String forward(@PathVariable String name, HttpSession session) {
        if ("find".equals(name)) {
            ArrayList<String> sysPermissionList = new ArrayList<>();
            sysPermissionList.add("task:add");
            sysPermissionList.add("task:edit");
            sysPermissionList.add("task:delete");
            session.setAttribute("sysPermissionList", sysPermissionList);
            return "plan_scheduling/task_list";
        }
        return "plan_scheduling/task_" + name;
    }

    @ResponseBody
    @RequestMapping(path = {"/list"
            , "/search_task_by_taskId"
            , "/search_task_by_taskWorkId"
            , "/search_task_by_taskManufactureSn"})
    public Object list(Task task, Integer page, HttpServletRequest request,String getData,
                     String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();
        if (searchValue != null && !searchValue.isEmpty()) {
            switch (requestURI.substring(requestURI.lastIndexOf("task") + "task".length())){
                case "Id":
                    task.setTaskId(searchValue);
                    break;
                case "WorkId":
                    task.setWorkId(searchValue);
                    break;
                case "ManufactureSn":
                    task.setManufactureSn(searchValue);
                    break;
            }
        }
        PageInfo pager = taskService.selectByPage(task, page, rows);
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
    public Data add(Task task, HttpServletRequest request) {
        if (request.getRequestURI().endsWith("insert")) {
            try {
                taskService.save(task);
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
    @RequestMapping(path = {"/edit_judge", "/update_all", "/update_note"})
    public Data edit(Task task, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("update_all")
                && task.getTaskId() != null) {
            try {
                taskService.update(task);
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
                taskService.delete(ids);
                return new Data(200, "OK", null);
            }  catch (Exception e) {
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
