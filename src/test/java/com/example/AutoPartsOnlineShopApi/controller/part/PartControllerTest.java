package com.example.AutoPartsOnlineShopApi.controller.part;

import com.example.AutoPartsOnlineShopApi.controller.part.PartController;
import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import com.example.AutoPartsOnlineShopApi.service.part.PartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PartControllerTest {

    @Mock
    private PartService partService;

    @InjectMocks
    private PartController partController;



    @Test
    public void getAllParts_shouldReturnAllParts() throws Exception {
        // Arrange
        List<Part> parts = Arrays.asList(
                new Part(1L, "Part1", "Description1", 50.0, "Manufacturer1", "Material1", true, 10, "Compatibility1", new PartCategory(), null),
                new Part(2L, "Part2", "Description2", 75.0, "Manufacturer2", "Material2", true, 20, "Compatibility2", new PartCategory(), null)
        );
        when(partService.getAllParts()).thenReturn(parts);

        // Act & Assert
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(partController).build();
        mockMvc.perform(get("/parts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(parts.size()));
    }

    @Test
    void getPartsByCategoryAndModel_ShouldReturnPartsByCategoryAndModel() throws Exception {
        // Arrange
        PartCategory category = new PartCategory(1L, "Category1");  // Replace with actual PartCategory details
        String model = "Model1";
        List<Part> parts = Arrays.asList(
                new Part(1L, "Part1", "Description1", 50.0, "Manufacturer1", "Material1", true, 10, "Compatibility1", category, null),
                new Part(2L, "Part2", "Description2", 75.0, "Manufacturer2", "Material2", true, 20, "Compatibility2", category, null)
        );
        when(partService.getPartsByCategoryAndModel(eq(category), eq(model))).thenReturn(parts);

        // Act & Assert
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(partController).build();
        mockMvc.perform(get("/parts/{categoryId}", category.getId())  // Use the identifier property, e.g., id
                        .param("model", model))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(parts.size()));
    }






    @Test
    public void searchPartsByName_shouldReturnMatchingParts() throws Exception {
        // Arrange
        String partName = "PartName";
        List<Part> parts = Arrays.asList(
                new Part(1L, partName, "Description1", 50.0, "Manufacturer1", "Material1", true, 10, "Compatibility1", new PartCategory(), null),
                new Part(2L, partName, "Description2", 75.0, "Manufacturer2", "Material2", true, 20, "Compatibility2", new PartCategory(), null)
        );
        when(partService.searchPartsByName(partName)).thenReturn(parts);

        // Act & Assert
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(partController).build();
        mockMvc.perform(get("/parts/search").param("name", partName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(parts.size()));
    }

  }

