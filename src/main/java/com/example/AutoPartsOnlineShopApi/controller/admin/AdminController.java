package com.example.AutoPartsOnlineShopApi.controller.admin;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/makes/{id}")
    public ResponseEntity<?> getMakeById(@PathVariable Long id) {
        Make make = adminService.getMakeById(id);
        return make != null
                ? ResponseEntity.ok(make)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manufacturer not found");
    }

    @GetMapping("/models/{id}")
    public ResponseEntity<?> getModelById(@PathVariable Long id) {
        Model model = adminService.getModelById(id);
        return model != null
                ? ResponseEntity.ok(model)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car model not found");
    }

    @PostMapping("/makes")
    public ResponseEntity<String> createMake(@RequestBody Make make) {
        adminService.createMake(make);
        return ResponseEntity.status(HttpStatus.CREATED).body("Manufacturer created successfully!");
    }

    @PostMapping("/models")
    public ResponseEntity<String> createModel(@RequestBody Model model) {
        adminService.createModel(model);
        return ResponseEntity.status(HttpStatus.CREATED).body("Car model created successfully!");
    }

    @PutMapping("/makes/{id}")
    public ResponseEntity<String> updateMake(@PathVariable Long id, @RequestBody Make make) {
        adminService.updateMake(id, make);
        return ResponseEntity.ok("Manufacturer updated successfully!");
    }

    @PutMapping("/models/{id}")
    public ResponseEntity<String> updateModel(@PathVariable Long id, @RequestBody Model model) {
        adminService.updateModel(id, model);
        return ResponseEntity.ok("Car model updated successfully!");
    }

    @DeleteMapping("/makes/{id}")
    public ResponseEntity<String> deleteMake(@PathVariable Long id) {
        adminService.deleteMake(id);
        return ResponseEntity.ok("Manufacturer deleted successfully!");
    }

    @DeleteMapping("/models/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable Long id) {
        adminService.deleteModel(id);
        return ResponseEntity.ok("Car model deleted successfully!");
    }

    @PostMapping("/parts")
    public ResponseEntity<String> createPart(@RequestBody Part part) {
        adminService.createPart(part);
        return ResponseEntity.status(HttpStatus.CREATED).body("Part created successfully!");
    }

    @PutMapping("/parts/{id}")
    public ResponseEntity<String> updatePart(@PathVariable Long id, @RequestBody Part part) {
        adminService.updatePart(id, part);
        return ResponseEntity.ok("Part updated successfully!");
    }

    @DeleteMapping("/parts/{id}")
    public ResponseEntity<String> deletePart(@PathVariable Long id) {
        adminService.deletePart(id);
        return ResponseEntity.ok("Part deleted successfully!");
    }
}
