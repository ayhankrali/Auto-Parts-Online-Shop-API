package com.example.AutoPartsOnlineShopApi.repository;

import com.example.AutoPartsOnlineShopApi.entity.Make;
import com.example.AutoPartsOnlineShopApi.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Long> {
    List<Model> findByMake(Make make);

    Model findByName(String camry);
}
