package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Admin;
import com.example.yemekhaneyonetimsistemi.entity.Departman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface IDepartmanRepository {
    List<Departman> getAll();

    Departman save(Departman departman);

    void deleteById(int id);

    Optional<Departman> findById(int id);
}
