package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Rezervasyon;

import java.util.List;

public interface IRezervasyonController {
    public List<Rezervasyon> getAllRezervasyon();
    public Rezervasyon patchUpdate(int id, Rezervasyon rezervasyon);
    Rezervasyon putUpdate(int id,Rezervasyon rezervasyon);
    public Rezervasyon insertRezervasyon(Rezervasyon rezervasyon);
    public Rezervasyon deleteRezervasyon(int id);
}
