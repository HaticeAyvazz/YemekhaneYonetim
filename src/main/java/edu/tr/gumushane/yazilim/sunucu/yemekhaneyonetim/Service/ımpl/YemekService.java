package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IYemekRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IYemekService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Yemek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class YemekService implements IYemekService {

    @Autowired
    IYemekRepository iYemekRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Yemek> getAllYemek() {
        return iYemekRepository.getAll();
    }


    @Override
    @Transactional
    public Yemek partialUpdate(int id,Yemek yemek) {
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
    @Transactional
    public Yemek fullUpdate(int id, Yemek yemek) {
        Yemek yemek1=iYemekRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Yemek not found"));

        yemek1.setYemekAdi(yemek.getYemekAdi());
        yemek1.setAciklama(yemek.getAciklama());
        yemek1.setUcret(yemek.getUcret());
        yemek1.setKategori(yemek.getKategori());
        return iYemekRepository.save(yemek1);
    }


    @Override
    @Transactional
    public Yemek insertYemek( Yemek yemek) {
        return iYemekRepository.save(yemek);
    }

    @Override
    @Transactional
    public Yemek deleteYemek(int id) {
        var yemok=iYemekRepository.findById(id).orElse(null);
        if(yemok==null) {
            return null;
        }
        iYemekRepository.deleteById(id);
        return yemok;
    }
}
