package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Admin;
import com.example.yemekhaneyonetimsistemi.entity.Bolum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface IBolumRepository {
    List<Bolum> getAll();

    Bolum save(Bolum bolum);

    void deleteById(int id);

    Optional<Bolum> findById(int id);
}
