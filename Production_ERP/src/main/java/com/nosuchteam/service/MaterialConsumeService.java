package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Material;
import com.nosuchteam.bean.MaterialConsume;
import com.nosuchteam.bean.MaterialReceive;

import java.util.List;

public interface MaterialConsumeService {
    PageInfo<MaterialConsume> findAllMaterialConsume(Integer page, Integer rows);

    boolean insert(MaterialConsume materialConsume);

    boolean update(MaterialConsume materialConsume);

    boolean delectById(String id);

    PageInfo<MaterialConsume> searchConsumeId(String searchValue, Integer page, Integer rows);

    PageInfo<MaterialConsume> serachByWorkId(String searchValue, Integer page, Integer rows);

    PageInfo<MaterialConsume> serachByMaterialId(String searchValue, Integer page, Integer rows);

    boolean updateNote(String consumeId, String note);
}
