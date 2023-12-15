package com.example.AutoPartsOnlineShopApi.service.model;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import com.example.AutoPartsOnlineShopApi.repository.model.ModelRepository;
import com.example.AutoPartsOnlineShopApi.service.model.impl.ModelServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests for ModelService")
class ModelServiceImplTest {

    @Mock
    private ModelRepository modelRepository;

    @InjectMocks
    private ModelServiceImpl modelService;
    @Test
    @DisplayName("Get All Models - Success")
    void testGetAllModels() {
        // Arrange
        List<Model> mockModels = Collections.singletonList(new Model());
        when(modelRepository.findAll()).thenReturn(mockModels);

        // Act
        List<Model> result = modelService.getAllModels();

        // Assert
        assertEquals(mockModels.size(), result.size());
        assertEquals(mockModels.get(0), result.get(0));
        verify(modelRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Get Model By Id - Success")
    void testGetById() {
        // Arrange
        Long id = 1L;
        Model mockModel = new Model();
        when(modelRepository.findById(id)).thenReturn(Optional.of(mockModel));

        // Act
        Optional<Model> result = modelService.getById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(mockModel, result.get());
        verify(modelRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Get Models By Make - Success")
    void testGetModelsByMake() {
        // Arrange
        Make mockMake = new Make(1L, "Toyota");
        List<Model> mockModels = Collections.singletonList(new Model());
        when(modelRepository.findByMake(mockMake)).thenReturn(mockModels);

        // Act
        List<Model> result = modelService.getModelsByMake(mockMake);

        // Assert
        assertEquals(mockModels.size(), result.size());
        assertEquals(mockModels.get(0), result.get(0));
        verify(modelRepository, times(1)).findByMake(mockMake);
    }
}
