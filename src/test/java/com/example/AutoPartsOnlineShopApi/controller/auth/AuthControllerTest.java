package com.example.AutoPartsOnlineShopApi.controller.auth;

import com.example.AutoPartsOnlineShopApi.controller.auth.AuthController;
import com.example.AutoPartsOnlineShopApi.entity.user.User;
import com.example.AutoPartsOnlineShopApi.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthController authController;

    @Test
    void testSignup() {
        // Arrange
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        when(userRepository.existsByUsername("testUser")).thenReturn(false);
        when(passwordEncoder.encode("testPassword")).thenReturn("encodedPassword");

        // Act
        ResponseEntity<Map<String, String>> response = authController.signup(user);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("User registered successfully!", Objects.requireNonNull(response.getBody()).get("message"));
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testSignupUsernameTaken() {
        // Arrange
        User user = new User();
        user.setUsername("existingUser");
        user.setPassword("testPassword");

        when(userRepository.existsByUsername("existingUser")).thenReturn(true);

        // Act
        ResponseEntity<Map<String, String>> response = authController.signup(user);

        // Assert
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Username is already taken", Objects.requireNonNull(response.getBody()).get("error"));
        verify(userRepository, never()).save(user);
    }


}
