package com.nosuchteam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Technology;
import com.nosuchteam.mapper.TechnologyMapper;
import com.nosuchteam.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {


    @Autowired
    TechnologyMapper technologyMapper;


    @Override
    public PageInfo<Technology> selectByPage(String page, String rows) {

        int parseInt = Integer.parseInt(page);
        int rowsInt = Integer.parseInt(rows);
        PageHelper.startPage(parseInt, rowsInt);
        List<Technology> list = technologyMapper.select();

        PageInfo<Technology> pageInfo = new PageInfo<>(list);


        return pageInfo;
    }

    @Override
    public List<Technology> select() {
        List<Technology> list = technologyMapper.select();

        return list;
    }


    @Override
    public boolean deleteTechnologyById(String technologyId) {

        int i = technologyMapper.deleteByPrimaryKey(technologyId);

        if (i == 1) {
            return true;
        }

        return false;

    }

    @Override
    public void insert(Technology technology) throws Exception {
        int i = technologyMapper.insert(technology);

        if (i != 1) {
            throw new Exception();
        }
    }

    @Override
    public boolean update(Technology technology) throws Exception {
        int i = technologyMapper.updateByPrimaryKey(technology);

        if (i == 1) {
            return true;
        }

        return false;

    }

    @Override
    public PageInfo<Technology> selectByAmbiguous(String name, String searchValue, String page, String rows) {
        List<Technology> list = null;
        int parseInt = Integer.parseInt(page);
        int rowsInt = Integer.parseInt(rows);
        PageHelper.startPage(parseInt, rowsInt);
        searchValue = "%" + searchValue + "%";

        if (name.endsWith("Id")) {
            list = technologyMapper.selectByAmbiguousPrimaryKey(searchValue);
        }

        if (name.endsWith("Name")) {
            list = technologyMapper.selectByAmbiguousName(searchValue);
        }

        PageInfo<Technology> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Technology selectById(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }
}
