package com.nosuchteam.mapper;

import com.nosuchteam.bean.Employee;
import com.nosuchteam.bean.vo.EmployeeVO;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    EmployeeVO selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<EmployeeVO> selectEmployeesBypage(int limit, int offset);

    int selectCount();

    List<EmployeeVO> selectAllEmployee();

    List<EmployeeVO>  searchEmployeeByName(String searchValue);
    List<EmployeeVO>  searchEmployeeById(String searchValue);
    List<EmployeeVO>  searchEmployeeByDepartmentName(String searchValue);


}