package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

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

}
