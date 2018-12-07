package com.nosuchteam.controller;

import com.nosuchteam.bean.Department;
import com.nosuchteam.service.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartMentController {
    @Autowired
    DepartMentService departMentService;
    @RequestMapping("/get_data")
    @ResponseBody
    public String get_data(){
        List<Department> departments = departMentService.selectAll();
        return departments.toString();
    }
}
