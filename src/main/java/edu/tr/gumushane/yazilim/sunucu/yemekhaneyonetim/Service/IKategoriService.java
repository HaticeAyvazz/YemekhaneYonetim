package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kategori;

import java.util.List;

public interface IKategoriService {
    public List<Kategori> getAllKategori();
    public Kategori partialUpdate(int id,Kategori kategori);
    Kategori fullUpdate(int id,Kategori kategori);
    public Kategori insertKategori(Kategori kategori);
    public Kategori deleteKategori(int id);
}
