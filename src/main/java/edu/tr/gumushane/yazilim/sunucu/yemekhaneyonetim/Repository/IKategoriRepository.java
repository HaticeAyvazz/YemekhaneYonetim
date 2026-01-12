package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kategori;

import java.util.List;
import java.util.Optional;


public interface IKategoriRepository {

    List<Kategori> getAll();

    Kategori save(Kategori kategori);

    void deleteById(Integer id);

    Optional<Kategori> findById(Integer id);


}
