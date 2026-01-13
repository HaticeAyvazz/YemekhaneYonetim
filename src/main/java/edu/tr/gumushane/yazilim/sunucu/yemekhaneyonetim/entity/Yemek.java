package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "yemek")
public class Yemek {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "yemekid")
    private int yemekId;

    @Column(name = "yemekad")
    private String yemekAdi;

    @Column(name = "aciklama")
    private String aciklama;

    @Column(name = "ucret")
    private BigDecimal ucret;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "kategori_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Kategori kategori;

    @ManyToMany(mappedBy = "yemekler")
    @JsonIgnore
    private List<Menu> menuler;

    public int getYemekId() {
        return yemekId;
    }

    public void setYemekId(int yemekId) {
        this.yemekId = yemekId;
    }

    public String getYemekAdi() {
        return yemekAdi;
    }

    public void setYemekAdi(String yemekAdi) {
        this.yemekAdi = yemekAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public BigDecimal getUcret() {
        return ucret;
    }

    public void setUcret(BigDecimal ucret) {
        this.ucret = ucret;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public List<Menu> getMenuler() {
        return menuler;
    }

    public void setMenuler(List<Menu> menuler) {
        this.menuler = menuler;
    }
}
