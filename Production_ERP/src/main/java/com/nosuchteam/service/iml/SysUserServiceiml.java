package com.nosuchteam.service.iml;

import com.nosuchteam.bean.SysUser;
import com.nosuchteam.mapper.SysUserMapper;
import com.nosuchteam.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SysUserService")
public class SysUserServiceiml implements SysUserService {
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
        return mapper.selectByPrimaryKey(id);
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
    //可能返回null
    @Override
    public SysUser login(SysUser sysUser) {
        SysUser user=mapper.login(sysUser);
        if(user!=null){
            return user;
        }
        return null;
    }
}
