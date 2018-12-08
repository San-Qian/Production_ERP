package com.nosuchteam.controller;

import com.nosuchteam.bean.Task;
import com.nosuchteam.service.TaskService;
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
    public Object list(Task task, Integer page, HttpServletRequest request, String getData,
                       String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();
        if (searchValue != null && !searchValue.isEmpty()) {
            switch (requestURI.substring(requestURI.lastIndexOf("task") + "task".length())) {
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
    @RequestMapping({"/insert"})
    public Data add(@Valid Task task, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
            }
            taskService.save(task);
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
    public Data edit(@Valid Task task,BindingResult bindingResult, HttpServletRequest request) {
        try {
            if(bindingResult.hasErrors()){
                if(bindingResult.hasFieldErrors("taskId") || request.getRequestURI().endsWith("/update_all")){
                    return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
                }
            }
            taskService.update(task);
            return new Data(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500, "操作失败", null);
        }
    }

    @ResponseBody
    @RequestMapping({"/delete", "/delete_batch"})
    public Data delete(String[] ids) {
        try {
            taskService.delete(ids);
            return new Data(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500, "操作失败", null);
        }
    }
}
