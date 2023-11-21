package com.example.AutoPartsOnlineShopApi.converter;

import com.example.AutoPartsOnlineShopApi.dto.MakeRequestDTO;
import com.example.AutoPartsOnlineShopApi.dto.MakeResponseDTO;
import com.example.AutoPartsOnlineShopApi.entity.Make;
import com.example.AutoPartsOnlineShopApi.service.MakeService;
import org.springframework.stereotype.Component;

@Component
public class MakeConverter {
    private final MakeService makeService;

    public MakeConverter(MakeService makeService) {
        this.makeService = makeService;
    }

    public MakeResponseDTO toDto(Make make) {
        return MakeResponseDTO.builder()
                .id(make.getId())
                .name(make.getName())
                .build();
    }

    public Make toEntity(MakeRequestDTO makeRequestDTO) {
        return Make.builder()
                .name(makeRequestDTO.getName())
                .countryOfOrigin(makeRequestDTO.getCountryOfOrigin())
                .foundingYear(makeRequestDTO.getFoundingYear())
                .headquarters(makeRequestDTO.getHeadquarters())
                .isLuxuryBrand(makeRequestDTO.isLuxuryBrand())
                .build();
    }


}
