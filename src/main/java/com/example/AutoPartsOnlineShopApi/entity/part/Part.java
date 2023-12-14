package com.example.AutoPartsOnlineShopApi.entity.part;


import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
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
    private Set<Model> compatibleModels;


    // Custom Constructors

    // Constructor for a part with only the name and price
    public Part(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Constructor for a part with all fields except the ID
    public Part(String name, String description, Double price, String manufacturer, String material,
                boolean isAvailable, Integer quantityInStock, String compatibilityInfo,
                PartCategory category, Set<Model> compatibleModels) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
        this.material = material;
        this.isAvailable = isAvailable;
        this.quantityInStock = quantityInStock;
        this.compatibilityInfo = compatibilityInfo;
        this.category = category;
        this.compatibleModels = compatibleModels;
    }

    public Part(String name, String engine) {

    }
}
