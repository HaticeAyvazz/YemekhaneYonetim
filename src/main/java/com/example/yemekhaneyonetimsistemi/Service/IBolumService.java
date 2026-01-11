package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Bolum;

import java.util.List;

public interface IBolumService {
    List<Bolum> getAllBolum();
    Bolum fullUpdate(int id,Bolum bolum);
    Bolum partialUpdate(int id,Bolum bolum);
    Bolum insertBolum(Bolum bolum);
    Bolum deleteBolum(int id);
}
