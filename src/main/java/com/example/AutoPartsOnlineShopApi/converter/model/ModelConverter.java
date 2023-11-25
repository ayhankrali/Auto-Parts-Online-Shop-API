package com.example.AutoPartsOnlineShopApi.converter.model;


import com.example.AutoPartsOnlineShopApi.dto.model.ModelRequestDTO;
import com.example.AutoPartsOnlineShopApi.dto.model.ModelResponseDTO;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import com.example.AutoPartsOnlineShopApi.service.model.ModelService;
import org.springframework.stereotype.Component;

@Component
public class ModelConverter {
    private final ModelService modelService;

    public ModelConverter(ModelService modelService) {
        this.modelService = modelService;
    }

    public ModelResponseDTO toDto(Model model) {
        return ModelResponseDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .build();

    }

    public Model toEntity(ModelRequestDTO modelRequestDTO) {
        return Model.builder()
                .name(modelRequestDTO.getName())
                .productionYear(modelRequestDTO.getProductionYear())
                .fuelType(modelRequestDTO.getFuelType())
                .engineCapacity(modelRequestDTO.getEngineCapacity())
                .isFourWheelDrive(modelRequestDTO.isFourWheelDrive())
                .build();
    }


}
