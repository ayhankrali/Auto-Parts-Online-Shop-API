package com.example.AutoPartsOnlineShopApi.repository.part;

import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {

    List<Part> findByCategoryAndCompatibleModelsName(PartCategory category, String model);


    List<Part> findByNameContainingIgnoreCase(String name);
}

