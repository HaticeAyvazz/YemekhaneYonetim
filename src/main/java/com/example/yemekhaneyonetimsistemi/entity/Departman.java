package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departman")
public class Departman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmanid")
    private int departmanId;

    @Column(name = "departmanadi")
    private String departmanAdi;

    public int getDepartmanId() {
        return departmanId;
    }

    public void setDepartmanId(int departmanId) {
        this.departmanId = departmanId;
    }

    public String getDepartmanAdi() {
        return departmanAdi;
    }

    public void setDepartmanAdi(String departmanAdi) {
        this.departmanAdi = departmanAdi;
    }
}
