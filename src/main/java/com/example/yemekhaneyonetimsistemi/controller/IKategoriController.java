package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Kategori;

import java.util.List;

public interface IKategoriController {
    public List<Kategori> getAllKategori();
    public Kategori patchUpdate(int id,Kategori kategori);
    Kategori putUpdate(int id,Kategori kategori);
    public Kategori insertKategori(Kategori kategori);
    public Kategori deleteKategori(int id);
}
