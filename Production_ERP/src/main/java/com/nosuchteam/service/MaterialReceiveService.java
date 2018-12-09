package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Material;
import com.nosuchteam.bean.MaterialReceive;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MaterialReceiveService {
    PageInfo<MaterialReceive> findAllMaterialReceive(Integer page, Integer rows);

    Material getMaterialById(String materialId);

    boolean insert(MaterialReceive materialReceive);

    boolean update(MaterialReceive materialReceive);

    boolean delectById(String id);

    PageInfo<MaterialReceive> searchByReceiveId(String searchValue, Integer page, Integer rows);

    PageInfo<MaterialReceive> serachByMaterialId(String searchValue, Integer page, Integer rows);

    boolean updateNote(@Param("receiveId") String receiveId, @Param("note") String note);
}
