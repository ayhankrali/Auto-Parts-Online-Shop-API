package com.example.AutoPartsOnlineShopApi.repository;

import com.example.AutoPartsOnlineShopApi.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part,Long> {

    List<Part> findByCategoryAndCompatibleModelsName(String category, String model);

    List<Part> findByNameContainingIgnoreCase(String name);
}
