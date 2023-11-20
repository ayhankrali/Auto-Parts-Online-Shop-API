package com.example.AutoPartsOnlineShopApi.service.impl;

import com.example.AutoPartsOnlineShopApi.entity.Model;
import com.example.AutoPartsOnlineShopApi.repository.ModelRepository;
import com.example.AutoPartsOnlineShopApi.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }
    @Override
    public Optional<Model> getById(Long id) {
        return modelRepository.findById(id);
    }

    @Override
    public List<Model> getModelsByMake(String make) {
        return modelRepository.findByMake(make);
    }

}