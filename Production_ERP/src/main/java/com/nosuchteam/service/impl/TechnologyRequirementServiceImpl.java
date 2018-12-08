package com.nosuchteam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Technology;
import com.nosuchteam.bean.TechnologyRequirement;
import com.nosuchteam.mapper.TechnologyRequirementMapper;
import com.nosuchteam.service.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;


    @Override
    public List<TechnologyRequirement> select() {

        List<TechnologyRequirement> list = technologyRequirementMapper.select();

        return list;
    }

    @Override
    public TechnologyRequirement selectById(String technologyRequirementId) {

        TechnologyRequirement technologyRequirement = technologyRequirementMapper.selectByPrimaryKey(technologyRequirementId);
        return technologyRequirement;
    }

    @Override
    public PageInfo<TechnologyRequirement> selectByPage(String page, String rows) {
        int pageInt = Integer.parseInt(page);
        int rowsInt = Integer.parseInt(rows);

        PageHelper.startPage(pageInt, rowsInt);

        List<TechnologyRequirement> list = technologyRequirementMapper.select();

        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public void insert(TechnologyRequirement technologyRequirement) throws Exception {
        int i = technologyRequirementMapper.insert(technologyRequirement);

        if (i != 1) {

            throw new Exception();
        }

    }

    @Override
    public boolean update(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateByPrimaryKeySelective(technologyRequirement);

        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTechnologyRequirementById(String id) {

        int i = technologyRequirementMapper.deleteByPrimaryKey(id);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<TechnologyRequirement> selectByAmbiguous(String name, String searchValue, String page, String rows) {

        List<TechnologyRequirement> list = null;
        int pageInt = Integer.parseInt(page);
        int rowsInt = Integer.parseInt(rows);

        PageHelper.startPage(pageInt, rowsInt);
        searchValue = "%" + searchValue + "%";
        if (name.endsWith("Id")) {
            list = technologyRequirementMapper.selectByAmbiguousPrimaryKey(searchValue);
        }

        if (name.endsWith("Name")) {
            list = technologyRequirementMapper.selectByAmbiguousName(searchValue);
        }

        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


}
