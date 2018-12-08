package com.nosuchteam.service;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Material;

import java.util.List;

public interface MaterialService {
    List<Material> findAllMaterial();

    boolean insert(Material material);

    boolean update(Material material);

    boolean delectById(String id);

    Material serachById(String id);

    PageInfo<Material> searchByType(String searchValue, Integer page, Integer rows);


    PageInfo<Material> serachMaterialsById(String searchValue, Integer page, Integer rows);

    boolean updateNote(String receiveId, String note);

    PageInfo<Material> findAllMaterial(Integer page, Integer rows);
}
