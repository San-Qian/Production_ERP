package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Process;

import java.util.List;

public interface ProcessService {

    List<Process> select();

    PageInfo<Process> selectByPage(String page,String rows);

    Process selectById(String processId);

    void insert(Process process) throws Exception;

    boolean update(Process process);

    boolean deleteTechnologyById(String id);

    PageInfo<Process> selectByAmbiguous(String name, String searchValue,String page,String rows);
}
