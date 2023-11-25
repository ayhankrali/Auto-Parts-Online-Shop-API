package com.example.AutoPartsOnlineShopApi.runner;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import com.example.AutoPartsOnlineShopApi.repository.make.MakeRepository;
import com.example.AutoPartsOnlineShopApi.repository.model.ModelRepository;
import com.example.AutoPartsOnlineShopApi.repository.partcategory.PartCategoryRepository;
import com.example.AutoPartsOnlineShopApi.repository.part.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;


@Component
public class ProductDataCommandRunner implements CommandLineRunner {
    // Preserving single responsibility, consolidating runners due to conflicts preventing separation.
    private final MakeRepository makeRepository;
    private final ModelRepository modelRepository;
    private final PartCategoryRepository partCategoryRepository;
    private final PartRepository partRepository;

    @Autowired
    public ProductDataCommandRunner(MakeRepository makeRepository,
                                    ModelRepository modelRepository,
                                    PartCategoryRepository partCategoryRepository,
                                    PartRepository partRepository) {
        this.makeRepository = makeRepository;
        this.modelRepository = modelRepository;
        this.partCategoryRepository = partCategoryRepository;
        this.partRepository = partRepository;
    }

    @Override
    public void run(String... args) {
        // Initialize data for Makes, Models, Part Categories, and Parts
        initMakeModelData();
        initPartCategoryData();
        initPartData();
    }

    private void initMakeModelData() {
        // Initialize data for Makes and Models
        Make make = new Make();
        make.setName("Toyota");
        make.setCountryOfOrigin("Japan");
        make.setFoundingYear(1937);
        make.setHeadquarters("Toyota City, Japan");
        make.setLuxuryBrand(false);

        Model model = new Model();
        model.setName("Camry");
        model.setProductionYear(2022);
        model.setFuelType("Petrol");
        model.setEngineCapacity(2.5);
        model.setFourWheelDrive(false);
        model.setMake(make);

        // Initialize the models set
        make.setModels(new HashSet<>());

        // Add the model to the set
        make.getModels().add(model);

        // Save the entities to the database
        makeRepository.save(make);
        modelRepository.save(model);
    }

    private void initPartCategoryData() {
        // Create a PartCategory entity
        PartCategory partCategory = new PartCategory();
        partCategory.setName("Engine Parts");
        partCategory.setDescription("Parts related to the car engine");
        partCategory.setManufacturer("Various");
        partCategory.setMaterial("Metal");
        partCategory.setOEM(true);
        partCategory.setWeight(10);
        partCategory.setCountryOfOrigin("Various");

        // Save the PartCategory entity to the database
        partCategoryRepository.save(partCategory);
    }

    private void initPartData() {
        // Create a Part entity
        Part part = new Part();
        part.setName("Spark Plug");
        part.setDescription("Ignites the fuel-air mixture in the engine");
        part.setPrice(5.99);
        part.setManufacturer("Bosch");
        part.setMaterial("Metal");
        part.setAvailable(true);
        part.setQuantityInStock(100);
        part.setCompatibilityInfo("Fits various models");


        partRepository.save(part);


    }
}