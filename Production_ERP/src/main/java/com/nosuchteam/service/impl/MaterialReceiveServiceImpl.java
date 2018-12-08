package com.nosuchteam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<MaterialReceive> findAllMaterialReceive(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<MaterialReceive> materialReceives = receiveMapper.findAllMaterialReceive();
        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(materialReceives);
        return pageInfo;
    }

    @Override
    public Material getMaterialById(String materialId) {
        Material material = materialMapper.selectByPrimaryKey(materialId);
        return material;
    }

    @Override
    public boolean insert(MaterialReceive materialReceive) {
        int insert = receiveMapper.insert(materialReceive);
        if (insert == 1) {
            materialMapper.increaseRemanining(materialReceive.getMaterialId(), materialReceive.getAmount());
        }
        return insert == 1;
    }

    @Override
    public boolean update(MaterialReceive materialReceive) {
        //拿到之前的amount
        MaterialReceive receive = receiveMapper.selectByPrimaryKey(materialReceive.getReceiveId());
        Integer amount = receive.getAmount();
        int finalNum = materialReceive.getAmount() - amount;
        materialMapper.updateRemaining(materialReceive.getMaterialId(), finalNum);

        int update = receiveMapper.updateByPrimaryKeySelective(materialReceive);

        return update == 1;
    }

    @Override
    public boolean delectById(String id) {
        //删除之前拿到amount
        MaterialReceive receive = receiveMapper.selectByPrimaryKey(id);
        Integer amount = receive.getAmount();
        String materialId = receive.getMaterialId();
        materialMapper.decreaseRemanining(materialId,amount);
//        //拿到剩余数量
//        String materialId = receive.getMaterialId();
//        Material material = materialMapper.selectByPrimaryKey(materialId);
//        material.getRemaining();
        int delete = receiveMapper.deleteByPrimaryKey(id);
        return delete == 1;
    }

    @Override
    public PageInfo<MaterialReceive> searchByReceiveId(String searchValue,Integer page,Integer rows) {
        searchValue = "%" + searchValue + "%";
        PageHelper.startPage(page,rows);
        List<MaterialReceive> receives = receiveMapper.selectByReceiveId(searchValue);
        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(receives);
        return pageInfo;
    }

    @Override
    public PageInfo<MaterialReceive> serachByMaterialId(String searchValue,Integer page,Integer rows) {
        searchValue = "%" + searchValue + "%";
        PageHelper.startPage(page,rows);
        List<MaterialReceive> receives = receiveMapper.selectByMaterialId(searchValue);
        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(receives);
        return pageInfo;

    }

    @Override
    public boolean updateNote(String receiveId, String note) {
        int update = receiveMapper.updateNote(receiveId, note);
        return update == 1;
    }
}
