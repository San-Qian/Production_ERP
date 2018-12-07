package com.nosuchteam.service;

import com.nosuchteam.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    boolean deleteByEmpid(String empId);

    Map insert(Employee record);

    boolean insertSelective(Employee record);

    Employee selectByEmpid(String empId);

    boolean updateByEmpidSelective(Employee record);

    boolean updateByEmpid(Employee record);

    Map selectEmployeeByPage(String page, String rows);
}
