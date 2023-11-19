package com.example.AutoPartsOnlineShopApi.entity.partcategory;

import ch.qos.logback.core.model.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private String manufacturer;

    private String material;

    private boolean isAvailable;

    // Quantity of the part in stock
    private Integer quantityInStock;

    // Information about the part's compatibility
    private String compatibilityInfo;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private PartCategory category;

    @ManyToMany
    @JoinTable(
            name = "part_model",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id"))
    private Set<Model> compatibleModels;


}
