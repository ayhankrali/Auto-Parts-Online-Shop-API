package com.example.AutoPartsOnlineShopApi.service;

import com.example.AutoPartsOnlineShopApi.entity.Make;
import com.example.AutoPartsOnlineShopApi.entity.Model;
import com.example.AutoPartsOnlineShopApi.entity.Part;

public interface AdminService {

    Make getMakeById(Long id);

    Model getModelById(Long id);

    void createMake(Make make);

    void createModel(Model model);

    void updateMake(Long id, Make make);

    void updateModel(Long id, Model model);

    void deleteMake(Long id);

    void deleteModel(Long id);

    void createPart(Part part);

    void updatePart(Long id, Part part);

    void deletePart(Long id);
}
