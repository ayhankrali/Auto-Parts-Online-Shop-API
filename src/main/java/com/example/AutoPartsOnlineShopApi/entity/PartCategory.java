package com.example.AutoPartsOnlineShopApi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "part_categories")
public class PartCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    // Manufacturer of the part category
    private String manufacturer;

    // Material of the parts in this category
    private String material;

    // Indicates if the parts are Original Equipment Manufacturer
    private boolean isOEM;

    // Average weight of parts in this category
    private Integer weight;

    // Country where the parts are manufactured
    private String countryOfOrigin;

    @OneToMany(mappedBy = "category")
    private Set<Part> parts;
}
