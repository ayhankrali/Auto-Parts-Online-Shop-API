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

    @Override
    public Make createMake(Make make) {
        // You may want to perform additional validation or logic before saving
        return makeRepository.save(make);
    }

    @Override
    public Make updateMake(Long id, Make make) {
        // Check if the make with the given id exists
        Optional<Make> existingMakeOptional = makeRepository.findById(id);

        if (existingMakeOptional.isPresent()) {
            Make existingMake = existingMakeOptional.get();

            // Update the existing make with the new information
            existingMake.setName(make.getName());


            // Save the updated make
            return makeRepository.save(existingMake);
        } else {
            // Handle the case when the make with the given id does not exist
            throw new IllegalArgumentException("Make with id " + id + " not found");
        }
    }

    @Override
    public void deleteMake(Long id) {
        // Check if the make with the given id exists
        if (makeRepository.existsById(id)) {
            // Delete the make with the given id
            makeRepository.deleteById(id);
        } else {
            // Handle the case when the make with the given id does not exist
            throw new IllegalArgumentException("Make with id " + id + " not found");
        }
    }
}
