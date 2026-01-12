package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.auth;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Dto.KullaniciKayitDTO;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IKullaniciService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IKullaniciService kullaniciService;

    // Kayıt İşlemi
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody KullaniciKayitDTO kayitDto) {
        try {
            Kullanici yeniKullanici = kullaniciService.insertKullanici(kayitDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(yeniKullanici);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Kayıt hatası: " + e.getMessage());
        }
    }

    // Giriş İşlemi
    @GetMapping("/me")
    public ResponseEntity<?> login() {
        // Basic Auth başarılı olduktan sonra buraya düşer
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(auth.getPrincipal());
    }
}
