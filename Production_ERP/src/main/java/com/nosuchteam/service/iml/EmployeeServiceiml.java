package com.nosuchteam.service.iml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Employee;
import com.nosuchteam.bean.vo.EmployeeVO;
import com.nosuchteam.mapper.EmployeeMapper;
import com.nosuchteam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("EmployeeService")
public class EmployeeServiceiml implements EmployeeService {
    @Autowired
    EmployeeMapper mapper;

    Map<String,Object> map=new HashMap<>();

    @Override
    public boolean deleteByEmpid(String[] ids) throws Exception {
        for (int i = 0; i <ids.length ; i++) {
            if(mapper.deleteByPrimaryKey(ids[i])!=1){
                throw new Exception("删除错误");
            }
        }
        return true;
    }

    @Override
    public boolean insert(Employee record) throws Exception {
        if(mapper.insert(record)!=1){
            throw new Exception("增加错误");
        }
        return true;
    }

    @Override
    public boolean insertSelective(Employee record) throws Exception {
        if(mapper.insertSelective(record)!=1){
            throw new Exception("选择增加错误");
        }
        return true;
    }

    @Override
    public EmployeeVO selectByEmpid(String empId) {
        return mapper.selectByPrimaryKey(empId);
    }

    @Override
    public boolean updateByEmpidSelective(Employee record) throws Exception {
        if(mapper.updateByPrimaryKeySelective(record)!=1){
            throw new Exception("选择更新错误");
        }
        return true;
    }

    @Override
    public boolean updateByEmpid(Employee record) throws Exception {
        if(mapper.updateByPrimaryKey(record)!=1){
            throw new Exception("更新错误");
        }
        return true;
    }

    @Override
    public Map<String,Object> selectEmployeeByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<EmployeeVO> employees = mapper.selectAllEmployee();
        PageInfo<EmployeeVO> pageInfo=new PageInfo<>(employees);

        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map searchEmployeeByName(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        searchValue="%"+searchValue+"%";
        List<EmployeeVO> employees=mapper.searchEmployeeByName(searchValue);
        PageInfo<EmployeeVO> pageInfo=new PageInfo<>(employees);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public Map searchEmployeeById(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        searchValue = "%" + searchValue + "%";
        List<EmployeeVO> employees = mapper.searchEmployeeById(searchValue);
        PageInfo<EmployeeVO> pageInfo = new PageInfo<>(employees);
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @Override
    public Map searchEmployeeByDepartmentName(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        searchValue="%"+searchValue+"%";
        List<EmployeeVO> employees=mapper.searchEmployeeByDepartmentName(searchValue);
        PageInfo<EmployeeVO> pageInfo=new PageInfo<>(employees);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    public List<EmployeeVO> selectAll() {
        return mapper.selectAllEmployee();
    }
}
