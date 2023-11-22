package com.example.AutoPartsOnlineShopApi.controller;

import com.example.AutoPartsOnlineShopApi.entity.Make;
import com.example.AutoPartsOnlineShopApi.entity.Model;
import com.example.AutoPartsOnlineShopApi.service.ModelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ModelControllerTest {

    @Mock
    private ModelService modelService;
    @InjectMocks
    private ModelController modelController;

    @Test
    public void getAllModels_shouldReturnListOfModels() throws Exception {
        // Arrange
        List<Model> models = Arrays.asList(new Model(1L, "Model1"), new Model(2L, "Model2"));
        when(modelService.getAllModels()).thenReturn(models);

        // Act & Assert
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(modelController).build();
        mockMvc.perform(get("/models"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(models.size()));
    }
    @Test
    public void getAllModels_shouldReturnAllModels() throws Exception {
        // Arrange
        List<Model> models = Arrays.asList(new Model(1L, "Model1"), new Model(2L, "Model2"));
        when(modelService.getAllModels()).thenReturn(models);

        // Act & Assert
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(modelController).build();
        mockMvc.perform(get("/models"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(models.size()));
    }




}
