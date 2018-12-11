package com.nosuchteam.mapper;

import com.nosuchteam.bean.FinalCountCheck;
import com.nosuchteam.bean.vo.FinalCountCheckVo;
import com.nosuchteam.bean.vo.FinalCountCheckVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FinalCountCheckMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record) throws Exception;

    int insertSelective(FinalCountCheck record);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    //回显
    List<FinalCountCheckVo> findAllFinalCountCheck();

    //通过checkId搜索指定不合格品
    List<FinalCountCheckVo> searchFinalCountCheckByCheckId(@Param("checkId") String searchValue);

    //通过orderId搜索指定不合格品
    List<FinalCountCheckVo> searchFinalCountCheckByOrderId(@Param("orderId") String searchValue);
}