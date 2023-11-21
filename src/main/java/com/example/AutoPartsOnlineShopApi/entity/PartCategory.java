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

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "material")
    private String material;

    // Indicates if the parts are Original Equipment Manufacturer
    @Column(name = "is_oem")
    private boolean isOEM;

    // Average weight of parts in this category
    @Column(name = "weight")
    private Integer weight;

    // Country where the parts are manufactured
    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Part> parts;

}
