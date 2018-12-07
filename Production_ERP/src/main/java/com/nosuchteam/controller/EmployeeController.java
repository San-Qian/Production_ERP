package com.nosuchteam.controller;

import com.nosuchteam.bean.Employee;
import com.nosuchteam.service.EmployeeService;
import com.nosuchteam.service.iml.EmployeeServiceiml;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    Map<String,Object> hashMap=new HashMap<>();
    @RequestMapping("/list")
    @ResponseBody
    public Map selectList(String page, String rows){
        Map map = service.selectEmployeeByPage(page, rows);
        return map;
    }

    @RequestMapping(value = "/insert",method = {RequestMethod.POST})
    @ResponseBody
    public Map insert(Employee employee,String employeeParams){
        if(service.insert(employee)){
            hashMap.put("status",200);
            hashMap.put("msg","OK");
            hashMap.put("data",null);
        }else {
            hashMap.put("status",500);
            hashMap.put("msg","false");
            hashMap.put("data",null);
        }
        return hashMap;
    }
    @RequestMapping("/find")
    public String selectListAll(){

        return "personnel_monitoring/employee_list";
    }
    @RequestMapping("/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }
    @RequestMapping("/add")
    public String add(){
        return "personnel_monitoring/employee_add";
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return null;
    }
    @RequestMapping("/edit")
    public String edit(){
        return "personnel_monitoring/employee_edit";
    }

    @RequestMapping(value = "/update_all",method = {RequestMethod.POST})
    @ResponseBody
    public Map update_all(Employee employee){
         if(service.updateByEmpid(employee)){
             hashMap.put("status",200);
             hashMap.put("msg","OK");
             hashMap.put("data",null);
         }else {
             hashMap.put("status",500);
             hashMap.put("msg","false");
             hashMap.put("data",null);
         }
         return hashMap;
    }
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return null;
    }
    @RequestMapping("/delete")
    public String delete(){
        return "personnel_monitoring/employee_edit";
    }

    @RequestMapping(value ="/delete_batch",method = {RequestMethod.POST})
    @ResponseBody
    public Map delete_batch(String[] ids){
        if(service.deleteByEmpid(ids)){
            hashMap.put("status",200);
            hashMap.put("msg","OK");
            hashMap.put("data",null);
        }else {
            hashMap.put("status",500);
            hashMap.put("msg","false");
            hashMap.put("data",null);
        }
        return hashMap;
    }
    @RequestMapping(value ="/search_employee_by_employeeName")
    @ResponseBody
    public Map  searchEmployeeByName(String searchValue,String page, String rows){
        Map map = service.searchEmployeeByName( searchValue,  page,  rows);
        return map;
    }
    @RequestMapping(value ="/search_employee_by_employeeId")
    @ResponseBody
    public Map  searchEmployeeById(String searchValue,String page, String rows){
        Map map = service.searchEmployeeById( searchValue,  page,  rows);
        return map;
    }
    @RequestMapping(value ="/search_employee_by_departmentName")
    @ResponseBody
    public Map  searchEmployeeByDepartmentName(String searchValue,String page, String rows){
        Map map = service.searchEmployeeByDepartmentName( searchValue,  page,  rows);
        return map;
    }
}
