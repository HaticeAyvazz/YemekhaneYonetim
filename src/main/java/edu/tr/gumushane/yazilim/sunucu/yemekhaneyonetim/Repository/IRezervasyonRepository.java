package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Menu;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Rezervasyon;

import java.util.List;
import java.util.Optional;


public interface IRezervasyonRepository  {

    List<Rezervasyon> findAll();
    Optional<Rezervasyon> findById(int id);
    Rezervasyon save(Rezervasyon rezervasyon);
    void deleteById(int id);

    List<Rezervasyon> findByMenu(Menu menu);


}
