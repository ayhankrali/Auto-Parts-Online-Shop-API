package com.example.AutoPartsOnlineShopApi.converter.partcategory;

import com.example.AutoPartsOnlineShopApi.dto.partcategory.PartCategoryRequestDTO;
import com.example.AutoPartsOnlineShopApi.dto.partcategory.PartCategoryResponseDTO;
import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import com.example.AutoPartsOnlineShopApi.service.partcategory.PartCategoryService;
import org.springframework.stereotype.Component;

@Component
public class PartCategoryConverter {
    private final PartCategoryService partCategoryService;

    public PartCategoryConverter(PartCategoryService partCategoryService) {
        this.partCategoryService = partCategoryService;
    }


    public PartCategory toEntity(PartCategoryRequestDTO requestDTO) {
        return PartCategory.builder()
                .name(requestDTO.getName())
                .description(requestDTO.getDescription())
                .manufacturer(requestDTO.getManufacturer())
                .material(requestDTO.getMaterial())
                .isOEM(requestDTO.isOEM())
                .weight(requestDTO.getWeight())
                .countryOfOrigin(requestDTO.getCountryOfOrigin())
                .build();
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
