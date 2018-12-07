package com.nosuchteam.service.iml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Employee;
import com.nosuchteam.bean.VO.EmployeeVO;
import com.nosuchteam.mapper.EmployeeMapper;
import com.nosuchteam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("EmployeeService")
public class EmployeeServiceiml implements EmployeeService {
    @Autowired
    EmployeeMapper mapper;



    @Override
    public boolean deleteByEmpid(String[] ids) {
        for (int i = 0; i <ids.length ; i++) {
            if(mapper.deleteByPrimaryKey(ids[i])!=1){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean insert(Employee record) {
        if(mapper.insert(record)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertSelective(Employee record) {
        if(mapper.insertSelective(record)>0){
            return true;
        }
        return false;
    }

    @Override
    public Employee selectByEmpid(String empId) {
        return null;
    }

    @Override
    public boolean updateByEmpidSelective(Employee record) {
        if(mapper.updateByPrimaryKeySelective(record)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByEmpid(Employee record) {
        if(mapper.updateByPrimaryKey(record)>0){
            return true;
        }
        return false;
    }

    @Override
    public Map<String,Object> selectEmployeeByPage(String page, String rows) {
        int IntPage = Integer.parseInt(page);
        int IntRows = Integer.parseInt(rows);
        PageHelper.startPage(IntPage,IntRows);
        List<EmployeeVO> employees = mapper.selectAllEmployee();
        PageInfo<EmployeeVO> pageInfo=new PageInfo<>(employees);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map searchEmployeeByName(String searchValue, String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        searchValue="%"+searchValue+"%";
        List<EmployeeVO> employees=mapper.searchEmployeeByName(searchValue);
        PageInfo<EmployeeVO> pageInfo=new PageInfo<>(employees);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map searchEmployeeById(String searchValue, String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        searchValue = "%" + searchValue + "%";
        List<EmployeeVO> employees = mapper.searchEmployeeById(searchValue);
        PageInfo<EmployeeVO> pageInfo = new PageInfo<>(employees);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @Override
    public Map searchEmployeeByDepartmentName(String searchValue, String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        searchValue="%"+searchValue+"%";
        List<EmployeeVO> employees=mapper.searchEmployeeByDepartmentName(searchValue);
        PageInfo<EmployeeVO> pageInfo=new PageInfo<>(employees);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
