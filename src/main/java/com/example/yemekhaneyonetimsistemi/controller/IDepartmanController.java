package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Departman;

import java.util.List;

public interface IDepartmanController {
    public List<Departman> getAllDepartman();
    public Departman updateDepartman(int id,Departman departman);
    public Departman insertDepartman(Departman departman);
    public Departman deleteDepartman(int id);
}
