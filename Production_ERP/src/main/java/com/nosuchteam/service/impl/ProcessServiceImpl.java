package com.nosuchteam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Process;
import com.nosuchteam.mapper.ProcessMapper;
import com.nosuchteam.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<Process> select() {

        List<Process> list = processMapper.select();

        return list;
    }

    @Override
    public PageInfo<Process> selectByPage(String page, String rows) {

        int pageInt = Integer.parseInt(page);
        int rowsInt = Integer.parseInt(rows);

        PageHelper.startPage(pageInt,rowsInt);

        List<Process> list = processMapper.select();

        PageInfo<Process> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public Process selectById(String processId) {
        Process process = processMapper.selectByPrimaryKey(processId);

        return process;
    }

    @Override
    public void insert(Process process) throws Exception {
        int i = processMapper.insert(process);

        if (i != 1) {
            throw new Exception();
        }

    }

    @Override
    public boolean update(Process process) {
        int i = processMapper.updateByPrimaryKeySelective(process);

        if (i == 1) {
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteTechnologyById(String id) {
        int i = processMapper.deleteByPrimaryKey(id);

        if (i == 1) {
            return true;
        }

        return false;
    }

    @Override
    public PageInfo<Process> selectByAmbiguous(String name, String searchValue,String page,String rows) {
        List<Process> list = null;
        int pageInt = Integer.parseInt(page);
        int rowsInt = Integer.parseInt(rows);
        PageHelper.startPage(pageInt,rowsInt);
        searchValue = "%" + searchValue + "%";
        if (name.endsWith("processId")) {
            list = processMapper.selectByAmbiguousPrimaryKey(searchValue);
        }

        if(name.endsWith("technologyPlanId")) {
            list = processMapper.selectByAmbiguousForeignKey(searchValue);
        }

        PageInfo<Process> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


}
