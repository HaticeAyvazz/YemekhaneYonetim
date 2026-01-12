package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Bolum;

import java.util.List;

public interface IBolumService {
    List<Bolum> getAllBolum();
    Bolum fullUpdate(int id,Bolum bolum);
    Bolum partialUpdate(int id,Bolum bolum);
    Bolum insertBolum(Bolum bolum);
    Bolum deleteBolum(int id);
}
