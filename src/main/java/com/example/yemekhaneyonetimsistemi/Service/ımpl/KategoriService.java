package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IKategoriRepository;
import com.example.yemekhaneyonetimsistemi.Service.IKategoriService;
import com.example.yemekhaneyonetimsistemi.entity.Kategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KategoriService implements IKategoriService {
    @Autowired
    IKategoriRepository repository;
    @Override
    public List<Kategori> getAllKategori() {
        return repository.findAll();
    }

    @Override
    public Kategori updateKategori(int id, Kategori kategori) {
        if(kategori != null) {
            Kategori kategorii = repository.findById(id).orElse(null);
            kategorii.setKategoriAd(kategori.getKategoriAd());
            kategorii.setTip(kategori.getTip());
        }
        return repository.save(kategori);
    }

    @Override
    public Kategori insertKategori(Kategori kategori) {
        return repository.save(kategori);
    }

    @Override
    public Kategori deleteKategori(int id) {
        var kategori = repository.findById(id);
        if (kategori != null) {
            repository.deleteById(id);
        }
        return null;
    }
}
