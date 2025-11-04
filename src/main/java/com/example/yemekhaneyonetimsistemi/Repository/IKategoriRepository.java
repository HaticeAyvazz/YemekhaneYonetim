package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Fakulte;
import com.example.yemekhaneyonetimsistemi.entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface IKategoriRepository {

    List<Kategori> getAll();

    Kategori save(Kategori kategori);

    void deleteById(Integer id);

    Optional<Kategori> findById(Integer id);


}
