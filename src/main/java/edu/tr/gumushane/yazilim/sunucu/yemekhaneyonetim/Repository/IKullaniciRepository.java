package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kullanici;

import java.util.List;
import java.util.Optional;

public interface IKullaniciRepository {
    List<Kullanici>getAll();

    Kullanici save(Kullanici kullanici);

    void deleteById(int id);

    Optional<Kullanici> findById(int id);

}
