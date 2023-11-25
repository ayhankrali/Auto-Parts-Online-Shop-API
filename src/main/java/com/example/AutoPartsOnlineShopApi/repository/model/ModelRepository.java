package com.example.AutoPartsOnlineShopApi.repository.model;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Long> {
    List<Model> findByMake(Make make);

    Model findByName(String camry);
}
