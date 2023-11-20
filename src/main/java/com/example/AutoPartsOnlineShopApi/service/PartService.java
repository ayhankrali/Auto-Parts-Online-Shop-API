package com.example.AutoPartsOnlineShopApi.service;

import com.example.AutoPartsOnlineShopApi.entity.Part;

import java.util.List;
import java.util.Optional;

public interface PartService {
    List<Part> getAllParts();

    Optional<Part> getById(Long id);
}
