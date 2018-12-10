package com.nosuchteam.service.iml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Department;
import com.nosuchteam.bean.vo.EmployeeVO;
import com.nosuchteam.mapper.DepartmentMapper;
import com.nosuchteam.service.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("departmentService")
public class DepartMentServiceiml implements DepartMentService {
    @Autowired
    DepartmentMapper mapper;
    @Override
    public boolean deleteByPrimaryKey(String[] ids)
    {
        for (int i = 0; i <ids.length ; i++) {
            if(mapper.deleteByPrimaryKey(ids[i])!=1){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean insert(Department record)
    {
        int insert = mapper.insert(record);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertSelective(Department record) {
        return false;
    }

    @Override
    public Department selectByPrimaryKey(String departmentId) {

        return mapper.selectByPrimaryKey(departmentId);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Department record) {

        int insert = mapper.updateByPrimaryKeySelective(record);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByPrimaryKey(Department record) {
        int insert = mapper.updateByPrimaryKey(record);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Department> selectAll() {

        return mapper.selectAllDepartMent();
    }

    @Override
    public Map<String,Object> selectOnePage(String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        List<Department> departments = mapper.selectAllDepartMent();
        PageInfo<Department> pageInfo=new PageInfo<>(departments);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getSize());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map searchDepartmentByName(String searchValue, String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        searchValue="%"+searchValue+"%";
        List<Department> employees=mapper.searchDepartmentByName(searchValue);
        PageInfo<Department> pageInfo=new PageInfo<>(employees);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map searchDepartmentById(String searchValue, String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        searchValue="%"+searchValue+"%";
        List<Department> employees=mapper.searchDepartmentById(searchValue);
        PageInfo<Department> pageInfo=new PageInfo<>(employees);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
