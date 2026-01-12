package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.auth;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kullanici;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final Kullanici kullanici;

    public CustomUserDetails(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_" + kullanici.getRol().name())
        );
    }

    @Override
    public String getPassword() {
        return kullanici.getSifre();
    }

    @Override
    public String getUsername() {
        return kullanici.getKullaniciAdi();
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

}
