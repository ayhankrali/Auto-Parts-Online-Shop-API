package com.example.AutoPartsOnlineShopApi.service.make;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.repository.make.MakeRepository;
import com.example.AutoPartsOnlineShopApi.service.impl.MakeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MakeServiceImplTest {

    @Mock
    private MakeRepository makeRepository;

    @InjectMocks
    private MakeServiceImpl makeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllMakes() {
        // Arrange
        List<Make> mockMakes = Collections.singletonList(new Make());
        when(makeRepository.findAll()).thenReturn(mockMakes);

        // Act
        List<Make> result = makeService.getAllMakes();

        // Assert
        assertEquals(mockMakes.size(), result.size());
        assertEquals(mockMakes.get(0), result.get(0));
        verify(makeRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Long id = 1L;
        Make mockMake = new Make();
        when(makeRepository.findById(id)).thenReturn(Optional.of(mockMake));

        // Act
        Optional<Make> result = makeService.getById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(mockMake, result.get());
        verify(makeRepository, times(1)).findById(id);
    }
}
