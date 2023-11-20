package com.example.AutoPartsOnlineShopApi.service.impl;

import com.example.AutoPartsOnlineShopApi.entity.Part;
import com.example.AutoPartsOnlineShopApi.entity.PartCategory;
import com.example.AutoPartsOnlineShopApi.repository.PartRepository;
import com.example.AutoPartsOnlineShopApi.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    @Override
    public Optional<Part> getById(Long id) {
        return partRepository.findById(id);
    }


    @Override
    public List<Part> getPartsByCategoryAndModel(PartCategory category, String model) {
        return partRepository.findByCategoryAndCompatibleModelsName(category,model);
    }

    @Override
    public List<Part> searchPartsByName(String name) {
        return partRepository.findByNameContainingIgnoreCase(name);
    }


}