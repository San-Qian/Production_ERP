package com.nosuchteam.service;

import com.nosuchteam.bean.Department;

import java.util.List;

public interface DepartMentService {
    boolean deleteByPrimaryKey(String departmentId);

    boolean insert(Department record);

    boolean insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    boolean updateByPrimaryKeySelective(Department record);

    boolean updateByPrimaryKey(Department record);

    List<Department> selectAll();
}
