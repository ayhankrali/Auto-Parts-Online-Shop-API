package com.example.AutoPartsOnlineShopApi.controller.admin;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.entity.model.Model;
import com.example.AutoPartsOnlineShopApi.entity.part.Part;
import com.example.AutoPartsOnlineShopApi.service.admin.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {
    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    @Test
    void getMakeById_ReturnsMake_WhenMakeExists() {
        long makeId = 1L;
        Make mockMake = new Make();
        when(adminService.getMakeById(makeId)).thenReturn(mockMake);

        ResponseEntity<?> response = adminController.getMakeById(makeId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockMake, response.getBody());
    }

    @Test
    void getModelById_ReturnsModel_WhenModelExists() {
        long modelId = 1L;
        Model mockModel = new Model();
        when(adminService.getModelById(modelId)).thenReturn(mockModel);

        ResponseEntity<?> response = adminController.getModelById(modelId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockModel, response.getBody());
    }

    @Test
    void createMake_ReturnsCreatedResponse_WhenMakeIsCreatedSuccessfully() {
        Make mockMake = new Make();

        ResponseEntity<String> response = adminController.createMake(mockMake);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Manufacturer created successfully!", response.getBody());

        verify(adminService).createMake(mockMake);
    }

    @Test
    void createPart_ReturnsCreatedResponse_WhenPartIsCreatedSuccessfully() {
        Part mockPart = new Part();

        ResponseEntity<String> response = adminController.createPart(mockPart);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Part created successfully!", response.getBody());

        verify(adminService).createPart(mockPart);
    }

    @Test
    void updatePart_ReturnsOkResponse_WhenPartIsUpdatedSuccessfully() {
        long partId = 1L;
        Part mockPart = new Part();

        ResponseEntity<String> response = adminController.updatePart(partId, mockPart);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Part updated successfully!", response.getBody());

        verify(adminService).updatePart(partId, mockPart);
    }

    @Test
    void deletePart_ReturnsOkResponse_WhenPartIsDeletedSuccessfully() {
        long partId = 1L;

        ResponseEntity<String> response = adminController.deletePart(partId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Part deleted successfully!", response.getBody());

        verify(adminService).deletePart(partId);
    }

    @Test
    void updateModel_ReturnsOkResponse_WhenModelIsUpdatedSuccessfully() {
        long modelId = 1L;
        Model mockModel = new Model();

        ResponseEntity<String> response = adminController.updateModel(modelId, mockModel);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Car model updated successfully!", response.getBody());

        verify(adminService).updateModel(modelId, mockModel);

    }

    @Test
    void deleteModel_ReturnsOkResponse_WhenModelIsDeletedSuccessfully() {
        long modelId = 1L;

        ResponseEntity<String> response = adminController.deleteModel(modelId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Car model deleted successfully!", response.getBody());

        verify(adminService).deleteModel(modelId);

    }

}
