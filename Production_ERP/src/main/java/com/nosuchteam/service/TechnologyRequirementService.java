package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.TechnologyRequirement;

import java.util.List;

public interface TechnologyRequirementService {

    List<TechnologyRequirement> select();

    PageInfo<TechnologyRequirement> selectByAmbiguous(String name, String searchValue,String page,String rows);

    TechnologyRequirement selectById(String technologyRequirementId);

    PageInfo<TechnologyRequirement> selectByPage(String page, String rows);

    void insert(TechnologyRequirement technologyRequirement) throws Exception;

    boolean update(TechnologyRequirement technologyRequirement);

    boolean deleteTechnologyRequirementById(String id);


}
