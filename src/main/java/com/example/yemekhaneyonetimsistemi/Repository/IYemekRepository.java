package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Yemek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IYemekRepository{

    List<Yemek>getAll();

    Yemek save(Yemek yemek);

    void deleteById(int id);

    Optional<Yemek>findById(int id);

}
