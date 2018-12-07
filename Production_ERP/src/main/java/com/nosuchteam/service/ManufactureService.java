package com.nosuchteam.service;

import com.nosuchteam.bean.Manufacture;
import com.nosuchteam.util.commons.PageInfo;

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:59
 * @Description:
 */
public interface ManufactureService {
    void save(Manufacture manufacture) throws Exception;

    PageInfo selectByPage(Manufacture manufacture, Integer page, Integer rows);

    void update(Manufacture manufacture) throws Exception;

    void delete(String[] ids) throws Exception;

    Manufacture selectById(String manufactureId);
}
