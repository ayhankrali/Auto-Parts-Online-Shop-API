package com.example.AutoPartsOnlineShopApi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;

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

    @Column(name = "name")
    @NonNull
    private String name;

    // Country where the car manufacturer is based
    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    // Year the car manufacturer was founded
    @Column(name = "founding_year")
    private Integer foundingYear;

    // Location of the car manufacturer's headquarters
    @Column(name = "headquarters")
    private String headquarters;

    // Indicates if the car manufacturer is a luxury brand
    @Column(name = "is_luxury_brand")
    private boolean isLuxuryBrand;

    // Models associated with this car manufacturer
    @OneToMany(mappedBy = "make")
    private Set<Model> models;

}
