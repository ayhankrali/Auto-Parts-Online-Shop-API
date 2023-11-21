package com.example.AutoPartsOnlineShopApi.converter;


import com.example.AutoPartsOnlineShopApi.dto.ModelResponseDTO;
import com.example.AutoPartsOnlineShopApi.entity.Model;
import com.example.AutoPartsOnlineShopApi.service.ModelService;
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


}
