package com.example.AutoPartsOnlineShopApi.service.partcategory.impl;

import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import com.example.AutoPartsOnlineShopApi.repository.partcategory.PartCategoryRepository;
import com.example.AutoPartsOnlineShopApi.service.partcategory.PartCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartCategoryServiceImpl implements PartCategoryService {

    private final PartCategoryRepository partCategoryRepository;

    @Autowired
    public PartCategoryServiceImpl(PartCategoryRepository partCategoryRepository) {
        this.partCategoryRepository = partCategoryRepository;
    }

    @Override
    public List<PartCategory> getAllPartCategories() {
        return partCategoryRepository.findAll();
    }

    @Override
    public Optional<PartCategory> getById(Long id) {
        return partCategoryRepository.findById(id);
    }

}