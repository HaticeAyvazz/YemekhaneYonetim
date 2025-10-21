package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personel")
public class Personel {

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

    @Column(name="email")
    private String email;

    @Column(name = "telefonnumarasi")
    private String telefonNo;

    @ManyToOne
    @JoinColumn(name = "departman_id",nullable = false)
    private Departman departman;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }
}

