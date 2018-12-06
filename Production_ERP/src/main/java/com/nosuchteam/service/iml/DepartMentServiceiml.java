package com.nosuchteam.service.iml;

import com.nosuchteam.bean.Department;
import com.nosuchteam.mapper.DepartmentMapper;
import com.nosuchteam.service.DepartMentService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartMentServiceiml implements DepartMentService {
    @Autowired
    DepartmentMapper mapper;
    @Override
    public boolean deleteByPrimaryKey(String departmentId) {
        return false;
    }

    @Override
    public boolean insert(Department record) {
        return false;
    }

    @Override
    public boolean insertSelective(Department record) {
        return false;
    }

    @Override
    public Department selectByPrimaryKey(String departmentId) {
        return null;
    }

    @Override
    public boolean updateByPrimaryKeySelective(Department record) {
        return false;
    }

    @Override
    public boolean updateByPrimaryKey(Department record) {
        return false;
    }

    @Override
    public List<Department> selectAll() {
        return mapper.selectAll();
    }
}
