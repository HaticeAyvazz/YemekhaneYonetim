package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Rezervasyon;

import java.util.List;

public interface IRezervasyonService {
    public List<Rezervasyon> getAllRezervasyon();
    public Rezervasyon partialUpdate(int id, Rezervasyon rezervasyon);
    Rezervasyon fullUpdate(int id,Rezervasyon rezervasyon);
    public Rezervasyon insertRezervasyon(Rezervasyon rezervasyon);
    public Rezervasyon deleteRezervasyon(int id);
}
