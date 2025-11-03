package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ogrenci")
public class Ogrenci extends Kullanici {

    @Column(name = "ogrencinumarasi")
    private String ogrenciNo;

    @Column(name = "telefonnumarasi")
    private String telefonNo;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "bolum_id",nullable = false)
    private Bolum bolum;


    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }
}
