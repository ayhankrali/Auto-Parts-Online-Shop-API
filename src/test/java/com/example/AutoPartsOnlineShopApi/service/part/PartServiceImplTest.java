package com.example.AutoPartsOnlineShopApi.service.part;

import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import com.example.AutoPartsOnlineShopApi.repository.part.PartRepository;
import com.example.AutoPartsOnlineShopApi.service.part.impl.PartServiceImpl;
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
class PartServiceImplTest {

    @Mock
    private PartRepository partRepository;

    @InjectMocks
    private PartServiceImpl partService;


    @Test
    void testGetAllParts() {
        // Arrange
        List<Part> mockParts = Collections.singletonList(new Part());
        when(partRepository.findAll()).thenReturn(mockParts);

        // Act
        List<Part> result = partService.getAllParts();

        // Assert
        assertEquals(mockParts.size(), result.size());
        assertEquals(mockParts.get(0), result.get(0));
        verify(partRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Long id = 1L;
        Part mockPart = new Part();
        when(partRepository.findById(id)).thenReturn(Optional.of(mockPart));

        // Act
        Optional<Part> result = partService.getById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(mockPart, result.get());
        verify(partRepository, times(1)).findById(id);
    }

    @Test
    void testGetPartsByCategoryAndModel() {
        // Arrange
        PartCategory mockCategory = new PartCategory();
        String mockModel = "MockModel";
        List<Part> mockParts = Collections.singletonList(new Part());
        when(partRepository.findByCategoryAndCompatibleModelsName(mockCategory, mockModel)).thenReturn(mockParts);

        // Act
        List<Part> result = partService.getPartsByCategoryAndModel(mockCategory, mockModel);

        // Assert
        assertEquals(mockParts.size(), result.size());
        assertEquals(mockParts.get(0), result.get(0));
        verify(partRepository, times(1)).findByCategoryAndCompatibleModelsName(mockCategory, mockModel);
    }

    @Test
    void testSearchPartsByName() {
        // Arrange
        String partName = "MockPart";
        List<Part> mockParts = Collections.singletonList(new Part());
        when(partRepository.findByNameContainingIgnoreCase(partName)).thenReturn(mockParts);

        // Act
        List<Part> result = partService.searchPartsByName(partName);

        // Assert
        assertEquals(mockParts.size(), result.size());
        assertEquals(mockParts.get(0), result.get(0));
        verify(partRepository, times(1)).findByNameContainingIgnoreCase(partName);
    }
}
