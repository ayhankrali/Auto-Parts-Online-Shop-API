package com.example.AutoPartsOnlineShopApi.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "makes")
public class Make {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Country where the car manufacturer is based
    private String countryOfOrigin;

    // Year the car manufacturer was founded
    private Integer foundingYear;

    // Location of the car manufacturer's headquarters
    private String headquarters;

    // Indicates if the car manufacturer is a luxury brand
    private boolean isLuxuryBrand;

}
