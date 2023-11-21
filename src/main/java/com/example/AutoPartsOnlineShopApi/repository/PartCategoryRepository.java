package com.example.AutoPartsOnlineShopApi.repository;

import com.example.AutoPartsOnlineShopApi.entity.PartCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartCategoryRepository extends JpaRepository<PartCategory,Long> {

    PartCategory findByName(String engine_parts);
}
