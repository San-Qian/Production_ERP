package com.nosuchteam.service;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.util.commons.PageInfo;

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:58
 * @Description:
 */
public interface CustomService {
    void save(Custom custom) throws Exception;

    PageInfo selectByPage(Custom custom, Integer page, Integer rows);

    void updateSelective(Custom custom) throws Exception;

    void delete(String[] ids) throws Exception;

    Custom selectById(String customId);

}
