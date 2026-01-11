package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Fakulte;

import java.util.List;

public interface IFakulteService {
     List<Fakulte> getAllFakulte();
     Fakulte partialUpdate(int id,Fakulte fakulte);
     Fakulte fullUpdate(int id,Fakulte fakulte);
     Fakulte insertFakulte(Fakulte fakulte);
     Fakulte deleteFakulte(int id);
}

