package com.nosuchteam.service.iml;

import com.nosuchteam.bean.SysUser;
import com.nosuchteam.mapper.SysUserMapper;
import com.nosuchteam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceiml implements UserService {
    @Autowired
    SysUserMapper mapper;


    public boolean deleteById(String id) {
        if(mapper.deleteByPrimaryKey(id)>0){
            return true;
        }

        return false ;
    }

    public boolean insert(SysUser record) {
        if(mapper.insert(record)>0){
            return true;
        }
        return false ;
    }

    public boolean insertSelective(SysUser record) {
        if(mapper.insertSelective(record)>0){
            return true;
        }

        return false ;
    }

    public SysUser selectById(String id) {
        return null;
    }

    public boolean updateByIdSelective(SysUser record) {
        if (mapper.updateByPrimaryKeySelective(record) > 0) {
            return true;
        }

        return false;
    }

    public boolean updateById(SysUser record) {
        if(mapper.updateByPrimaryKey(record)>0){
            return true;
        }
        return false ;
    }
}
