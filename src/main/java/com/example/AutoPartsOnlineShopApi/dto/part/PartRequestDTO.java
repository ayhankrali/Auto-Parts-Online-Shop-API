package com.example.AutoPartsOnlineShopApi.dto.part;

import jakarta.validation.constraints.*;
import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be a positive number")
    private Double price;

    private String manufacturer;

    private String material;

    private boolean isAvailable;

    @NotNull(message = "Quantity in stock is required")
    @PositiveOrZero(message = "Quantity in stock must be a positive number or zero")
    private Integer quantityInStock;

    private String compatibilityInfo;

    @NotNull(message = "Category is required")
    private PartCategory category;

    private Set<Model> compatibleModels;


}
