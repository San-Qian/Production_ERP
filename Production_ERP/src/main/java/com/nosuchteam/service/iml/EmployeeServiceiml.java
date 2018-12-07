package com.nosuchteam.service.iml;

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
    public boolean deleteByEmpid(String empId) {
        if(mapper.deleteByPrimaryKey(empId)>0){
            return true;
        }
        return false;
    }

    @Override
    public Map insert(Employee record) {
        Map<String,Object> hashMap=new HashMap<>();
        if(mapper.insert(record)>0){
            hashMap.put("status",200);
            hashMap.put("msg","OK");
            hashMap.put("data",null);
        }else {
            hashMap.put("status",200);
            hashMap.put("msg","false");
            hashMap.put("data",null);
        }
        return hashMap;
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
        int i = mapper.selectCount();
        List<EmployeeVO> employees = mapper.selectEmployeesBypage(IntRows, (IntPage-1) * IntRows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",i);
        map.put("rows",employees);
        return map;
    }
}
