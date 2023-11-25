package com.example.AutoPartsOnlineShopApi.dto.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelRequestDTO {

    @NotBlank(message = "Car model name is required")
    private String name;

    @NotNull(message = "Production year is required")
    @PositiveOrZero(message = "Production year must be a positive or zero value")
    private Integer productionYear;

    @NotBlank(message = "Fuel type is required")
    private String fuelType;

    @NotNull(message = "Engine capacity is required")
    @Positive(message = "Engine capacity must be a positive value")
    private Double engineCapacity;

    private boolean isFourWheelDrive;


}
