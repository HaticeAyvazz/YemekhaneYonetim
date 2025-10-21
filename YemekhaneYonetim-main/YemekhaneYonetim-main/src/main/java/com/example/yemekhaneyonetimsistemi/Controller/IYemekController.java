package com.example.yemekhaneyonetimsistemi.Controller;

import com.example.yemekhaneyonetimsistemi.entity.Yemek;

import java.util.List;

public interface IYemekController {
    public List<Yemek> getYemek();
    public Yemek updateYemek(int id,Yemek yemek);
    public Yemek insertYemek(Yemek yemek);
    public Yemek deleteYemek(int id);
}
