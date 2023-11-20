package com.example.AutoPartsOnlineShopApi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartCategoryRequestDTO {

    @NotBlank(message = "Category name is required")
    private String name;

    private String description;

    private String manufacturer;

    private String material;

    @NotNull(message = "OEM status is required")
    private boolean isOEM;

    @Positive(message = "Weight must be a positive integer")
    private Integer weight;

    private String countryOfOrigin;


}
