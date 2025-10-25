package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Ogrenci;

import java.util.List;

public interface IOgrenciController {
    public List<Ogrenci> getAllOgrenci();
    public Ogrenci updateOgrenci(int id,Ogrenci ogrenci);
    public Ogrenci insertOgrenci(Ogrenci ogrenci);
    public Ogrenci deleteOgrenci(int id);
}
