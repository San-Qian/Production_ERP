package com.nosuchteam.controller;


import com.nosuchteam.bean.Department;
import com.nosuchteam.service.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartMentController {
    @Autowired
    DepartMentService service;

    Map<String,Object> hashMap=new HashMap<>();
    //转发到部门list页面
    @RequestMapping("/find")
    public String find(HttpSession session){
        ArrayList<String> func = new ArrayList();
        func.add("department:add");
        func.add("department:edit");
        func.add("department:delete");

        session.setAttribute("sysPermissionList", func);
        return "personnel_monitoring/department_list";
    }
    //给员工add页面返回部门数据
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Department> get_data(){
        List<Department> departments = service.selectAll();
        System.out.println(departments);
        return departments;
    }
    //给员工list页面的部门返回数据
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Department get(@PathVariable String id){
        Department department = service.selectByPrimaryKey(id);

        return department;
    }

    //无条件分页查询
    @RequestMapping("/list")
    @ResponseBody
    public Map selectList(Integer page, Integer rows){
        Map map = service.selectOnePage(page, rows);
        return map;
    }
    //增加部门
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
    //更新部门所有信息
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
    //只更新部门职责
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
    //删除选中部门
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
    //查找部门名称或者部门编号
    @RequestMapping(path ={"/search_department_by_departmentName","/search_department_by_departmentId"})
    @ResponseBody
    public Map  searchDepartment(String searchValue, Integer page, Integer rows, HttpServletRequest request){
        String requestURI = request.getRequestURI();
        Map map=null;
        if(requestURI.endsWith("Name")){
             map = service.searchDepartmentByName( searchValue,  page,  rows);
        }else {
             map = service.searchDepartmentById( searchValue,  page,  rows);
        }
        return map;
    }
//    //查找部门编号
//    @RequestMapping(value ="/search_department_by_departmentId")
//    @ResponseBody
//    public Map  searchDepartmentById(String searchValue,Integer page, Integer rows){
//        Map map = service.searchDepartmentById( searchValue,  page,  rows);
//        return map;
//    }

}
