package com.example.AutoPartsOnlineShopApi.service.part;

import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;

import java.util.List;
import java.util.Optional;

public interface PartService {
    List<Part> getAllParts();

    Optional<Part> getById(Long id);

    List<Part> getPartsByCategoryAndModel(PartCategory category, String model);

    List<Part> searchPartsByName(String name);
}
