package com.example.AutoPartsOnlineShopApi.controller.auth;

import com.example.AutoPartsOnlineShopApi.entity.user.User;
import com.example.AutoPartsOnlineShopApi.security.jwt.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
@DisplayName("AuthController Tests")
public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Successful Login")
    public void testSuccessfulLogin() {
        User loginUser = new User("username", "password");
        Authentication authentication = mock(Authentication.class);

        when(authenticationManager.authenticate(any()))
                .thenReturn(authentication);

        when(jwtTokenProvider.generateToken(authentication))
                .thenReturn("generated_token");

        ResponseEntity<Map<String, String>> response = authController.login(loginUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Bearer generated_token", Objects.requireNonNull(response.getBody()).get("Authorization"));

        verify(authenticationManager, times(1)).authenticate(any());
        verify(jwtTokenProvider, times(1)).generateToken(authentication);
    }


    @Test
    @DisplayName("Failed Login")
    void testFailedLogin() {
        when(authenticationManager.authenticate(any()))
                .thenThrow(new AuthenticationException("Invalid credentials") {
                });

        // Use assertThrows to verify the exception
        AuthenticationException exception = assertThrows(AuthenticationException.class, () -> {
            ResponseEntity<Map<String, String>> response = authController.login(new User("username", "password"));
        });

        // Verify that the exception has the expected message
        assertEquals("Invalid credentials", exception.getMessage());

        verify(authenticationManager, times(1)).authenticate(any());
    }


}
