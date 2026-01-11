package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Kategori;
import com.example.yemekhaneyonetimsistemi.entity.Yemek;

import java.util.List;

public interface IKategoriService {
    public List<Kategori> getAllKategori();
    public Kategori partialUpdate(int id,Kategori kategori);
    Kategori fullUpdate(int id,Kategori kategori);
    public Kategori insertKategori(Kategori kategori);
    public Kategori deleteKategori(int id);
}
