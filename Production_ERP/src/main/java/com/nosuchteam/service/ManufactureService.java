package com.nosuchteam.service;

import com.nosuchteam.bean.Manufacture;
import com.nosuchteam.util.commons.Page;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:59
 * @Description:
 */
public interface ManufactureService {
    void save(Manufacture manufacture) throws Exception;

    Page selectByPage(Manufacture manufacture, Integer page, Integer rows);

    void update(Manufacture manufacture) throws Exception;

    void delete(String[] ids) throws Exception;

    Manufacture selectById(String manufactureId);
}
