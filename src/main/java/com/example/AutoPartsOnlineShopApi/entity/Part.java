package com.example.AutoPartsOnlineShopApi.entity;

import ch.qos.logback.core.model.Model;
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
@Table(name = "parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    @NonNull
    private Double price;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "material")
    private String material;

    @Column(name = "is_available")
    private boolean isAvailable;

    // Quantity of the part in stock
    @Column(name = "quantity_in_stock")
    @NonNull
    private Integer quantityInStock;

    // Information about the part's compatibility
    private String compatibilityInfo;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NonNull
    private PartCategory category;

    @ManyToMany
    @JoinTable(
            name = "part_model",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id"))
    @NonNull
    private Set<Model> compatibleModels;


}
