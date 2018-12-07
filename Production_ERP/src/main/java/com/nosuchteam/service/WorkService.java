package com.nosuchteam.service;

import com.nosuchteam.bean.Work;
import com.nosuchteam.util.commons.PageInfo;

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:59
 * @Description:
 */
public interface WorkService {
    void save(Work work) throws Exception;

    PageInfo selectByPage(Work work, Integer page, Integer rows);

    void update(Work work) throws Exception;

    void delete(String[] ids) throws Exception;

    Work selectById(String workId);
}
