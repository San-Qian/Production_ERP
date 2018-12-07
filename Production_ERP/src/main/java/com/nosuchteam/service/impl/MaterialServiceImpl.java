package com.nosuchteam.service.impl;

import com.nosuchteam.bean.Material;
import com.nosuchteam.mapper.MaterialMapper;
import com.nosuchteam.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Material> findAllMaterial() {
        List<Material> materials = materialMapper.findAllMaterial();
        return materials;
    }

    @Override
    public boolean insert(Material material) {
        int insert = materialMapper.insert(material);
        return insert==1;
    }

    @Override
    public boolean update(Material material) {
        int update = materialMapper.updateByPrimaryKeySelective(material);
        return update==1;
    }

    @Override
    public boolean delectById(String id) {
        int delete = materialMapper.deleteById(id);
        return delete==1;
    }

    @Override
    public Material serachById(String id) {
        Material material = materialMapper.selectByPrimaryKey(id);
        return material;
    }

    @Override
    public List<Material> searchByType(String searchValue) {
        List<Material> materials = materialMapper.selectByType(searchValue);
        return materials;
    }




}
