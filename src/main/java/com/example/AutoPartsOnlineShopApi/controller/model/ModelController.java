package com.example.AutoPartsOnlineShopApi.controller.model;


import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import com.example.AutoPartsOnlineShopApi.service.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


}

