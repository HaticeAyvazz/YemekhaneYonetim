package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Kullanici;

import java.util.List;
import java.util.Optional;

public interface IKullaniciRepository {
    List<Kullanici>getAll();

    Kullanici save(Kullanici kullanici);

    void deleteById(int id);

    Optional<Kullanici> findById(int id);

}
