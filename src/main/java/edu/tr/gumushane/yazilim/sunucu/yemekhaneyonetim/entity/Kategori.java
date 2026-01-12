package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "kategori")
public class Kategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kategoriid")
    private int kategoriId;

    @Column(name = "kategoriad")
    private String kategoriAd;

    @Column(name = "tip")
    private String tip;

    @JsonIgnoreProperties("yemekler") // Veya @JsonIgnore
    @OneToMany(mappedBy = "kategori", cascade = CascadeType.ALL)
    private List<Yemek> yemekler;

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriAd() {
        return kategoriAd;
    }

    public void setKategoriAd(String kategoriAd) {
        this.kategoriAd = kategoriAd;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

}
