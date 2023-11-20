package com.example.AutoPartsOnlineShopApi.service;

import com.example.AutoPartsOnlineShopApi.entity.Part;
import com.example.AutoPartsOnlineShopApi.entity.PartCategory;

import java.util.List;
import java.util.Optional;

public interface PartService {
    List<Part> getAllParts();

    Optional<Part> getById(Long id);

    List<Part> getPartsByCategoryAndModel(PartCategory category, String model);

    List<Part> searchPartsByName(String name);
}
