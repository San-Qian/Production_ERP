package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.ProcessCountCheck;
import com.nosuchteam.bean.ProcessCountCheck;
import com.nosuchteam.bean.vo.ProcessCountCheckVo;

import java.util.List;
import java.util.Map;

/**
 * @date 2018/12/8-11:00
 */
public interface ProcessCountCheckService {

    //工序计数质检回显
    PageInfo<ProcessCountCheckVo> findAllProcessCountCheckByPage(int page, int rows);

    //新增一个工序计数
    Map addProcessCountCheck(ProcessCountCheck processCountCheck);

    //编辑一个工序计数
    int editProcessCountCheck(ProcessCountCheck processCountCheck);

    //删除一个工序计数
    int deleteProcessCountCheck(String processCountCheckId);

    //根据id查询
    PageInfo<ProcessCountCheckVo> findProcessCountCheck(String name, String searchValue, int page, int rows);

    //修改note
    int updateNote(ProcessCountCheck processCountCheck);
}
