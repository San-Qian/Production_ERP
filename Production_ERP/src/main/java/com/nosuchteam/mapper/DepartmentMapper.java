package com.nosuchteam.mapper;

import com.nosuchteam.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectAllDepartMent();

    List<Department> searchDepartmentByName(String searchValue);

    List<Department> searchDepartmentById(String searchValue);
}