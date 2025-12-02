package com.example.yemekhaneyonetimsistemi.Service.ımpl;

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
        return iYemekRepository.getAll();
    }

    @Override
    public Yemek updateYemek(int id,Yemek yemek) {
        var yemok = iYemekRepository.findById(id).orElseThrow(()-> new RuntimeException("yemek not found"));

        if(yemek.getYemekAdi()!=null){
            yemok.setYemekAdi(yemek.getYemekAdi());
        }
        if(yemek.getAciklama()!=null){
            yemok.setAciklama(yemek.getAciklama());
        }
        if(yemek.getUcret()!=null){
            yemok.setUcret(yemek.getUcret());
        }
        if(yemek.getKategori()!=null){
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
        iYemekRepository.deleteById(id);
        return yemok;
    }
}
