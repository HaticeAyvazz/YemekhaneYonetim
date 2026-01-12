package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.ımpl;


import java.util.List;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IKullaniciRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IMenuRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IRezervasyonRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IRezervasyonService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kullanici;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Menu;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Rezervasyon;


@Service
@Lazy
public class RezervasyonService implements IRezervasyonService {


    @Autowired
    IRezervasyonRepository rezervasyonRepository;

    @Autowired
    IKullaniciRepository kullaniciRepository;

    @Autowired
    private IMenuRepository menuRepository;

    @Override
    public List<Rezervasyon> getAllRezervasyon() {
        return rezervasyonRepository.findAll();
    }

    @Override
    @Transactional
    public Rezervasyon partialUpdate(int id, Rezervasyon rezervasyon) {
        var rezervasyon1 = rezervasyonRepository.findById(id).orElseThrow(()-> new RuntimeException("Rezervasyon not found"));
        if(rezervasyon.getTarih()!=null){
            rezervasyon1.setTarih(rezervasyon.getTarih());
        }
        if(rezervasyon.getKullanici()!=null){
            rezervasyon1.setKullanici(rezervasyon.getKullanici());
        }
        if(rezervasyon.getMenu()!=null){
            rezervasyon1.setMenu(rezervasyon.getMenu());
        }
        rezervasyon1.setOnayDurumu(false);
        return rezervasyonRepository.save(rezervasyon1);

    }


    @Override
    @Transactional
    public Rezervasyon fullUpdate(int id, Rezervasyon rezervasyon) {
        Rezervasyon rezervasyon1=rezervasyonRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Rezerasyon not found"));
        rezervasyon1.setTarih(rezervasyon.getTarih());
        rezervasyon1.setMenu(rezervasyon.getMenu());
        rezervasyon1.setKullanici(rezervasyon.getKullanici());
        rezervasyon1.setOnayDurumu(false);
        return rezervasyonRepository.save(rezervasyon1);
    }

    public Rezervasyon insertRezervasyon(Rezervasyon rezervasyon) {

        int transientKullanici = rezervasyon.getRezervasyonId();

        Kullanici gercekKullanici = kullaniciRepository.findById(transientKullanici).orElse(null);



        rezervasyon.setKullanici(gercekKullanici);


        Menu transientMenu = rezervasyon.getMenu();
        Menu gercekMenu = menuRepository.findById(transientMenu.getMenuId()).orElse(null);

        rezervasyon.setOnayDurumu(false);
        rezervasyon.setMenu(gercekMenu);

        return rezervasyonRepository.save(rezervasyon);
    }

    @Override
    @Transactional
    public Rezervasyon deleteRezervasyon(int id) {
        var rezervasyon1 = rezervasyonRepository.findById(id).orElse(null);
        if (rezervasyon1 != null) {
            rezervasyonRepository.deleteById(id);
            return rezervasyon1;
        }
        return null;

    }

}


