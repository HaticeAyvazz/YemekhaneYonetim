package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Bolum;

import java.util.List;

public interface IBolumService {
    public List<Bolum> getAllBolum();
    public Bolum updateBolum(int id,Bolum bolum);
    public Bolum insertBolum(Bolum bolum);
    public Bolum deleteBolum(int id);
}
