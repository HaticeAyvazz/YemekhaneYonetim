package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Yemek;

import java.util.List;

public interface IYemekService {
    public List<Yemek> getAllYemek();
    public Yemek partialUpdate(int id,Yemek yemek);
    Yemek fullUpdate(int id,Yemek yemek);
    public Yemek insertYemek(Yemek yemek);
    public Yemek deleteYemek(int id);

}
