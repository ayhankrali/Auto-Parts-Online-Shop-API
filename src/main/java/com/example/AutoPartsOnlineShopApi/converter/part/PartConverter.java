package com.example.AutoPartsOnlineShopApi.converter.part;

import com.example.AutoPartsOnlineShopApi.dto.part.PartRequestDTO;
import com.example.AutoPartsOnlineShopApi.dto.part.PartResponseDTO;
import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.service.model.ModelService;
import com.example.AutoPartsOnlineShopApi.service.partcategory.PartCategoryService;
import com.example.AutoPartsOnlineShopApi.service.part.PartService;
import org.springframework.stereotype.Component;

@Component
public class PartConverter {

    private final PartService partService;
    private final PartCategoryService partCategoryService;
    private final ModelService modelService;

    public PartConverter(PartService partService, PartCategoryService partCategoryService, ModelService modelService) {
        this.partService = partService;
        this.partCategoryService = partCategoryService;
        this.modelService = modelService;
    }


    public Part toEntity(PartRequestDTO partRequestDTO) {
        return Part.builder()
                .name(partRequestDTO.getName())
                .description(partRequestDTO.getDescription())
                .price(partRequestDTO.getPrice())
                .manufacturer(partRequestDTO.getManufacturer())
                .material(partRequestDTO.getMaterial())
                .isAvailable(partRequestDTO.isAvailable())
                .quantityInStock(partRequestDTO.getQuantityInStock())
                .compatibilityInfo(partRequestDTO.getCompatibilityInfo())
                .category(partRequestDTO.getCategory())
                .compatibleModels(partRequestDTO.getCompatibleModels())
                .build();
    }


    public PartResponseDTO toDto(Part part) {
        return PartResponseDTO.builder()
                .id(part.getId())
                .name(part.getName())
                .description(part.getDescription())
                .price(part.getPrice())
                .manufacturer(part.getManufacturer())
                .material(part.getMaterial())
                .isAvailable(part.isAvailable())
                .quantityInStock(part.getQuantityInStock())
                .compatibilityInfo(part.getCompatibilityInfo())
                .category(part.getCategory())
                .compatibleModels(part.getCompatibleModels())
                .build();
    }
}
