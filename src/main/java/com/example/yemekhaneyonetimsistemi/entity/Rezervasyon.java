package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "rezervasyon")
public class Rezervasyon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rezervasyonid")
    private int rezervasyonId;

    @Column(name = "tarih")
    private LocalDate tarih;

    @Column(name = "onaydurumu")
    private boolean onayDurumu;

    @ManyToOne
    @JoinColumn(name = "menu_id",nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "kullaniciid",nullable = false)
    private Kullanici kullanici;

    public int getRezervasyonId() {
        return rezervasyonId;
    }

    public void setRezervasyonId(int rezervasyonId) {
        this.rezervasyonId = rezervasyonId;
    }

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }

    public boolean isOnayDurumu() {
        return onayDurumu;
    }

    public void setOnayDurumu(boolean onayDurumu) {
        this.onayDurumu = onayDurumu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
}
