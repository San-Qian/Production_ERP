package com.nosuchteam.service.impl;

import com.nosuchteam.bean.Material;
import com.nosuchteam.bean.MaterialReceive;
import com.nosuchteam.mapper.MaterialMapper;
import com.nosuchteam.mapper.MaterialReceiveMapper;
import com.nosuchteam.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper receiveMapper;

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<MaterialReceive> findAllMaterialReceive() {
        List<MaterialReceive> materialReceives = receiveMapper.findAllMaterialReceive();
        return materialReceives;
    }

    @Override
    public Material getMaterialById(String materialId) {
        Material material = materialMapper.selectByPrimaryKey(materialId);
        return material;
    }

    @Override
    public boolean insert(MaterialReceive materialReceive) {
        int insert = receiveMapper.insert(materialReceive);
        return insert == 1;
    }

    @Override
    public boolean update(MaterialReceive materialReceive) {
        int update = receiveMapper.updateByPrimaryKeySelective(materialReceive);
        return update == 1;
    }

    @Override
    public boolean delectById(String id) {
        int delete = receiveMapper.deleteByPrimaryKey(id);
        return delete == 1;
    }

    @Override
    public List<MaterialReceive> searchByReceiveId(String searchValue) {
        searchValue = "%" + searchValue + "%";
        List<MaterialReceive> receives = receiveMapper.selectByReceiveId(searchValue);
        return receives;
    }

    @Override
    public List<MaterialReceive> serachByMaterialId(String searchValue) {
        searchValue = "%" + searchValue + "%";
        List<MaterialReceive> receives = receiveMapper.selectByMaterialId(searchValue);
        return receives;

    }
}
