package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Fakulte;

import java.util.List;

public interface IFakulteService {
     List<Fakulte> getAllFakulte();
     Fakulte partialUpdate(int id,Fakulte fakulte);
     Fakulte fullUpdate(int id,Fakulte fakulte);
     Fakulte insertFakulte(Fakulte fakulte);
     Fakulte deleteFakulte(int id);
}

