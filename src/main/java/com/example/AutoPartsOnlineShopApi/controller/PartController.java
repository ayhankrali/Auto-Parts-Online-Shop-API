package com.example.AutoPartsOnlineShopApi.controller;

import com.example.AutoPartsOnlineShopApi.entity.Part;
import com.example.AutoPartsOnlineShopApi.entity.PartCategory;
import com.example.AutoPartsOnlineShopApi.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parts")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }


    @GetMapping("/{category}/{model}")
    public List<Part> getPartsByCategoryAndModel(
            @PathVariable PartCategory category,
            @PathVariable(required = false) String model) {
        return partService.getPartsByCategoryAndModel(category, model);
    }

    @GetMapping("/search")
    public List<Part> searchPartsByName(@RequestParam String name) {
        return partService.searchPartsByName(name);
    }
}
