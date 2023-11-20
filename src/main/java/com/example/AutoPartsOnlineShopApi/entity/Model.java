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

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "production_year")
    @NonNull
    private Integer productionYear;

    @Column(name = "fuel_type")
    @NonNull
    private String fuelType;

    @Column(name = "engine_capacity")
    @NonNull
    private Double engineCapacity;

    @Column(name = "is_four_wheel_drive")
    private boolean isFourWheelDrive;

    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;

    @ManyToMany(mappedBy = "compatibleModels")
    private Set<Part> compatibleParts;
}
