package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IKategoriService;
import com.example.yemekhaneyonetimsistemi.entity.Kategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriService implements IKategoriService {

    @Autowired
    com.example.yemekhaneyonetimsistemi.Repository.IKategoriRepository repository;

    @Override
    public List<Kategori> getAllKategori() {
        return repository.getAll();
    }


    @Override
    public Kategori updateKategori(int id, Kategori kategori) {
        Kategori kategorii = repository.findById(id).orElseThrow(()->new RuntimeException("Kategori  not found"));

       if(kategori.getKategoriAd()!=null){
           kategorii.setKategoriAd(kategori.getKategoriAd());
       }
       if(kategori.getTip()!=null){
           kategorii.setTip(kategori.getTip());
       }
       return repository.save(kategorii);
    }

    @Override
    public Kategori insertKategori(Kategori kategori) {
        return repository.save(kategori);
    }

    @Override
    public Kategori deleteKategori(int id) {
        var kategori = repository.findById(id);
        if (kategori.isPresent()) {       // Optional kontrolü
            repository.deleteById(id);
            return kategori.get();        // silinen objeyi döndürebiliriz
        }
        return null;
    }
}
