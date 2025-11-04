package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Rezervasyon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface IRezervasyonRepository  {

    List<Rezervasyon> findAll();
    Optional<Rezervasyon> findById(int id);
    Rezervasyon save(Rezervasyon rezervasyon);
    void deleteById(int id);


}
