package com.example.AutoPartsOnlineShopApi.dto.part;

import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String manufacturer;
    private String material;
    private boolean isAvailable;
    private Integer quantityInStock;
    private String compatibilityInfo;
    private PartCategory category;
    private Set<Model> compatibleModels;

}
