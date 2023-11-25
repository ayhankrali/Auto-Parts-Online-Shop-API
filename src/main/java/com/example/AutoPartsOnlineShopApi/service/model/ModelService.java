package com.example.AutoPartsOnlineShopApi.service.model;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    List<Model> getAllModels();
    Optional<Model> getById(Long id);
    List<Model> getModelsByMake(Make make);
}
