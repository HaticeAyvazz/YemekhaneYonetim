package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "fakulte")
public class Fakulte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fakulteid")
    private int fakulteId;

    @Column(name = "fakultead")
    private String fakulteAdi;


    public int getFakulteId() {
        return fakulteId;
    }

    public void setFakulteId(int fakulteId) {
        this.fakulteId = fakulteId;
    }

    public String getFakulteAdi() {
        return fakulteAdi;
    }

    public void setFakulteAdi(String fakulteAdi) {
        this.fakulteAdi = fakulteAdi;
    }
}
