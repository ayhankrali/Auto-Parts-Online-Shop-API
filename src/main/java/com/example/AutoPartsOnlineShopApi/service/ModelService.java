package com.example.AutoPartsOnlineShopApi.service;

import com.example.AutoPartsOnlineShopApi.entity.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    List<Model> getAllModels();
    Optional<Model> getById(Long id);
}
