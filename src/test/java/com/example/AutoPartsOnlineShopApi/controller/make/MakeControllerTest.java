package com.example.AutoPartsOnlineShopApi.controller.make;

import com.example.AutoPartsOnlineShopApi.entity.make.Make;
import com.example.AutoPartsOnlineShopApi.service.make.MakeService;
import org.junit.jupiter.api.DisplayName;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@DisplayName("Make Controller Tests")
public class MakeControllerTest {

    @Mock
    private MakeService makeService;

    @InjectMocks
    private MakeController makeController;

    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /makes should return a list of makes")
    void getAllMakes_shouldReturnListOfMakes() throws Exception {
        // Arrange
        List<Make> makes = Arrays.asList(new Make(1L, "Make1"), new Make(2L, "Make2"));

        // Mock the service method to return the list of makes
        when(makeService.getAllMakes()).thenReturn(makes);

        // Create MockMvc instance
        mockMvc = MockMvcBuilders.standaloneSetup(makeController).build();

        // Act and Assert
        mockMvc.perform(get("/makes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L)) // Check the first make's id
                .andExpect(jsonPath("$[1].id").value(2L)); // Check the second make's id
    }
}
