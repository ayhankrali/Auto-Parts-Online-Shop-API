package com.example.AutoPartsOnlineShopApi.controller.part;

import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import com.example.AutoPartsOnlineShopApi.service.part.PartService;
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


    @GetMapping("/{category}")
    public List<Part> getPartsByCategoryAndModel(
            @PathVariable PartCategory category,
            @RequestParam(required = false) String model) {
        return partService.getPartsByCategoryAndModel(category, model);
    }


    @GetMapping("/search")
    public List<Part> searchPartsByName(@RequestParam String name) {
        return partService.searchPartsByName(name);
    }
}
