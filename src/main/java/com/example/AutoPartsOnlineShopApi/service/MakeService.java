package com.example.AutoPartsOnlineShopApi.service;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;

import java.util.List;
import java.util.Optional;

public interface MakeService {
    List<Make> getAllMakes();
    Optional<Make> getById(Long id);
}
