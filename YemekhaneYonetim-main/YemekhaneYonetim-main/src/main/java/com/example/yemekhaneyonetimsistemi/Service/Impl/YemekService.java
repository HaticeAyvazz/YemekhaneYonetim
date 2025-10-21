package com.example.yemekhaneyonetimsistemi.Service.Impl;

import com.example.yemekhaneyonetimsistemi.Repository.IYemekRepository;
import com.example.yemekhaneyonetimsistemi.Service.IYemekService;
import com.example.yemekhaneyonetimsistemi.entity.Yemek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YemekService implements IYemekService {

    @Autowired
    IYemekRepository iYemekRepository;
    @Override
    public List<Yemek> getAllYemek() {
        return iYemekRepository.findAll();
    }

    @Override
    public Yemek updateYemek(int id,Yemek yemek) {
        var yemok = iYemekRepository.getOne(id);
        if(yemek != null) {
            yemok.setYemekAdi(yemek.getYemekAdi());
            yemok.setAciklama(yemek.getAciklama());
            yemok.setUcret(yemek.getUcret());
            yemok.setKategori(yemek.getKategori());
        }
        return iYemekRepository.save(yemok);
    }

    @Override
    public Yemek insertYemek( Yemek yemek) {
        return iYemekRepository.save(yemek);
    }

    @Override
    public Yemek deleteYemek(int id) {
        var yemok=iYemekRepository.findById(id).orElse(null);
        if(yemok==null) {
            return null;
        }
        iYemekRepository.delete(yemok);
        return yemok;
    }





}
