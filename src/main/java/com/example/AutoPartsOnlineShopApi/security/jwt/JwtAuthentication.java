package com.example.AutoPartsOnlineShopApi.security.jwt;

import com.example.AutoPartsOnlineShopApi.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthentication extends AbstractAuthenticationProcessingFilter {

    private final UserService userService;

    public JwtAuthentication(AuthenticationManager authenticationManager, UserService userService) {
        super("auth/login");
        this.userService = userService;
        setAuthenticationManager(authenticationManager);
    }

   
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            // Handle empty or invalid credentials
            throw new BadCredentialsException("Invalid username or password");
        }

        // Validate credentials and perform authentication
        try {
            Authentication authentication = getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList())
            );

           
            return authentication;
        } catch (AuthenticationException authEx) {
         
            throw new BadCredentialsException("Authentication failed", authEx);
        }
    }

    
}





