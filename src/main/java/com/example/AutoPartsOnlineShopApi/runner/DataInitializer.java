package com.example.AutoPartsOnlineShopApi.runner;

import com.example.AutoPartsOnlineShopApi.entity.Make;
import com.example.AutoPartsOnlineShopApi.entity.Model;
import com.example.AutoPartsOnlineShopApi.entity.Part;
import com.example.AutoPartsOnlineShopApi.entity.PartCategory;
import com.example.AutoPartsOnlineShopApi.repository.MakeRepository;
import com.example.AutoPartsOnlineShopApi.repository.ModelRepository;
import com.example.AutoPartsOnlineShopApi.repository.PartCategoryRepository;
import com.example.AutoPartsOnlineShopApi.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MakeRepository makeRepository;
    private final ModelRepository modelRepository;
    private final PartCategoryRepository partCategoryRepository;
    private final PartRepository partRepository;

    @Autowired
    public DataInitializer(MakeRepository makeRepository,
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
