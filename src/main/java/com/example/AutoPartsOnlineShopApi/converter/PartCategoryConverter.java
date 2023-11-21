package com.example.AutoPartsOnlineShopApi.converter;

import com.example.AutoPartsOnlineShopApi.dto.PartCategoryResponseDTO;
import com.example.AutoPartsOnlineShopApi.entity.PartCategory;
import com.example.AutoPartsOnlineShopApi.service.PartCategoryService;
import org.springframework.stereotype.Component;

@Component
public class PartCategoryConverter {
    private final PartCategoryService partCategoryService;

    public PartCategoryConverter(PartCategoryService partCategoryService) {
        this.partCategoryService = partCategoryService;
    }

    public PartCategoryResponseDTO toDto(PartCategory partCategory) {
        return PartCategoryResponseDTO.builder()
                .id(partCategory.getId())
                .name(partCategory.getName())
                .description(partCategory.getDescription())
                .manufacturer(partCategory.getManufacturer())
                .material(partCategory.getMaterial())
                .isOEM(partCategory.isOEM())
                .weight(partCategory.getWeight())
                .countryOfOrigin(partCategory.getCountryOfOrigin())
                .build();
    }
}
