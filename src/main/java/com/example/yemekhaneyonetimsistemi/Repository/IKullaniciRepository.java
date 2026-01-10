package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Kullanici;
import org.springframework.transaction.annotation.Transactional;

public interface IKullaniciRepository {

    Kullanici save(Kullanici kullanici);
    Kullanici findByKullaniciAdi(String kullaniciAdi);
}
