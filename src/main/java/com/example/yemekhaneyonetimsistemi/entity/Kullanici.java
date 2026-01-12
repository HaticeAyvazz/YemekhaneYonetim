// src/main/java/com/example/yemekhaneyonetimsistemi/entity/Kullanici.java

package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "kullanici")
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "kullanici_adi", unique = true, nullable = false)
    private String kullaniciAdi;

    @Column(name = "sifre", nullable = false)
    private String sifre;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private Role rol;

    // Ortak Opsiyonel Alanlar
    @Column(name = "email")
    private String email;

    @Column(name = "telefon_no")
    private String telefonNo;

    @Column(name = "kullanici_no")
    private String kullaniciNo;

    // İlişkisel Alanlar

    // Bolum (Sadece Öğrenci için, nullable)
    @ManyToOne
    @JoinColumn(name = "bolum_id") // Default olarak nullable=true
    private  Bolum bolum;


    // Departman (Sadece Personel için, nullable)
    @ManyToOne
    @JoinColumn(name = "departman_id") // Default olarak nullable=true
    private Departman departman;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getKullaniciAdi() { return kullaniciAdi; }
    public void setKullaniciAdi(String kullaniciAdi) { this.kullaniciAdi = kullaniciAdi; }

    public String getSifre() { return sifre; }
    public void setSifre(String sifre) { this.sifre = sifre; }

    public Role getRol() { return rol; }
    public void setRol(Role rol) { this.rol = rol; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefonNo() { return telefonNo; }
    public void setTelefonNo(String telefonNo) { this.telefonNo = telefonNo; }

    public String getKullaniciNo() { return kullaniciNo; }
    public void setKullaniciNo(String kullaniciNo) { this.kullaniciNo = kullaniciNo; }

    public Bolum getBolum() { return bolum; }
    public void setBolum(Bolum bolum) { this.bolum = bolum; }

    public Departman getDepartman() { return departman; }
    public void setDepartman(Departman departman) { this.departman = departman; }
}