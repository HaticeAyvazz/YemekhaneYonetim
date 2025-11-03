package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "kullanici")
@Inheritance(strategy = InheritanceType.JOINED)
public class Kullanici {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kullaniciid")
    private int kullaniciId;

    @Column(name = "kullaniciad")
    private String kullaniciAdi;

    @Column(name = "kullanicisoyad")
    private String kullaniciSoyadi;

    @Column(name = "sifre")
    private String sifre;


    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciSoyadi() {
        return kullaniciSoyadi;
    }

    public void setKullaniciSoyadi(String kullaniciSoyadi) {
        this.kullaniciSoyadi = kullaniciSoyadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
