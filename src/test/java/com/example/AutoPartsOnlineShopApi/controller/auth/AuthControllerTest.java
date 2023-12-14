package com.example.AutoPartsOnlineShopApi.controller.auth;

import com.example.AutoPartsOnlineShopApi.entity.user.User;
import com.example.AutoPartsOnlineShopApi.security.jwt.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
    public void testFailedLogin() {
        User loginUser = new User("username", "password");

        when(authenticationManager.authenticate(any()))
                .thenThrow(new RuntimeException("Invalid credentials"));

        ResponseEntity<Map<String, String>> response = authController.login(loginUser);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

        verify(authenticationManager, times(1)).authenticate(any());
    }
}
