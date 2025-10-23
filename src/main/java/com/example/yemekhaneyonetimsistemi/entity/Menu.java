package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuid")
    private int menuId;

    @Column(name = "tarih")
    private LocalDate tarih;

    @Column(name = "kayittarihi")
    private LocalDate kayitTarihi;

    @Column(name = "guncellemetarihi")
    private LocalDate guncellenmeTarihi;


    // YENİ İLİŞKİ: Menu'nün içinde Yemekler Listesi
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "menu_yemek", // JPA'nın arka planda oluşturacağı tablonun adı
            joinColumns = @JoinColumn(name = "menu_id"), // Menu tablosu tarafındaki sütun
            inverseJoinColumns = @JoinColumn(name = "yemek_id") // Yemek tablosu tarafındaki sütun
    )
    private List<Yemek> yemekler;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }

    public LocalDate getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(LocalDate kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public LocalDate getGuncellenmeTarihi() {
        return guncellenmeTarihi;
    }

    public void setGuncellenmeTarihi(LocalDate guncellenmeTarihi) {
        this.guncellenmeTarihi = guncellenmeTarihi;
    }

    public List<Yemek> getYemekler() {
        return yemekler;
    }

    public void setYemekler(List<Yemek> yemekler) {
        this.yemekler = yemekler;
    }
}
