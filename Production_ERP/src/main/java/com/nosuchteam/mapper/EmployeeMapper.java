package com.nosuchteam.mapper;

import com.nosuchteam.bean.Employee;
import com.nosuchteam.bean.vo.EmployeeVO;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<EmployeeVO> selectEmployeesBypage(int limit, int offset);

    int selectCount();

    String selectEmpNameByPrimaryKey(String empId);
}