package com.example.AutoPartsOnlineShopApi.dto.make;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MakeRequestDTO {

    @NotBlank(message = "Manufacturer name is required")
    private String name;

    private String countryOfOrigin;

    @PositiveOrZero(message = "Founding year must be a positive or zero value")
    private Integer foundingYear;

    private String headquarters;

    private boolean isLuxuryBrand;


}
