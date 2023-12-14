package com.example.AutoPartsOnlineShopApi.service.admin.impl;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.repository.make.MakeRepository;
import com.example.AutoPartsOnlineShopApi.repository.model.ModelRepository;
import com.example.AutoPartsOnlineShopApi.repository.part.PartRepository;
import com.example.AutoPartsOnlineShopApi.service.admin.AdminService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
        Objects.requireNonNull(id, "ID must not be null");
        return makeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Make not found with ID: " + id));
    }

    @Override
    public Model getModelById(Long id) {
        Objects.requireNonNull(id, "ID must not be null");
        return modelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Model not found with ID: " + id));
    }

    @Override
    public void createMake(Make make) {
        makeRepository.save(Objects.requireNonNull(make, "Make must not be null"));
    }

    @Override
    public void createModel(Model model) {
        modelRepository.save(Objects.requireNonNull(model, "Model must not be null"));
    }

    @Override
    public void updateMake(Long id, Make make) {
        make.setId(id);
        makeRepository.save(make);
    }

    @Override
    public void updateModel(Long id, Model model) {
        model.setId(id);
        modelRepository.save(model);
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
        partRepository.save(Objects.requireNonNull(part, "Part must not be null"));
    }

    @Override
    public void updatePart(Long id, Part part) {
        part.setId(id);
        partRepository.save(part);
    }

    @Override
    public void deletePart(Long id) {
        partRepository.deleteById(id);
    }

  /*  @Override
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
    }*/
}
