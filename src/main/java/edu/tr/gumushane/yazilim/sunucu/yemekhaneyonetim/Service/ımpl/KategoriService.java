package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IKategoriService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kategori;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IKategoriRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriService implements IKategoriService {

    @Autowired
    IKategoriRepository repository;

    @Override
    public List<Kategori> getAllKategori() {
        return repository.getAll();
    }


    @Override
    @Transactional
    public Kategori partialUpdate(int id, Kategori kategori) {
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
    @Transactional
    public Kategori fullUpdate(int id, Kategori kategori) {
        Kategori kategori2=repository.findById(id).orElseThrow(()->new RuntimeException("Kategori not found"));
        kategori2.setKategoriAd(kategori.getKategoriAd());
        kategori2.setTip(kategori.getTip());
        return repository.save(kategori2);
    }

    @Transactional
    @Override
    public Kategori insertKategori(Kategori kategori) {
        return repository.save(kategori);
    }

    @Transactional
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
