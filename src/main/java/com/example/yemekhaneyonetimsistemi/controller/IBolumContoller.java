package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Bolum;

import java.util.List;

public interface IBolumContoller {
    public List<Bolum> getAllBolum();
    public Bolum updateBolum(int id,Bolum bolum);
    public Bolum insertBolum(Bolum bolum);
    public Bolum deleteBolum(int id);
}
