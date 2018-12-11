package com.nosuchteam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.ProcessCountCheck;
import com.nosuchteam.bean.ProcessCountCheck;
import com.nosuchteam.bean.vo.ProcessCountCheckVo;
import com.nosuchteam.mapper.ProcessCountCheckMapper;
import com.nosuchteam.service.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2018/12/8-11:01
 */
@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {

    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    //回显工序计数
    public PageInfo<ProcessCountCheckVo> findAllProcessCountCheckByPage(int page, int rows) {
        PageHelper.startPage(page, rows);

        List<ProcessCountCheckVo> allProcessCountCheck = processCountCheckMapper.findAllProcessCountCheck();

        PageInfo<ProcessCountCheckVo> objectPageInfo = new PageInfo(allProcessCountCheck);

        return objectPageInfo;
    }


    //新增一个工序计数
    public Map addProcessCountCheck(ProcessCountCheck processCountCheck) {

        HashMap hashMap = new HashMap();

        try {
            processCountCheckMapper.insert(processCountCheck);

            hashMap.put("data", null);
            hashMap.put("msg", "OK");
            hashMap.put("status", 200);

        } catch (
                DuplicateKeyException e) {
            hashMap.put("msg", "编号已存在");
            hashMap.put("status", 0);
        } catch (Exception e) {
            hashMap.put("msg", "新增失败");
            hashMap.put("status", 0);
        }

        return hashMap;
    }

    //编辑一个工序计数
    public int editProcessCountCheck(ProcessCountCheck processCountCheck) {
        return processCountCheckMapper.updateByPrimaryKey(processCountCheck);
    }


    //删除一个工序计数
    public int deleteProcessCountCheck(String fCountCheckId) {
        return processCountCheckMapper.deleteByPrimaryKey(fCountCheckId);
    }

    //构建分页的查询结果
    public PageInfo<ProcessCountCheckVo> findProcessCountCheck(String name, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        PageInfo<ProcessCountCheckVo> objectPageInfo = null;

        searchValue = "%" + searchValue + "%";

        if (name.endsWith("CheckId")) {

            List<ProcessCountCheckVo> unqualifyApplyVos1 = processCountCheckMapper.searchProcessCountCheckByCheckId(searchValue);
            objectPageInfo = new PageInfo(unqualifyApplyVos1);

        }

        return objectPageInfo;
    }

    //修改note
    public int updateNote(ProcessCountCheck processCountCheck) {
        return processCountCheckMapper.updateByPrimaryKeySelective(processCountCheck);
    }

}
