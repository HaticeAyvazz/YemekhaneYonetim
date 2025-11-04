package com.example.yemekhaneyonetimsistemi.Service.ımpl;


import com.example.yemekhaneyonetimsistemi.Repository.IPersonalRepository;
import com.example.yemekhaneyonetimsistemi.Repository.IRezervasyonRepository;
import com.example.yemekhaneyonetimsistemi.Repository.IMenuRepository;
import com.example.yemekhaneyonetimsistemi.Service.IRezervasyonService;
import com.example.yemekhaneyonetimsistemi.Repository.IOgrenciRepository;
import com.example.yemekhaneyonetimsistemi.entity.Kullanici;
import com.example.yemekhaneyonetimsistemi.entity.Menu;
import com.example.yemekhaneyonetimsistemi.entity.Rezervasyon;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;


@Service

public class RezervasyonService implements IRezervasyonService {


    @Autowired
    IRezervasyonRepository rezervasyonRepository;

    @Autowired
    IPersonalRepository personalRepository;

    @Autowired
    IOgrenciRepository ogrenciRepository;

    @Autowired
    private IMenuRepository menuRepository;

    @Override
    public List<Rezervasyon> getAllRezervasyon() {
        return rezervasyonRepository.findAll();
    }

    @Override
    public Rezervasyon updateRezervasyon(int id, Rezervasyon rezervasyon) {
        var rezervasyon1 = rezervasyonRepository.findById(id).orElse(null);
        if (rezervasyon1 != null) {
            rezervasyon1.setTarih(rezervasyon.getTarih());
            rezervasyon1.setOnayDurumu(false);
            if (rezervasyon.getMenu() != null) {
                rezervasyon1.setMenu(rezervasyon.getMenu());
            }
            return rezervasyonRepository.save(rezervasyon1);
        }
        return null;
    }


    public Rezervasyon insertRezervasyon(Rezervasyon rezervasyon) {

        int transientKullanici = rezervasyon.getKullanici().getKullaniciId();

        Kullanici gercekKullanici = personalRepository.findById(transientKullanici).orElse(null);

        if(gercekKullanici==null){
            gercekKullanici=ogrenciRepository.findById(transientKullanici).orElse(null);
            if(gercekKullanici==null){
                return null;
            }
        }

        rezervasyon.setKullanici(gercekKullanici);


        Menu transientMenu = rezervasyon.getMenu();
        Menu gercekMenu = menuRepository.findById(transientMenu.getMenuId()).orElse(null);

        rezervasyon.setOnayDurumu(false);
        rezervasyon.setMenu(gercekMenu);

        return rezervasyonRepository.save(rezervasyon);
    }

    @Override
    public Rezervasyon deleteRezervasyon(int id) {
        var rezervasyon1 = rezervasyonRepository.findById(id).orElse(null);
        if (rezervasyon1 != null) {
            rezervasyonRepository.deleteById(id);
            return rezervasyon1;
        }
        return null;

    }

}


