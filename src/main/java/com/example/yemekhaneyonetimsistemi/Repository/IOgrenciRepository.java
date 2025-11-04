package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Kategori;
import com.example.yemekhaneyonetimsistemi.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface IOgrenciRepository  {

    List<Ogrenci>getAll();

    Ogrenci save(Ogrenci ogrenci);

    void deleteById(int id);

    Optional<Ogrenci> findById(int id);


}
