package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "bolum")
public class Bolum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bolumıd")
    private int bolumId;

    @Column(name = "bolumad")
    private String bolumAdi;

    @ManyToOne
    @JoinColumn(name = "fakulte_id",nullable = false)
    private Fakulte fakulte;

    public int getBolumId() {
        return bolumId;
    }

    public void setBolumId(int bolumId) {
        this.bolumId = bolumId;
    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    public Fakulte getFakulte() {
        return fakulte;
    }

    public void setFakulte(Fakulte fakulte) {
        this.fakulte = fakulte;
    }
}
