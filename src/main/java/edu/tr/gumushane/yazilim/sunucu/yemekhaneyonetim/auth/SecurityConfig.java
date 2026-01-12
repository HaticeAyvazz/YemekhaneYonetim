package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
                        //Kayıt ekranı gerekenler
                        .requestMatchers(HttpMethod.POST,"/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET,"/rest/api/bolum/getAll","/rest/api/departman/getAll","/rest/api/fakulte/getAll").permitAll()

                        //Giriş işlemi
                        .requestMatchers(HttpMethod.GET,"/auth/me").authenticated()

                        //Admin Görevleri
                        .requestMatchers("/rest/api/bolum/**","/rest/api/departman/**","/rest/api/fakulte/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/rest/api/rezervasyon/putUpdate/{id}").hasRole("ADMIN")
                        .requestMatchers("/rest/api/kullanici/**").hasRole("ADMIN")


                        .requestMatchers(HttpMethod.GET,"/rest/api/yemek/get","/rest/api/menu/list","/rest/api/kategori/getAll").hasAnyRole("ADMIN", "OGRENCI", "PERSONEL")
                        .requestMatchers(HttpMethod.POST,"/rest/api/rezervasyon/save").hasAnyRole("ADMIN", "OGRENCI","PERSONEL")
                        .requestMatchers(HttpMethod.PATCH,"/rest/api/rezervasyon/patchUpdate/{id}").hasAnyRole("ADMIN", "OGRENCI","PERSONEL")
                        .requestMatchers(HttpMethod.DELETE,"/rest/api/rezervasyon/delete/{id}").hasAnyRole("ADMIN", "OGRENCI","PERSONEL")
                        .requestMatchers(HttpMethod.GET, "/rest/api/kategori/getAll").hasAnyRole("ADMIN", "PERSONEL", "OGRENCI")

                        //Admin ve Personel
                        .requestMatchers("/rest/api/yemek/**","/rest/api/menu/**","/rest/api/kategori/**").hasAnyRole("ADMIN", "PERSONEL")

                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // Basic Auth (Postman için ideal)

        return http.build();
    }







}