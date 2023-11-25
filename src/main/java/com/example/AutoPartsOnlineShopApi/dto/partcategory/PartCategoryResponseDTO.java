package com.example.AutoPartsOnlineShopApi.dto.partcategory;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartCategoryResponseDTO {

    private Long id;

    private String name;

    private String description;

    private String manufacturer;

    private String material;

    private boolean isOEM;

    private Integer weight;

    private String countryOfOrigin;


}
