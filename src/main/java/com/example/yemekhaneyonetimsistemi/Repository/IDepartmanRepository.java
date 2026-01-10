package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Departman;

import java.util.List;
import java.util.Optional;


public interface IDepartmanRepository {
    List<Departman> getAll();

    Departman save(Departman departman);

    void deleteById(int id);

    Optional<Departman> findById(int id);
}
