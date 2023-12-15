package com.example.AutoPartsOnlineShopApi.security.services;

import com.example.AutoPartsOnlineShopApi.security.jwt.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthorizationFilter authTokenFilter;
    private final AuthenticationProvider authenticationProvider;

    private static final String[] AUTH_WHITELIST = {
            "/v3/api-docs",
            "/v3/api-docs/**",

    };

    @Bean
    public SecurityConfigureAdapter securityConfigureAdapter() {
        return new SecurityConfigureAdapter();
    }

    private class SecurityConfigureAdapter {

        public void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .mvcMatchers("/api/v1/auth/**").permitAll()
                    .mvcMatchers("/api/v1/admin/**").hasRole("ADMIN")
                    .mvcMatchers("/api/v1/user/**").hasRole("USER")
                    .mvcMatchers(AUTH_WHITELIST).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authenticationProvider(authenticationProvider)
                    .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
        }
    }
}
