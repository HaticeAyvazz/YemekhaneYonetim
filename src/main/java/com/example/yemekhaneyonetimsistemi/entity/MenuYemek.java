package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menuyemek")
public class MenuYemek {

    @EmbeddedId
    private MenuYemekId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("menuId") // Kompozit anahtardaki 'menuId' alanını kullan
    @JoinColumn(name = "menuıd", nullable = false)
    private Menu menu;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("yemekId") // Kompozit anahtardaki 'yemekId' alanını kullan
    @JoinColumn(name = "yemekıd", nullable = false)
    private Yemek yemek;


    public MenuYemekId getId() {
        return id;
    }

    public void setId(MenuYemekId id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Yemek getYemek() {
        return yemek;
    }

    public void setYemek(Yemek yemek) {
        this.yemek = yemek;
    }

}
