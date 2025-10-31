package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Fakulte;

import java.util.List;

public interface IFakulteController {
    public List<Fakulte> getAllFakulte();
    public Fakulte updateFakulte(int id,Fakulte fakulte);
    public Fakulte insertFakulte(Fakulte fakulte);
    public Fakulte deleteFakulte(int id);
}
