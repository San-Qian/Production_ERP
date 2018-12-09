package com.nosuchteam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.ProcessMeasureCheck;
import com.nosuchteam.bean.ProcessMeasureCheck;
import com.nosuchteam.bean.vo.ProcessMeasureCheckVo;
import com.nosuchteam.bean.vo.ProcessMeasureCheckVo;
import com.nosuchteam.mapper.ProcessMeasureCheckMapper;
import com.nosuchteam.service.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2018/12/8-11:03
 */

@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {

    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    //回显工序计量
    public PageInfo<ProcessMeasureCheckVo> findAllProcessMeasureCheckByPage(int page, int rows) {
        PageHelper.startPage(page, rows);

        List<ProcessMeasureCheckVo> allProcessMeasureCheck = processMeasureCheckMapper.findAllProcessMeasureCheck();

        PageInfo<ProcessMeasureCheckVo> objectPageInfo = new PageInfo(allProcessMeasureCheck);

        return objectPageInfo;
    }


    //新增一个工序计量
    public int addProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckMapper.insert(processMeasureCheck);
    }

    //编辑一个工序计量
    public int editProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck);
    }


    //删除一个工序计量
    public int deleteProcessMeasureCheck(String fMeasureCheckId) {
        return processMeasureCheckMapper.deleteByPrimaryKey(fMeasureCheckId);
    }

    //构建分页的查询结果
    public PageInfo<ProcessMeasureCheckVo> findProcessMeasureCheck(String name, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        PageInfo<ProcessMeasureCheckVo> objectPageInfo = null;

        searchValue = "%" + searchValue + "%";

        if (name.endsWith("CheckId")) {

            List<ProcessMeasureCheckVo> unqualifyApplyVos1 = processMeasureCheckMapper.searchProcessMeasureCheckByCheckId(searchValue);
            objectPageInfo = new PageInfo(unqualifyApplyVos1);

        }

        return objectPageInfo;
    }

    //修改note
    public int updateNote(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckMapper.updateByPrimaryKeySelective(processMeasureCheck);
    }

}