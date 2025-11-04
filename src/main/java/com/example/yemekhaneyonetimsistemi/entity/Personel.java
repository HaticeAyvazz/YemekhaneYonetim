package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personel")
public class Personel extends Kullanici {

    @Column(name="email")
    private String email;

    @Column(name = "telefonnumarasi")
    private String telefonNo;

    @ManyToOne
    @JoinColumn(name = "departman_id",nullable = false)
    private Departman departman;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }
}

