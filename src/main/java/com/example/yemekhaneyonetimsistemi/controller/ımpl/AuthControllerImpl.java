package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IKullaniciService;
import com.example.yemekhaneyonetimsistemi.controller.IAuthController;
import com.example.yemekhaneyonetimsistemi.entity.Kullanici;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthControllerImpl implements IAuthController {

    private final IKullaniciService kullaniciService;

    public AuthControllerImpl(IKullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<Kullanici> register(@RequestBody Kullanici kullanici) {
        // Gelen JSON'daki role göre Service katmanı doğru tabloya kayıt yapacaktır
        Kullanici kaydedilen = kullaniciService.kaydet(kullanici);
        return ResponseEntity.ok(kaydedilen);
    }


    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser() {
        // SecurityContext içinden giriş yapmış kullanıcıyı al
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // CustomUserDetails nesnemizi döndür
        return ResponseEntity.ok(authentication.getPrincipal());
    }


}
