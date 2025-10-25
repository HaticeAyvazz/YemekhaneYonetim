package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Departman;

import java.util.List;

public interface IDepartmanService {
    public List<Departman> getAllDepartman();
    public Departman updateDepartman(int id,Departman departman);
    public Departman insertDepartman(Departman departman);
    public Departman deleteDepartman(int id);
}
