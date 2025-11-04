package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface IPersonalRepository{

    List<Personel> getAll();

    Personel save(Personel personel);

    void deleteById(Integer id);

    Optional<Personel> findById(Integer id);


}
