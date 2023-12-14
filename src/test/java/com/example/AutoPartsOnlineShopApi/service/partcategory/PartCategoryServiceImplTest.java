package com.example.AutoPartsOnlineShopApi.service.partcategory;

import com.example.AutoPartsOnlineShopApi.entity.partcategory.PartCategory;
import com.example.AutoPartsOnlineShopApi.repository.partcategory.PartCategoryRepository;
import com.example.AutoPartsOnlineShopApi.service.partcategory.impl.PartCategoryServiceImpl;
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
class PartCategoryServiceImplTest {

    @Mock
    private PartCategoryRepository partCategoryRepository;

    @InjectMocks
    private PartCategoryServiceImpl partCategoryService;


    @Test
    void testGetAllPartCategories() {
        // Arrange
        List<PartCategory> mockCategories = Collections.singletonList(new PartCategory());
        when(partCategoryRepository.findAll()).thenReturn(mockCategories);

        // Act
        List<PartCategory> result = partCategoryService.getAllPartCategories();

        // Assert
        assertEquals(mockCategories.size(), result.size());
        assertEquals(mockCategories.get(0), result.get(0));
        verify(partCategoryRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Long id = 1L;
        PartCategory mockCategory = new PartCategory();
        when(partCategoryRepository.findById(id)).thenReturn(Optional.of(mockCategory));

        // Act
        Optional<PartCategory> result = partCategoryService.getById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(mockCategory, result.get());
        verify(partCategoryRepository, times(1)).findById(id);
    }
}
