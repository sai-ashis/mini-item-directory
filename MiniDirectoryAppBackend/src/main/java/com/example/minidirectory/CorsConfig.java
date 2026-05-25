package com.example.minidirectory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // ALLOW CREDENTIALS (Cookies, Auth Headers)
        config.setAllowCredentials(true);
        
        // EXACT VERCEL FRONTEND URL (No trailing slash)
        config.setAllowedOrigins(Collections.singletonList("https://mini-item-directory.vercel.app"));
        
        // ALLOW ALL STANDARD HEADERS
        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization", "X-Requested-With"));
        
        // ALLOW ALL METHODS
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        
        // Apply this configuration to ALL paths
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}