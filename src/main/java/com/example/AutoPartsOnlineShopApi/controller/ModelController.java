package com.example.AutoPartsOnlineShopApi.controller;


import com.example.AutoPartsOnlineShopApi.entity.Make;
import com.example.AutoPartsOnlineShopApi.entity.Model;
import com.example.AutoPartsOnlineShopApi.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/{make}")
    public List<Model> getModelsByMake(@PathVariable Make make) {
        return modelService.getModelsByMake(make);
    }
}

