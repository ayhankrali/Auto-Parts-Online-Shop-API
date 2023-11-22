package com.example.AutoPartsOnlineShopApi.security.jwt;

import com.example.AutoPartsOnlineShopApi.security.SecurityConstants;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // Builder pattern for creating JwtAuthorizationFilter instances.
    public static JwtAuthorizationFilterBuilder builder() {
        return new JwtAuthorizationFilterBuilder();
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        // Extract the JWT token from the request header.
        String header = request.getHeader(SecurityConstants.HEADER_STRING);

        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            // If no token is present, continue with the filter chain.
            chain.doFilter(request, response);
            return;
        }

        // Extract the token from the header.
        String token = header.replace(SecurityConstants.TOKEN_PREFIX, "");

        // Extract the username from the JWT token.
        String username = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // If a valid username is present and no authentication exists, create an authentication token.
            PreAuthenticatedAuthenticationToken authenticationToken =
                    JwtAuthorizationFilter.builder().withUsername(username).build();

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // Set the authentication in the security context.
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        // Continue with the filter chain.
        chain.doFilter(request, response);
    }

    // Builder class for constructing PreAuthenticatedAuthenticationToken instances.
    public static class JwtAuthorizationFilterBuilder {
        private String username;

        // Set the username for the authentication token.
        public JwtAuthorizationFilterBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        // Build the PreAuthenticatedAuthenticationToken instance.
        public PreAuthenticatedAuthenticationToken build() {
            return new PreAuthenticatedAuthenticationToken(username, null, null);
        }
    }


}
