package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanService {

    List<TechnologyPlan> select();

    PageInfo<TechnologyPlan> selectByPage(String page, String rows);

    TechnologyPlan selectById(String technologyPlanId);

    void insert(TechnologyPlan technologyPlan) throws Exception;

    boolean update(TechnologyPlan technologyPlan);

    boolean deleteTechnologyById(String id);

    PageInfo<TechnologyPlan> selectByAmbiguous(String name, String searchValue, String page, String rows);
}
