package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Yemek;

import java.util.List;
import java.util.Optional;

public interface IYemekRepository{

    List<Yemek>getAll();

    Yemek save(Yemek yemek);

    void deleteById(int id);

    Optional<Yemek>findById(int id);

}
