package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Departman;

import java.util.List;

public interface IDepartmanController {
     List<Departman> getAllDepartman();
     Departman putUpdate(int id,Departman departman);
     Departman patchUpdate(int id,Departman departman);
     Departman insertDepartman(Departman departman);
     Departman deleteDepartman(int id);
}
