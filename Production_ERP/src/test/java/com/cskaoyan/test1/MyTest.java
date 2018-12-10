package com.cskaoyan.test1;

import com.nosuchteam.bean.Employee;
import com.nosuchteam.mapper.EmployeeMapper;
import com.nosuchteam.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
public class MyTest {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeService service;
    @Test
    public void test1() throws Exception {
        Employee employee=new Employee();
        employee.setEmpName("阿斯达");
        employee.setEmpId("006");
        boolean b = service.insertSelective(employee);
        Assert.assertTrue(b);
    }
}
