package com.nosuchteam.mapper;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.FinalMeasuretCheck;
import com.nosuchteam.bean.vo.FinalMeasuretCheckVo;
import com.nosuchteam.bean.vo.UnqualifyApplyVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FinalMeasuretCheckMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

    //回显
    List<FinalMeasuretCheckVo> findAllFinalMeasuretCheck();

    //通过checkId搜索指定不合格品
    List<FinalMeasuretCheckVo> searchFinalMeasuretCheckByCheckId(@Param("checkId") String searchValue);

    //通过orderId搜索指定不合格品
    List<FinalMeasuretCheckVo> searchFinalMeasuretCheckByOrderId(@Param("orderId") String searchValue);
}