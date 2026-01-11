package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Departman;

import java.util.List;

public interface IDepartmanService {
    List<Departman> getAllDepartman();
    Departman partialUpdate(int id,Departman departman);
    Departman fullUpdate(int id,Departman departman);
    Departman insertDepartman(Departman departman);
    Departman deleteDepartman(int id);
}
