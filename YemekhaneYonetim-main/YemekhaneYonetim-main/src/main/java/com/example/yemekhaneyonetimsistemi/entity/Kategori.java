package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "kategori")
public class Kategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kategoriid")
    private int kategoriId;

    @Column(name = "kategoriad")
    private String kategoriAd;

    @Column(name = "tip")
    private String tip;

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriAd() {
        return kategoriAd;
    }

    public void setKategoriAd(String kategoriAd) {
        this.kategoriAd = kategoriAd;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

}
