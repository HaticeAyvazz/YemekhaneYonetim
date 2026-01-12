package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.Dto.KullaniciKayitDTO;
import com.example.yemekhaneyonetimsistemi.entity.Kullanici;
import com.example.yemekhaneyonetimsistemi.entity.Yemek;

import java.util.List;

public interface IKullaniciService {
    public List<Kullanici> getAllKullanici();
    public Kullanici updateKullanici(int id, Kullanici kullanici);
    public Kullanici insertKullanici(KullaniciKayitDTO kullaniciKayitDTO);
    public Kullanici deleteKullanici(int id);
    public Kullanici fullUpdate(int id, Kullanici kullanici);
}
