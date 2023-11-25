package com.example.AutoPartsOnlineShopApi.repository.make;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MakeRepository extends JpaRepository<Make,Long> {
    Optional<Object> findByName(String toyota);
}
