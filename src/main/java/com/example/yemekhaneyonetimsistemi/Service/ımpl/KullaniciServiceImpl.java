package com.example.yemekhaneyonetimsistemi.Service.ımpl;


import com.example.yemekhaneyonetimsistemi.Repository.ımpl.KullaniciRepositoryImpl;
import com.example.yemekhaneyonetimsistemi.Service.IKullaniciService;
import com.example.yemekhaneyonetimsistemi.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KullaniciServiceImpl implements IKullaniciService {

    @PersistenceContext
    private EntityManager entityManager;


    private final KullaniciRepositoryImpl kullaniciRepository;
    private final PasswordEncoder passwordEncoder;

    public KullaniciServiceImpl(KullaniciRepositoryImpl kullaniciRepository, PasswordEncoder passwordEncoder) {
        this.kullaniciRepository = kullaniciRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Kullanici kaydet(Kullanici kullanici) {
        // 1. Şifreyi her durumda hashliyoruz
        String encodedPass = passwordEncoder.encode(kullanici.getSifre());

        // 2. Rol tipine göre doğru Entity nesnesini oluştur ve kaydet
        if (kullanici.getRole() == Role.ADMIN) {
            Admin admin = new Admin();
            mapBaseProperties(kullanici, admin);
            admin.setSifre(encodedPass);
            return kullaniciRepository.save(admin);
        }

        else if (kullanici instanceof Ogrenci sourceOgrenci) {
            Ogrenci hedefOgrenci = new Ogrenci();
            mapBaseProperties(sourceOgrenci, hedefOgrenci);

            // Öğrenciye özel alanları eşle
            hedefOgrenci.setOgrenciNo(sourceOgrenci.getOgrenciNo());
            hedefOgrenci.setTelefonNo(sourceOgrenci.getTelefonNo());
            hedefOgrenci.setEmail(sourceOgrenci.getEmail());
            hedefOgrenci.setBolum(sourceOgrenci.getBolum()); // Cascade burada devreye girer

            hedefOgrenci.setSifre(encodedPass);
            return kullaniciRepository.save(hedefOgrenci);
        }

        else if (kullanici instanceof Personel sourcePersonel) {
            Personel hedefPersonel = new Personel();
            mapBaseProperties(sourcePersonel, hedefPersonel);

            // Personele özel alanları eşle
            hedefPersonel.setEmail(sourcePersonel.getEmail());
            hedefPersonel.setTelefonNo(sourcePersonel.getTelefonNo());
            hedefPersonel.setDepartman(sourcePersonel.getDepartman());

            hedefPersonel.setSifre(encodedPass);
            return kullaniciRepository.save(hedefPersonel);
        }

        // Eğer doğrudan Kullanici nesnesi geldiyse (Fallback)
        kullanici.setSifre(encodedPass);
        return kullaniciRepository.save(kullanici);
    }

    // Ortak alanları (ad, soyad, rol) kopyalayan yardımcı metod
    private void mapBaseProperties(Kullanici source, Kullanici target) {
        target.setKullaniciAdi(source.getKullaniciAdi());
        target.setKullaniciSoyadi(source.getKullaniciSoyadi());
        target.setRole(source.getRole());
    }



    }

