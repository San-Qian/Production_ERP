package com.nosuchteam.service.impl;

import com.nosuchteam.bean.MaterialConsume;
import com.nosuchteam.bean.MaterialReceive;
import com.nosuchteam.mapper.MaterialConsumeMapper;
import com.nosuchteam.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService{

    @Autowired
    MaterialConsumeMapper consumeMapper;

    @Override
    public List<MaterialConsume> findAllMaterialConsume() {
        List<MaterialConsume> consumes = consumeMapper.findAllMaterialConsume();
        return consumes;
    }

    @Override
    public boolean insert(MaterialConsume materialConsume) {
        int insert = consumeMapper.insert(materialConsume);
        return insert==1;
    }

    @Override
    public boolean update(MaterialConsume materialConsume) {
        int update = consumeMapper.updateByPrimaryKeySelective(materialConsume);
        return update==1;
    }

    @Override
    public boolean delectById(String id) {
        int delete = consumeMapper.deleteByPrimaryKey(id);
        return delete==1;
    }

    @Override
    public List<MaterialConsume> searchConsumeId(String searchValue) {
        searchValue = "%" + searchValue + "%";
        List<MaterialConsume> materialConsumes = consumeMapper.selectByConsumeId(searchValue);
        return materialConsumes;
    }

    @Override
    public List<MaterialConsume> serachByWorkId(String searchValue) {
        searchValue = "%" + searchValue + "%";
        List<MaterialConsume> materialConsumes = consumeMapper.selectByWorkId(searchValue);
        return materialConsumes;
    }

    @Override
    public List<MaterialConsume> serachByMaterialId(String searchValue) {
        searchValue = "%" + searchValue + "%";
        List<MaterialConsume> materialConsumes = consumeMapper.selectByMaterialId(searchValue);
        return materialConsumes;
    }
}
