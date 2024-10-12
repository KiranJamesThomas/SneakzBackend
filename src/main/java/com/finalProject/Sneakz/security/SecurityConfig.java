package com.finalProject.Sneakz.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/Sneakz/auth/login", "/Sneakz/auth/register").permitAll() // Allow access to login and registration
                        .anyRequest().authenticated() // Secure all other routes
                )
                .formLogin(form -> form
                        .loginPage("/Sneakz/auth/login") // Custom login page
                        .permitAll() // Allow all to access login page
                )
                .logout(LogoutConfigurer::permitAll // Allow all to logout
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
