package com.nosuchteam.service;

import com.nosuchteam.bean.SysUser;

public interface UserService {
    boolean deleteById(String id);

    boolean insert(SysUser record);

    boolean insertSelective(SysUser record);

    SysUser selectById(String id);

    boolean updateByIdSelective(SysUser record);

    boolean updateById(SysUser record);
}
