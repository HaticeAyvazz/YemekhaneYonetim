package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Departman;

import java.util.List;
import java.util.Optional;


public interface IDepartmanRepository {
    List<Departman> getAll();

    Departman save(Departman departman);

    void deleteById(int id);

    Optional<Departman> findById(int id);
}
