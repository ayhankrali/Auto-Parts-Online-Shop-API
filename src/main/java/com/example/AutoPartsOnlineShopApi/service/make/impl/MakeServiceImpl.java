package com.example.AutoPartsOnlineShopApi.service.make.impl;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.repository.make.MakeRepository;
import com.example.AutoPartsOnlineShopApi.service.make.MakeService;
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
