package com.example.AutoPartsOnlineShopApi.service.impl;

import com.example.AutoPartsOnlineShopApi.entity.Make;
import com.example.AutoPartsOnlineShopApi.repository.MakeRepository;
import com.example.AutoPartsOnlineShopApi.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakeServiceImpl implements MakeService {
    private final MakeRepository makeRepository;

    @Autowired
    public MakeServiceImpl(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    @Override
    public List<Make> getAllMakes() {
        return makeRepository.findAll();
    }

    @Override
    public Optional<Make> getById(Long id) {
        return makeRepository.findById(id);
    }
}
