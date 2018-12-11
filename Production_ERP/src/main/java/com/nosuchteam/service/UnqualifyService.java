package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.UnqualifyApply;
import com.nosuchteam.bean.vo.UnqualifyApplyVo;

import java.util.Map;

/**
 * @date 2018/12/6-10:08
 */


public interface UnqualifyService {

    //回显页面
    PageInfo<UnqualifyApplyVo> findUnqualifyApplys(int page, int rows);

    //新增一个不合格产品
    Map addUnqualifyApply(UnqualifyApply unqualifyApply);

    //编辑一个不合格产品
    int editUnqualifyApply(UnqualifyApply unqualifyApply);

    //删除一个不合格产品
    int deleteUnqualifyApply(String unqualifyApplyId);

    //根据id查询
    PageInfo<UnqualifyApplyVo> findUnqualifyApplyById(String name, String searchValue, int page, int rows);

    //修改note
    int updateNote(UnqualifyApply unqualifyApply);
}
