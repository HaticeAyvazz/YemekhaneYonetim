package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Yemek;

import java.util.List;

public interface IYemekController {
    public List<Yemek> getYemek();
    public Yemek patchUpdate(int id,Yemek yemek);
    Yemek putUpdate(int id,Yemek yemek);
    public Yemek insertYemek(Yemek yemek);
    public Yemek deleteYemek(int id);
}
