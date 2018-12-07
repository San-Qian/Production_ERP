package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Department;

import java.util.List;
import java.util.Map;

public interface DepartMentService {
    boolean deleteByPrimaryKey(String[] departmentId);

    boolean insert(Department record);

    boolean insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    boolean updateByPrimaryKeySelective(Department record);

    boolean updateByPrimaryKey(Department record);

    List<Department> selectAll();

    Map selectOnePage(String page, String rows);

    Map searchDepartmentByName(String searchValue, String page, String rows);

    Map searchDepartmentById(String searchValue, String page, String rows);
}
