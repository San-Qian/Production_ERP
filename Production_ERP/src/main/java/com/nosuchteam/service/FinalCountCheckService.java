package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.FinalCountCheck;
import com.nosuchteam.bean.FinalCountCheck;
import com.nosuchteam.bean.vo.FinalCountCheckVo;
import com.nosuchteam.bean.vo.FinalCountCheckVo;

import java.util.List;

/**
 * @date 2018/12/8-10:53
 */
public interface FinalCountCheckService {

    //成品计数质检回显
    PageInfo<FinalCountCheckVo> findAllFinalCountCheckByPage(int page,int rows);

    //新增一个成品计数
    int addFinalCountCheck(FinalCountCheck finalCountCheck);

    //编辑一个成品计数
    int editFinalCountCheck(FinalCountCheck finalCountCheck);

    //删除一个成品计数
    int deleteFinalCountCheck(String finalCountCheckId);

    //根据id查询
    PageInfo<FinalCountCheckVo> findFinalCountCheck(String name, String searchValue, int page, int rows);

    //修改note
    int updateNote(FinalCountCheck finalCountCheck);
}
