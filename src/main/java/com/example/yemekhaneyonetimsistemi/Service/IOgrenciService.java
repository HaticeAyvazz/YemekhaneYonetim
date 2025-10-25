package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Ogrenci;
import com.example.yemekhaneyonetimsistemi.entity.Yemek;

import java.util.List;

public interface IOgrenciService {
    public List<Ogrenci> getAllOgrenci();
    public Ogrenci updateOgrenci(int id,Ogrenci ogrenci);
    public Ogrenci insertOgrenci(Ogrenci ogrenci);
    public Ogrenci deleteOgrenci(int id);
}
