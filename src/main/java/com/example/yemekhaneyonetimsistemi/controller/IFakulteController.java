package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Fakulte;

import java.util.List;

public interface IFakulteController {
     List<Fakulte> getAllFakulte();
     Fakulte patchUpdate(int id,Fakulte fakulte);
     Fakulte putUpdate(int id,Fakulte fakulte);
     Fakulte insertFakulte(Fakulte fakulte);
     Fakulte deleteFakulte(int id);
}
