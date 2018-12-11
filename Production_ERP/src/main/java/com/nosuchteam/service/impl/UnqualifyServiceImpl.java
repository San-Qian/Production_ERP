package com.nosuchteam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.UnqualifyApply;
import com.nosuchteam.bean.vo.UnqualifyApplyVo;
import com.nosuchteam.mapper.UnqualifyApplyMapper;
import com.nosuchteam.service.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2018/12/6-10:23
 */

@Service
public class UnqualifyServiceImpl implements UnqualifyService {

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    //不合格商品回显
    public PageInfo<UnqualifyApplyVo> findUnqualifyApplys(int page, int rows) {
        PageHelper.startPage(page, rows);

        List<UnqualifyApplyVo> allUnqualifyApply = unqualifyApplyMapper.findAllUnqualifyApply();

        PageInfo<UnqualifyApplyVo> objectPageInfo = new PageInfo(allUnqualifyApply);

        return objectPageInfo;
    }

    //新增一个不合格产品
    public Map addUnqualifyApply(UnqualifyApply unqualifyApply){

        HashMap hashMap = new HashMap();

        try {
            unqualifyApplyMapper.insert(unqualifyApply);

            hashMap.put("data", null);
            hashMap.put("msg", "OK");
            hashMap.put("status", 200);
        }  catch (DuplicateKeyException e) {
            hashMap.put("msg", "编号已存在");
            hashMap.put("status", 0);
        } catch (Exception e) {
            hashMap.put("msg", "新增失败");
            hashMap.put("status", 0);
        }

        return hashMap;
    }

    //编辑一个不合格产品
    public int editUnqualifyApply(UnqualifyApply unqualifyApply) {
        return unqualifyApplyMapper.updateByPrimaryKey(unqualifyApply);
    }


    //删除一个不合格产品
    public int deleteUnqualifyApply(String unqualifyApplyId) {
        return unqualifyApplyMapper.deleteByPrimaryKey(unqualifyApplyId);
    }

    //构建分页的查询结果
    public PageInfo<UnqualifyApplyVo> findUnqualifyApplyById(String name, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        PageInfo<UnqualifyApplyVo> objectPageInfo = null;

        searchValue = "%" + searchValue + "%";

        if(name.endsWith("Id")) {

            List<UnqualifyApplyVo> unqualifyApplyVos1 = unqualifyApplyMapper.searchUnqualifyApplyById(searchValue);
            objectPageInfo = new PageInfo(unqualifyApplyVos1);

        }else if(name.endsWith("Name")){
            List<UnqualifyApplyVo> unqualifyApplyVos2 = unqualifyApplyMapper.searchUnqualifyApplyByName(searchValue);
            objectPageInfo = new PageInfo<>(unqualifyApplyVos2);
        }

        return objectPageInfo;
    }

    //修改note
    @Override
    public int updateNote(UnqualifyApply unqualifyApply) {
        return unqualifyApplyMapper.updateByPrimaryKeySelective(unqualifyApply);
    }

}
