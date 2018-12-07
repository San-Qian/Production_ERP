package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Department;
import com.nosuchteam.bean.Employee;
import com.nosuchteam.service.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartMentController {
    @Autowired
    DepartMentService service;

    Map<String,Object> hashMap=new HashMap<>();
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Department> get_data(){
        List<Department> departments = service.selectAll();
        System.out.println(departments);
        return departments;
    }
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Department get(@PathVariable String id){
        Department department = service.selectByPrimaryKey(id);

        return department;
    }
    @RequestMapping("/find")
    public String find(){

        return "personnel_monitoring/department_list";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map selectList(String page, String rows){
        Map map = service.selectOnePage(page, rows);
        return map;
    }

    @RequestMapping(value = "/insert")
    @ResponseBody
    public Map insert(Department department){
        if(service.insert(department)){
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
    @RequestMapping("/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }
    @RequestMapping("/add")
    public String add(){
        return "personnel_monitoring/department_add";
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return null;
    }
    @RequestMapping("/edit")
    public String edit(){
        return "personnel_monitoring/department_edit";
    }

    @RequestMapping(value = "/update_all",method = {RequestMethod.POST})
    @ResponseBody
    public Map update_all(Department department){
        if(service.updateByPrimaryKey(department)){
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
    @RequestMapping(value = "/update_note")
    @ResponseBody
    public Map update_note(Department department){
        if(service.updateByPrimaryKeySelective(department)){
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
        return "personnel_monitoring/department_edit";
    }

    @RequestMapping(value ="/delete_batch",method = {RequestMethod.POST})
    @ResponseBody
    public Map delete_batch(String[] ids){
        if(service.deleteByPrimaryKey(ids)){
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
    @RequestMapping(value ="/search_department_by_departmentName")

    @ResponseBody
    public Map  searchDepartmentByName(String searchValue,String page, String rows){
        Map map = service.searchDepartmentByName( searchValue,  page,  rows);
        return map;
    }
    @RequestMapping(value ="/search_department_by_departmentId")
    @ResponseBody
    public Map  searchDepartmentById(String searchValue,String page, String rows){
        Map map = service.searchDepartmentById( searchValue,  page,  rows);
        return map;
    }

}
