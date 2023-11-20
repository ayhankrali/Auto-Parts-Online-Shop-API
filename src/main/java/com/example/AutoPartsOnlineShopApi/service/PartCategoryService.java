package com.example.AutoPartsOnlineShopApi.service;

import com.example.AutoPartsOnlineShopApi.entity.PartCategory;

import java.util.List;
import java.util.Optional;

public interface PartCategoryService {
    List<PartCategory> getAllPartCategories();

    Optional<PartCategory> getById(Long id);
}
