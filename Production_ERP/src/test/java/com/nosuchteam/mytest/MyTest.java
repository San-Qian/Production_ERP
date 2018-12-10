package com.nosuchteam.mytest;

import com.nosuchteam.bean.DeviceCheck;
import com.nosuchteam.bean.DeviceType;
import com.nosuchteam.mapper.DeviceMapper;
import com.nosuchteam.mapper.DeviceTypeMapper;
import com.nosuchteam.service.deviceService.DeviceCheckService;
import com.nosuchteam.service.deviceService.DeviceListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;

/**
 * @author: SanQian
 * @create: 2018-12-06 20:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
public class MyTest {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    /*@Autowired
    DeviceTypeService deviceTypeService;
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Test
    public void TestDeviceType() {
        Map<Object, Object> onePageOfDeviceType = deviceTypeService.findOnePageOfDeviceType("1", "5");
        System.out.println("onePageOfDeviceType = " + onePageOfDeviceType);
    }
    @Test
    public void TestDeviceTypeMapper() {
        List<DeviceType> allDeviceType = deviceTypeMapper.findAllDeviceType();
        System.out.println(allDeviceType);
    }

    @Test
    public void TestDeviceTypeSeach() {
        Map<Object, Object> map = deviceTypeService.searchDeviceTypeByDeviceTypeName("1", "3", "%设%");
        System.out.println(map);

    }*/
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    DeviceListService deviceListService;
    @Test
    public void TestDeviceListMapper() {
       /* List<DeviceAccountVO> allDeviceList = deviceMapper.findAllDeviceList();*/
        //Map<Object, Object> map = deviceListService.searchDeviceByDeviceId("1", "4", "%0%");
        Map<Object, Object> map = deviceListService.searchDeviceByDeviceTypeName("1", "4", "%冷%");        System.out.println(map);
    }
    @Test
    public void TestDeviceTypeMapper() {
        List<DeviceType> deviceTypeList = deviceTypeMapper.searchDeviceTypeByDeviceTypeId("01");
        System.out.println(deviceTypeList);
    }
    @Autowired
    DeviceCheckService deviceCheckService;
    @Test
    public void TestDeviceCheckService() {
        Map<Object, Object> deviceTypeList = deviceCheckService.findOnePageOfDeviceCheck("1","3");
        System.out.println(deviceTypeList);
       // List<DeviceCheck> allDeviceCheck = deviceCheckService.findAllDeviceCheck();
        /*DeviceCheck beanOfDeviceCheck = deviceCheckService.findBeanOfDeviceCheck("001");
        System.out.println(beanOfDeviceCheck);*/
    }
}
