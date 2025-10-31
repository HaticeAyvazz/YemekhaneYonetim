package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.repository.IOgrenciRepository;
import com.example.yemekhaneyonetimsistemi.Service.IOgrenciService;
import com.example.yemekhaneyonetimsistemi.entity.Kategori;
import com.example.yemekhaneyonetimsistemi.entity.Ogrenci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OgrenciService implements IOgrenciService {
    @Autowired
    IOgrenciRepository repository;
    @Override
    public List<Ogrenci> getAllOgrenci() {
        return repository.findAll();
    }

    @Override
    public Ogrenci updateOgrenci(int id, Ogrenci ogrenci) {
        Ogrenci ogr1=repository.findById(id).orElse(null);
        if(ogrenci != null) {
            Ogrenci ogr = repository.findById(id).orElse(null);
            ogr1.setKullaniciAdi(ogrenci.getKullaniciAdi());
            ogr1.setOgrenciNo(ogrenci.getOgrenciNo());
            ogr1.setBolum(ogrenci.getBolum());
            ogr1.setEmail(ogrenci.getEmail());
            ogr1.setKullaniciSoyad(ogrenci.getKullaniciSoyad());
            ogr1.setTelefonNo(ogrenci.getTelefonNo());

        }
        return repository.save(ogr1);
    }

    @Override
    public Ogrenci insertOgrenci(Ogrenci ogrenci) {
        return repository.save(ogrenci);
    }

    @Override
    public Ogrenci deleteOgrenci(int id) {
        var ogrenci=repository.findById(id).orElse(null);
        if(ogrenci==null) {
            return null;
        }
        repository.delete(ogrenci);
        return ogrenci;
    }
}
