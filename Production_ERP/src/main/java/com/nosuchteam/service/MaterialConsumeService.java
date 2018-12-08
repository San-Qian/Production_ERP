package com.nosuchteam.service;

import com.nosuchteam.bean.Material;
import com.nosuchteam.bean.MaterialConsume;
import com.nosuchteam.bean.MaterialReceive;

import java.util.List;

public interface MaterialConsumeService {
    List<MaterialConsume> findAllMaterialConsume();

    boolean insert(MaterialConsume materialConsume);

    boolean update(MaterialConsume materialConsume);

    boolean delectById(String id);

    List<MaterialConsume> searchConsumeId(String searchValue);

    List<MaterialConsume> serachByWorkId(String searchValue);

    List<MaterialConsume> serachByMaterialId(String searchValue);

    boolean updateNote(String consumeId, String note);
}
