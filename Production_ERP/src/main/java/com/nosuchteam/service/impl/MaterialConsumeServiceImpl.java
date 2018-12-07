package com.nosuchteam.service.impl;

import com.nosuchteam.bean.MaterialConsume;
import com.nosuchteam.bean.MaterialReceive;
import com.nosuchteam.mapper.MaterialConsumeMapper;
import com.nosuchteam.mapper.MaterialMapper;
import com.nosuchteam.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

    @Autowired
    MaterialConsumeMapper consumeMapper;

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<MaterialConsume> findAllMaterialConsume() {
        List<MaterialConsume> consumes = consumeMapper.findAllMaterialConsume();
        return consumes;
    }

    @Override
    public boolean insert(MaterialConsume materialConsume) {
        int insert = consumeMapper.insert(materialConsume);
        if (insert == 1) {
            materialMapper.decreaseRemanining(materialConsume.getMaterialId(), materialConsume.getConsumeAmount());
        }
        return insert == 1;
    }

    @Override
    public boolean update(MaterialConsume materialConsume) {
        //拿到之前的amount
        MaterialConsume consume = consumeMapper.selectByPrimaryKey(materialConsume.getConsumeId());
        Integer amount = consume.getConsumeAmount();
        int finalNum = materialConsume.getConsumeAmount() - amount;
        materialMapper.updateRemaining2(materialConsume.getMaterialId(), finalNum);

        int update = consumeMapper.updateByPrimaryKeySelective(materialConsume);

        return update == 1;
    }

    @Override
    public boolean delectById(String id) {
        //删除之前拿到amount
        MaterialConsume consume = consumeMapper.selectByPrimaryKey(id);
        Integer consumeAmount = consume.getConsumeAmount();
        String materialId = consume.getMaterialId();
        materialMapper.increaseRemanining(materialId, consumeAmount);

        int delete = consumeMapper.deleteByPrimaryKey(id);
        return delete == 1;
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

    @Override
    public boolean updateNote(String consumeId, String note) {
        int update = consumeMapper.updateNote(consumeId, note);
        return update == 1;
    }
}
