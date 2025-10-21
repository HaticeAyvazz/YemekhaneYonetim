package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "yemek")
public class Yemek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "yemekid")
    private int yemekId;

    @Column(name = "yemekad")
    private String yemekAdi;

    @Column(name = "aciklama")
    private String aciklama;

    @Column(name = "ucret")
    private BigDecimal ucret;

    @ManyToOne
    @JoinColumn(name = "kategori_id",nullable = false)
    private Kategori kategori;

    public int getYemekId() {
        return yemekId;
    }

    public void setYemekId(int yemekId) {
        this.yemekId = yemekId;
    }

    public String getYemekAdi() {
        return yemekAdi;
    }

    public void setYemekAdi(String yemekAdi) {
        this.yemekAdi = yemekAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public BigDecimal getUcret() {
        return ucret;
    }

    public void setUcret(BigDecimal ucret) {
        this.ucret = ucret;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
}
