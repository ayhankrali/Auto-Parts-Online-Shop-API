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
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer productionYear;

    private String fuelType;

    private Double engineCapacity;

    // Indicates if the car model is 4x4
    private boolean isFourWheelDrive;

    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;

    @ManyToMany(mappedBy = "compatibleModels")
    private Set<Part> compatibleParts;
}
