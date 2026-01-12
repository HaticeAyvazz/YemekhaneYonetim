package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Fakulte;

import java.util.List;

public interface IFakulteController {
     List<Fakulte> getAllFakulte();
     Fakulte patchUpdate(int id,Fakulte fakulte);
     Fakulte putUpdate(int id,Fakulte fakulte);
     Fakulte insertFakulte(Fakulte fakulte);
     Fakulte deleteFakulte(int id);
}
