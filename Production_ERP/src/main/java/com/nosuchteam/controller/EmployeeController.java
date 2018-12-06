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

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;
    @RequestMapping("/list")
    @ResponseBody
    public Map selectList(String page, String rows){
        Map map = service.selectEmployeeByPage(page, rows);
        return map;
    }
    @RequestMapping("/inserst")
    @ResponseBody
    public Map insert(Employee employee){
        Map insert = service.insert(employee);
        return insert;
    }
    @RequestMapping("/find")
    public String selectListAll(Model model){

        return "personnel_monitoring/employee_list";
    }
    @RequestMapping("/add_judge")
    public String add_judge(Model model){

        return "personnel_monitoring/employee_add";
    }
    @RequestMapping("/add")
    public String add(Model model){

        return "personnel_monitoring/employee_add";
    }
}
