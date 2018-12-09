package com.nosuchteam.controller;

import com.nosuchteam.bean.Employee;
import com.nosuchteam.service.EmployeeService;
import com.nosuchteam.service.iml.EmployeeServiceiml;
import com.nosuchteam.util.commons.Data;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    Map<String,Object> hashMap=new HashMap<>();
    //转发到人员list页面
    @RequestMapping("/find")
    public String selectListAll(HttpSession session){
        ArrayList<String> func = new ArrayList();
        func.add("employee:add");
        func.add("employee:edit");
        func.add("employee:delete");

        session.setAttribute("sysPermissionList", func);
        return "personnel_monitoring/employee_list";
    }
    // 无条件查询
    @RequestMapping("/list")
    @ResponseBody
    public Map selectList(Integer page, Integer rows){
        Map map = service.selectEmployeeByPage(page, rows);
        return map;
    }
    //增加人员
    @RequestMapping(value = "/insert",method = {RequestMethod.POST})
    @ResponseBody
    public Data insert(Employee employee,String employeeParams){
        try {
            if(service.insert(employee)){
                return new Data(200,"OK",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500,"false",null);
        }
        return null;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }
    //转发到增加页面
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
    //更新人员的全部数据
    @RequestMapping(value = "/update_all")
    @ResponseBody
    public Data update_all(Employee employee){
        try {
            if(service.updateByEmpid(employee)){
                return new Data(200,"OK",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500,"false",null);
        }
        return null;
    }
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return null;
    }
    //转发到删除页面
    @RequestMapping("/delete")
    public String delete(){
        return "personnel_monitoring/employee_edit";
    }
    //删除选中项
    @RequestMapping(value ="/delete_batch")
    @ResponseBody
    public Data delete_batch(String[] ids){
        try {
            if(service.deleteByEmpid(ids)){
                return new Data(200,"OK",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500,"false",null);
        }
       return null;
    }
    //按员工名称查询
    @RequestMapping(path ={"/search_employee_by_employeeName",
            "/search_employee_by_employeeId","/search_employee_by_departmentName"})
    @ResponseBody
    public Map  searchEmployeeByName(String searchValue, Integer page, Integer rows, HttpServletRequest request){
        String requestURI = request.getRequestURI();
        Map map=null;
        if(requestURI.endsWith("employeeName")){
             map = service.searchEmployeeByName( searchValue,  page,  rows);
        }else if (requestURI.endsWith("departmentName")){
            map = service.searchEmployeeByDepartmentName( searchValue,  page,  rows);
        }else {
            map = service.searchEmployeeById( searchValue,  page,  rows);
        }

        return map;
    }
//    //按员工编号查询
//    @RequestMapping(value ="/search_employee_by_employeeId")
//    @ResponseBody
//    public Map  searchEmployeeById(String searchValue,Integer page, Integer rows){
//        Map map = service.searchEmployeeById( searchValue,  page,  rows);
//        return map;
//    }
//    //按部门名称查询
//    @RequestMapping(value ="/search_employee_by_departmentName")
//    @ResponseBody
//    public Map  searchEmployeeByDepartmentName(String searchValue,Integer page, Integer rows){
//        Map map = service.searchEmployeeByDepartmentName( searchValue,  page,  rows);
//        return map;
//    }
}
