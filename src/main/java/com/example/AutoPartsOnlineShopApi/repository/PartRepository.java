package com.example.AutoPartsOnlineShopApi.repository;

import com.example.AutoPartsOnlineShopApi.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part,Long> {
}
