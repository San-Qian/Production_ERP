package com.nosuchteam.service;

import com.nosuchteam.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    boolean deleteByEmpid(String[] empId) throws Exception;

    boolean insert(Employee record) throws Exception;

    boolean insertSelective(Employee record) throws Exception;

    Employee selectByEmpid(String empId);

    boolean updateByEmpidSelective(Employee record) throws Exception;

    boolean updateByEmpid(Employee record) throws Exception;

    Map selectEmployeeByPage(Integer page, Integer rows);

    Map searchEmployeeByName(String searchValue,Integer page,Integer rows);
    Map searchEmployeeById(String searchValue,Integer page,Integer rows);
    Map searchEmployeeByDepartmentName(String searchValue,Integer page,Integer rows);

}
