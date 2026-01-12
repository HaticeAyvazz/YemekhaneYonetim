package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Bolum;

import java.util.List;
import java.util.Optional;


public interface IBolumRepository {
    List<Bolum> getAll();

    Bolum save(Bolum bolum);

    void deleteById(int id);

    Optional<Bolum> findById(int id);
}
