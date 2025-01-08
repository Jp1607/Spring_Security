package com.jp.Spring_Security.Security.Configuration;

import com.jp.Spring_Security.Security.Customizer.AuthorizeHTTPRequestsCustomizer;
import com.jp.Spring_Security.Security.Customizer.SessionManagementCustomizer;
import com.jp.Spring_Security.Security.Filters.JWTAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SFCConfiguration {

    SessionManagementCustomizer sessionManagementCustomizer;
    AuthorizeHTTPRequestsCustomizer authorizeHTTPRequestsCustomizer;
    JWTAuthenticationFilter jwtAuthenticationFilter;

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagementCustomizer)
                .authorizeRequests(authorizeHTTPRequestsCustomizer)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class).logout().disable()
                .build();

    }
}
