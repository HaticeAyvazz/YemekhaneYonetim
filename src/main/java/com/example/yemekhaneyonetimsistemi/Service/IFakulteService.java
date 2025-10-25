package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Fakulte;
import com.example.yemekhaneyonetimsistemi.entity.Ogrenci;

import java.util.List;

public interface IFakulteService {
    public List<Fakulte> getAllFakulte();
    public Fakulte updateFakulte(int id,Fakulte fakulte);
    public Fakulte insertFakulte(Fakulte fakulte);
    public Fakulte deleteFakulte(int id);
}
