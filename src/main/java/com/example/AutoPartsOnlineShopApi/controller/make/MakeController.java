package com.example.AutoPartsOnlineShopApi.controller.make;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.service.make.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/makes")
public class MakeController {
    private final MakeService makeService;

    @Autowired
    public MakeController(MakeService makeService) {
        this.makeService = makeService;
    }

    @GetMapping
    public List<Make> getAllMakes() {
        return makeService.getAllMakes();
    }
}
