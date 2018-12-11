package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.FinalMeasuretCheck;
import com.nosuchteam.bean.UnqualifyApply;
import com.nosuchteam.bean.vo.FinalMeasuretCheckVo;
import com.nosuchteam.bean.vo.UnqualifyApplyVo;

import java.util.List;
import java.util.Map;

/**
 * @date 2018/12/8-10:57
 */
public interface FinalMeasureCheckService {

    //回显成品计量
    PageInfo<FinalMeasuretCheckVo> findFinalMeasuretCheckByPage(int page,int rows);

    //新增一个成品计量
    Map addFinalMeasureCheck(FinalMeasuretCheck finalMeasuretCheck);

    //编辑一个成品计量
    int editFinalMeasureCheck(FinalMeasuretCheck finalMeasuretCheck);

    //删除一个成品计量
    int deleteFinalMeasureCheck(String FinalMeasureCheckId);

    //根据id查询
    PageInfo<FinalMeasuretCheckVo> findFinalMeasureCheck(String name, String searchValue, int page, int rows);

    //修改note
    int updateNote(FinalMeasuretCheck finalMeasuretCheck);
}
