package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Technology;

import java.util.List;

public interface TechnologyService {

    PageInfo<Technology> selectByPage(String page,String rows);

    List<Technology> select();

    boolean deleteTechnologyById(String technologyId);

    void insert(Technology technology) throws Exception;

    boolean update(Technology technology) throws Exception;

    PageInfo<Technology> selectByAmbiguous(String name, String searchValue,String page,String rows);

    Technology selectById(String technologyId);
}
