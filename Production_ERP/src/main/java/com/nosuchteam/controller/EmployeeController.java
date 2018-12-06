package com.nosuchteam.controller;

import com.nosuchteam.bean.Employee;
import com.nosuchteam.service.EmployeeService;
import com.nosuchteam.service.iml.EmployeeServiceiml;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @RequestMapping("/list")
    @ResponseBody
    public Map selectList(Model model, String page, String rows){
        Map map = service.selectEmployeeByPage(page, rows);
        return map;
    }
    @RequestMapping("/find")
    public String selectListAll(Model model){

        return "personnel_monitoring/employee_list";
    }

}
