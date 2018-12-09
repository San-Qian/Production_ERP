package com.nosuchteam.mapper;

import com.nosuchteam.bean.UnqualifyApply;
import com.nosuchteam.bean.vo.UnqualifyApplyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyApplyMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    //添加不合格品
    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);

    //查询unqualify页面列表回显所需所有元素
    List<UnqualifyApplyVo> findAllUnqualifyApply();

    //通过编号搜索指定不合格品
    List<UnqualifyApplyVo> searchUnqualifyApplyById(@Param("id") String searchValue);

    //通过名称搜索指定不合格品
    List<UnqualifyApplyVo> searchUnqualifyApplyByName(@Param("name") String searchValue);

}