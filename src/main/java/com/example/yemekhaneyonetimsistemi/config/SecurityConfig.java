package com.example.yemekhaneyonetimsistemi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http
            // Cross-Site Request Forgery (CSRF) korumasını kapatıyoruz
            .csrf(AbstractHttpConfigurer::disable)
            
            // İstek Yetkilendirme Kurallarını Tanımlama
            .authorizeHttpRequests(auth -> auth
                // 🛑 KRİTİK ADIM: Tüm istekleri yetkilendirme zorunluluğundan muaf tutun.
                .anyRequest().permitAll() 
            );

        // JWT, Basic Auth veya Session filtreleri olmadığı için başka bir şey eklemeye gerek yok.

        return http.build();
    }
}
