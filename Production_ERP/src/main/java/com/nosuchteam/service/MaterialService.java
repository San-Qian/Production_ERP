package com.nosuchteam.service;

import com.nosuchteam.bean.Material;

import java.util.List;

public interface MaterialService {
    List<Material> findAllMaterial();

    boolean insert(Material material);

    boolean update(Material material);

    boolean delectById(String id);

    Material serachById(String id);

    List<Material> searchByType(String searchValue);


}
