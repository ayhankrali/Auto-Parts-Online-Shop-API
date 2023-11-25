package com.example.AutoPartsOnlineShopApi.repository.partcategory;

import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartCategoryRepository extends JpaRepository<PartCategory,Long> {

    PartCategory findByName(String engine_parts);
}
