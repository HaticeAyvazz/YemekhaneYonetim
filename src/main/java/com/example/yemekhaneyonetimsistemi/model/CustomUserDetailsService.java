package com.example.yemekhaneyonetimsistemi.model;

import com.example.yemekhaneyonetimsistemi.Repository.KullaniciRepository;
import com.example.yemekhaneyonetimsistemi.entity.Kullanici;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final KullaniciRepository kullaniciRepository;

    public CustomUserDetailsService(KullaniciRepository kullaniciRepository) {
        this.kullaniciRepository = kullaniciRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Kullanici kullanici = kullaniciRepository
                .findByKullaniciAdi(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Kullanıcı bulunamadı"));

        return new CustomUserDetails(kullanici);
    }
}
