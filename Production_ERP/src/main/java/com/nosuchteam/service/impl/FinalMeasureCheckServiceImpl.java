package com.nosuchteam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.FinalMeasuretCheck;
import com.nosuchteam.bean.UnqualifyApply;
import com.nosuchteam.bean.vo.FinalMeasuretCheckVo;
import com.nosuchteam.bean.vo.UnqualifyApplyVo;
import com.nosuchteam.mapper.FinalMeasuretCheckMapper;
import com.nosuchteam.service.FinalMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2018/12/8-10:57
 */
@Service
public class FinalMeasureCheckServiceImpl implements FinalMeasureCheckService {

    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    //回显成品计量
    @Override
    public PageInfo<FinalMeasuretCheckVo> findFinalMeasuretCheckByPage(int page, int rows) {
        PageHelper.startPage(page, rows);

        List<FinalMeasuretCheckVo> allFinalMeasuretCheck = finalMeasuretCheckMapper.findAllFinalMeasuretCheck();

        PageInfo<FinalMeasuretCheckVo> objectPageInfo = new PageInfo(allFinalMeasuretCheck);

        return objectPageInfo;
    }

    //新增一个成品计量
    public Map addFinalMeasureCheck(FinalMeasuretCheck finalMeasuretCheck) {

        HashMap hashMap = new HashMap();

        try {
            finalMeasuretCheckMapper.insert(finalMeasuretCheck);
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

    //编辑一个成品计量
    public int editFinalMeasureCheck(FinalMeasuretCheck finalMeasuretCheck) {
        return finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
    }


    //删除一个成品计量
    public int deleteFinalMeasureCheck(String fMeasureCheckId) {
        return finalMeasuretCheckMapper.deleteByPrimaryKey(fMeasureCheckId);
    }

    //构建分页的查询结果
    public PageInfo<FinalMeasuretCheckVo> findFinalMeasureCheck(String name, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        PageInfo<FinalMeasuretCheckVo> objectPageInfo = null;

        searchValue = "%" + searchValue + "%";

        if(name.endsWith("CheckId")) {

            List<FinalMeasuretCheckVo> unqualifyApplyVos1 = finalMeasuretCheckMapper.searchFinalMeasuretCheckByCheckId(searchValue);
            objectPageInfo = new PageInfo(unqualifyApplyVos1);

        }else if(name.endsWith("orderId")){
            List<FinalMeasuretCheckVo> unqualifyApplyVos2 = finalMeasuretCheckMapper.searchFinalMeasuretCheckByOrderId(searchValue);
            objectPageInfo = new PageInfo<>(unqualifyApplyVos2);
        }

        return objectPageInfo;
    }

    //修改note
    public int updateNote(FinalMeasuretCheck finalMeasuretCheck) {
        return finalMeasuretCheckMapper.updateByPrimaryKeySelective(finalMeasuretCheck);
    }


}

