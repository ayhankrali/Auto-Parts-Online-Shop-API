package com.example.AutoPartsOnlineShopApi.service.admin;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.repository.make.MakeRepository;
import com.example.AutoPartsOnlineShopApi.repository.model.ModelRepository;
import com.example.AutoPartsOnlineShopApi.repository.part.PartRepository;
import com.example.AutoPartsOnlineShopApi.service.admin.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {

    @Mock
    private MakeRepository makeRepository;

    @Mock
    private ModelRepository modelRepository;

    @Mock
    private PartRepository partRepository;

    @InjectMocks
    private AdminServiceImpl adminService;


    @Test
    void getMakeById_ValidId_ReturnsMake() {
        Long makeId = 1L;
        Make mockMake = new Make(makeId, "Toyota");

        when(makeRepository.findById(makeId)).thenReturn(Optional.of(mockMake));

        Make result = adminService.getMakeById(makeId);

        assertNotNull(result);
        assertEquals(makeId, result.getId());
        assertEquals("Toyota", result.getName());
    }

    @Test
    void getMakeById_InvalidId_ReturnsNull() {
        Long invalidMakeId = 2L;

        when(makeRepository.findById(invalidMakeId)).thenReturn(Optional.empty());

        jakarta.persistence.EntityNotFoundException exception = assertThrows(jakarta.persistence
                .EntityNotFoundException
                .class, () -> {
            Make result = adminService.getMakeById(invalidMakeId);
            assertNull(result);
        });

        assertEquals("Make not found with ID: " + invalidMakeId, exception.getMessage());
    }


    @Test
    void createMake_ValidMake_SaveMake() {
        Make newMake = new Make(null, "Honda");

        adminService.createMake(newMake);

        verify(makeRepository, times(1)).save(newMake);
    }

    @Test
    void createMake_NullMake_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> adminService.createMake(null));
    }

    @Test
    void createModel_ValidModel_SaveModel() {
        Model newModel = new Model(null, "Accord");

        adminService.createModel(newModel);

        verify(modelRepository, times(1)).save(newModel);
    }

    @Test
    void createModel_NullModel_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> adminService.createModel(null));
    }

    @Test
    void updateMake_ValidIdAndMake_UpdateMake() {
        Long makeId = 1L;
        Make updatedMake = new Make(makeId, "UpdatedMake");


        lenient().when(makeRepository.findById(makeId)).thenReturn(Optional.of(new Make(makeId, "OldMake")));

        adminService.updateMake(makeId, updatedMake);

        verify(makeRepository, times(1)).save(updatedMake);
    }

    @Test
    void updateMake_InvalidId_DoesNotUpdateMake() {
        // Arrange
        Long invalidMakeId = 2L;
        Make updatedMake = new Make(invalidMakeId, "UpdatedMake");

        // Simulate that the make with the given ID is not found
        when(makeRepository.findById(invalidMakeId)).thenReturn(Optional.empty());

        // Act
        adminService.updateMake(invalidMakeId, updatedMake);

        // Assert: Verify that save was never called
        verify(makeRepository, never()).save(any(Make.class));
    }


    @Test
    void deleteMake_ValidId_DeleteMake() {
        Long makeId = 1L;

        adminService.deleteMake(makeId);

        verify(makeRepository, times(1)).deleteById(makeId);
    }

    @Test
    void deleteModel_ValidId_DeleteModel() {
        Long modelId = 1L;

        adminService.deleteModel(modelId);

        verify(modelRepository, times(1)).deleteById(modelId);
    }

    @Test
    void createPart_ValidPart_SavePart() {
        Part newPart = new Part(null, "Engine");

        adminService.createPart(newPart);

        verify(partRepository, times(1)).save(newPart);
    }

    @Test
    void createPart_NullPart_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> adminService.createPart(null));
    }

    @Test
    void updatePart_ValidIdAndPart_UpdatePart() {
        // Arrange
        Long partId = 1L;
        Part updatedPart = new Part(String.valueOf(partId), "UpdatedPart");

        // Act
        adminService.updatePart(partId, updatedPart);

        // Assert: Verify that save was called with the updated part
        verify(partRepository).save(updatedPart);

        // Verify that there are no more interactions with the repository
        verifyNoMoreInteractions(partRepository);
    }

    @Test
    void updatePart_InvalidId_DoesNotUpdatePart() {
        // Arrange
        Long invalidPartId = 2L;

        // Simulate that the part with the given ID is not found
        when(partRepository.findById(invalidPartId)).thenReturn(Optional.empty());

        // Act
        adminService.updatePart(invalidPartId, new Part("UpdatedPart", 50.0));

        // Assert: Verify that save was never called
        verify(partRepository, never()).save(any());

        // Verify no more interactions with the repository
        verifyNoMoreInteractions(partRepository);
    }


    @Test
    void deletePart_ValidId_DeletePart() {
        Long partId = 1L;

        adminService.deletePart(partId);

        verify(partRepository, times(1)).deleteById(partId);
    }
}
