package com.nosuchteam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.FinalCountCheck;
import com.nosuchteam.bean.FinalCountCheck;
import com.nosuchteam.bean.vo.FinalCountCheckVo;
import com.nosuchteam.bean.vo.FinalCountCheckVo;
import com.nosuchteam.mapper.FinalCountCheckMapper;
import com.nosuchteam.service.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2018/12/8-10:54
 */

@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {

    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;
    
    //成品计数质检回显
    @Override
    public PageInfo<FinalCountCheckVo> findAllFinalCountCheckByPage(int page, int rows) {
        PageHelper.startPage(page, rows);

        List<FinalCountCheckVo> allFinalCountCheck = finalCountCheckMapper.findAllFinalCountCheck();

        PageInfo<FinalCountCheckVo> objectPageInfo = new PageInfo(allFinalCountCheck);

        return objectPageInfo;
    }

    //新增一个成品计量
    public Map addFinalCountCheck(FinalCountCheck finalCountCheck) {

        HashMap hashMap = new HashMap();
        try {
            finalCountCheckMapper.insert(finalCountCheck);

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
    public int editFinalCountCheck(FinalCountCheck finalCountCheck) {
        return finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
    }


    //删除一个成品计量
    public int deleteFinalCountCheck(String fCountCheckId) {
        return finalCountCheckMapper.deleteByPrimaryKey(fCountCheckId);
    }

    //构建分页的查询结果
    public PageInfo<FinalCountCheckVo> findFinalCountCheck(String name, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        PageInfo<FinalCountCheckVo> objectPageInfo = null;

        searchValue = "%" + searchValue + "%";

        if(name.endsWith("CheckId")) {

            List<FinalCountCheckVo> unqualifyApplyVos1 = finalCountCheckMapper.searchFinalCountCheckByCheckId(searchValue);
            objectPageInfo = new PageInfo(unqualifyApplyVos1);

        }else if(name.endsWith("orderId")){
            List<FinalCountCheckVo> unqualifyApplyVos2 = finalCountCheckMapper.searchFinalCountCheckByOrderId(searchValue);
            objectPageInfo = new PageInfo<>(unqualifyApplyVos2);
        }

        return objectPageInfo;
    }

    //修改note
    public int updateNote(FinalCountCheck FinalCountCheck) {
        return finalCountCheckMapper.updateByPrimaryKeySelective(FinalCountCheck);
    }
}
