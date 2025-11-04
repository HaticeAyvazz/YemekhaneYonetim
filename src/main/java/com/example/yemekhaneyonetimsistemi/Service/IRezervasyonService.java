package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Rezervasyon;

import java.util.List;

public interface IRezervasyonService {
    public List<Rezervasyon> getAllRezervasyon();
    public Rezervasyon updateRezervasyon(int id, Rezervasyon rezervasyon);
    public Rezervasyon insertRezervasyon(Rezervasyon rezervasyon);
    public Rezervasyon deleteRezervasyon(int id);
}
