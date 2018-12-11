package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.ProcessMeasureCheck;
import com.nosuchteam.bean.ProcessMeasureCheck;
import com.nosuchteam.bean.vo.ProcessMeasureCheckVo;
import com.nosuchteam.bean.vo.ProcessMeasureCheckVo;

import java.util.List;
import java.util.Map;

/**
 * @date 2018/12/8-11:03
 */
public interface ProcessMeasureCheckService {

    //回显工序计量质检
    PageInfo<ProcessMeasureCheckVo> findAllProcessMeasureCheckByPage(int page, int rows);

    //新增一个成品计量
    Map addProcessMeasureCheck (ProcessMeasureCheck processMeasureCheck);

    //编辑一个成品计量
    int editProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck);

    //删除一个成品计量
    int deleteProcessMeasureCheck(String processMeasureCheckId);

    //根据id查询
    PageInfo<ProcessMeasureCheckVo> findProcessMeasureCheck(String name, String searchValue, int page, int rows);

    //修改note
    int updateNote(ProcessMeasureCheck ProcessMeasureCheck);
}
