package com.example.AutoPartsOnlineShopApi.service.partcategory;

import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;

import java.util.List;
import java.util.Optional;

public interface PartCategoryService {
    List<PartCategory> getAllPartCategories();

    Optional<PartCategory> getById(Long id);
}
