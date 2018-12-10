package com.nosuchteam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.TechnologyPlan;
import com.nosuchteam.mapper.TechnologyPlanMapper;
import com.nosuchteam.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {

    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    public List<TechnologyPlan> select() {
        List<TechnologyPlan> list = technologyPlanMapper.select();
        return list;
    }

    @Override
    public PageInfo<TechnologyPlan> selectByPage(String page, String rows) {

        int parseInt = Integer.parseInt(page);
        int rowsInt = Integer.parseInt(rows);
        PageHelper.startPage(parseInt, rowsInt);

        List<TechnologyPlan> list = technologyPlanMapper.select();

        System.out.println(list);
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);

        return pageInfo;

    }

    @Override
    public TechnologyPlan selectById(String technologyPlanId) {

        TechnologyPlan technologyPlan = technologyPlanMapper.selectByPrimaryKey(technologyPlanId);

        return technologyPlan;
    }

    @Override
    public void insert(TechnologyPlan technologyPlan) throws Exception {
        int i = technologyPlanMapper.insert(technologyPlan);
        if (i != 1) {
            throw new Exception();
        }
    }

    @Override
    public boolean update(TechnologyPlan technologyPlan) {

        int i = technologyPlanMapper.updateByPrimaryKeySelective(technologyPlan);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTechnologyById(String id) {

        int i = technologyPlanMapper.deleteByPrimaryKey(id);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<TechnologyPlan> selectByAmbiguous(String name, String searchValue,String page,String rows) {

        List<TechnologyPlan> list = null;
        int parseInt = Integer.parseInt(page);
        int rowsInt = Integer.parseInt(rows);
        PageHelper.startPage(parseInt, rowsInt);

        searchValue = "%" + searchValue + "%";
        if (name.endsWith("Id")) {
            list = technologyPlanMapper.selectByAmbiguousPrimaryKey(searchValue);
        }

        if (name.endsWith("Name")) {
            list = technologyPlanMapper.selectByAmbiguousName(searchValue);
        }

        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }
}
