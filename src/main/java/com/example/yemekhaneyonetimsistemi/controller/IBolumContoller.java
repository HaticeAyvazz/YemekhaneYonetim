package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Bolum;

import java.util.List;

public interface IBolumContoller {
    public List<Bolum> getAllBolum();
    Bolum putUpdate(int id,Bolum bolum);
    Bolum patchUpdate(int id,Bolum bolum);
    public Bolum insertBolum(Bolum bolum);
    public Bolum deleteBolum(int id);
}
