package com.example.AutoPartsOnlineShopApi.service.impl;

import com.example.AutoPartsOnlineShopApi.entity.Make;
import com.example.AutoPartsOnlineShopApi.entity.Model;
import com.example.AutoPartsOnlineShopApi.entity.Part;
import com.example.AutoPartsOnlineShopApi.repository.MakeRepository;
import com.example.AutoPartsOnlineShopApi.repository.ModelRepository;
import com.example.AutoPartsOnlineShopApi.repository.PartRepository;
import com.example.AutoPartsOnlineShopApi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final MakeRepository makeRepository;
    private final ModelRepository modelRepository;
    private final PartRepository partRepository;

    @Autowired
    public AdminServiceImpl(MakeRepository makeRepository, ModelRepository modelRepository, PartRepository partRepository) {
        this.makeRepository = makeRepository;
        this.modelRepository = modelRepository;
        this.partRepository = partRepository;
    }

    @Override
    public Make getMakeById(Long id) {
        return makeRepository.findById(id).orElse(null);
    }

    @Override
    public Model getModelById(Long id) {
        return modelRepository.findById(id).orElse(null);
    }

    @Override
    public void createMake(Make make) {
        makeRepository.save(make);
    }

    @Override
    public void createModel(Model model) {
        modelRepository.save(model);
    }

    @Override
    public void updateMake(Long id, Make make) {
        Make existingMake = makeRepository.findById(id).orElse(null);
        if (existingMake != null) {
            existingMake.setName(make.getName());
            makeRepository.save(existingMake);
        }
    }

    @Override
    public void updateModel(Long id, Model model) {
        Model existingModel = modelRepository.findById(id).orElse(null);
        if (existingModel != null) {
            existingModel.setName(model.getName());
            modelRepository.save(existingModel);
        }
    }

    @Override
    public void deleteMake(Long id) {
        makeRepository.deleteById(id);
    }

    @Override
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public void createPart(Part part) {
        partRepository.save(part);
    }

    @Override
    public void updatePart(Long id, Part part) {
        Part existingPart = partRepository.findById(id).orElse(null);
        if (existingPart != null) {
            existingPart.setName(part.getName());
            partRepository.save(existingPart);
        }
    }

    @Override
    public void deletePart(Long id) {
        partRepository.deleteById(id);
    }
}
