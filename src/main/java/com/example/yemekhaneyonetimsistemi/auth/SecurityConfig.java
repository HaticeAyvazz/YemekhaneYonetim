package com.example.yemekhaneyonetimsistemi.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService); // EntityManager kullanan servis
        provider.setPasswordEncoder(passwordEncoder()); // Hash kontrolü yapan encoder
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf-> csrf.disable()) // Postman testleri için kapalı
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register", "/auth/me").permitAll() // Kayıt ve Login serbest
                        .requestMatchers("/rest/api/kullanici/**").permitAll()
                        .requestMatchers("rest/api/kategori/**").permitAll()
                        .requestMatchers("rest/api/rezervasyon/**").permitAll()
                        .requestMatchers("/rest/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("rest/api/fakulte/**").permitAll()
                        .requestMatchers("rest/api/menu/**").permitAll()
                        .requestMatchers("rest/api/bolum/**").hasRole("OGRENCI")
                        .requestMatchers("rest/api/departman/**").permitAll()
                        .requestMatchers("/rest/api/ogrenci/**").permitAll()
                        .requestMatchers("/rest/api/personel/**").hasAnyRole("ADMIN", "PERSONEL")
                        .requestMatchers("rest/api/yemek/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // Basic Auth (Postman için ideal)

        return http.build();
    }







}