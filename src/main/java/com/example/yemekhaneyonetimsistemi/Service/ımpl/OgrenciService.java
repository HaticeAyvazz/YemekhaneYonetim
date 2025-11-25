package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IOgrenciRepository;
import com.example.yemekhaneyonetimsistemi.Service.IOgrenciService;
import com.example.yemekhaneyonetimsistemi.entity.Kategori;
import com.example.yemekhaneyonetimsistemi.entity.Ogrenci;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OgrenciService implements IOgrenciService {

    @Autowired
    IOgrenciRepository repository;

    @PostConstruct
    public void in(){
        System.out.println("Ogrenciservice oluşturuluyor");
    }
    @PreDestroy
    public void out(){
        System.out.println("Ogrenciservice siliniyor");
    }

    @Override
    public List<Ogrenci> getAllOgrenci() {
        return repository.getAll();
    }

    @Override
    public Ogrenci updateOgrenci(int id, Ogrenci ogrenci) {
        Ogrenci ogr1=repository.findById(id).orElseThrow(()->new RuntimeException("ogrenci bulunamadi"));

            if(ogrenci.getKullaniciAdi()!=null) {
                ogr1.setKullaniciAdi(ogrenci.getKullaniciAdi());
            }
            if(ogrenci.getOgrenciNo()!=null) {
                ogr1.setOgrenciNo(ogrenci.getOgrenciNo());
            }
            if(ogrenci.getBolum()!=null) {
                ogr1.setBolum(ogrenci.getBolum());
            }
           if(ogrenci.getEmail()!=null) {
               ogr1.setEmail(ogrenci.getEmail());
           }
            if(ogrenci.getKullaniciSoyadi()!=null) {
                ogr1.setKullaniciSoyadi(ogrenci.getKullaniciSoyadi());
            }
           if(ogrenci.getTelefonNo()!=null) {
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
        repository.deleteById(id);
        return ogrenci;
    }
}
