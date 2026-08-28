package com.ravems.finance_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactivamos esto temporalmente para poder usar Postman/Insomnia
                .authorizeHttpRequests(auth -> auth
                        // AQUÍ VAN NUESTRAS REGLAS DE RUTAS
                        .requestMatchers("/api/users/login","/api/users/register","/api/admin/**").permitAll()
                        .anyRequest().authenticated() // Esto exige login para cualquier otra ruta
                );

        return http.build();
    }
}