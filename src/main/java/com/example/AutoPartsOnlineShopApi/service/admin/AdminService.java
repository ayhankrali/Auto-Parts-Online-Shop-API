package com.example.AutoPartsOnlineShopApi.service.admin;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import com.example.AutoPartsOnlineShopApi.entity.part.Part;

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
