package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.Dto.KullaniciKayitDTO;
import com.example.yemekhaneyonetimsistemi.entity.Kullanici;

import java.util.List;

public interface IKullaniciController {
    public List<Kullanici> getAllKullanici();
    public Kullanici updateKullanici(int id,Kullanici kullanici);
    public Kullanici insertKullanici(KullaniciKayitDTO kullaniciKayitDTO);
    public Kullanici deleteKullanici(int id);
}
