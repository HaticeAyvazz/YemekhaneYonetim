package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Fakulte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IFakulteRepository {
    List<Fakulte> getAll();

    Fakulte save(Fakulte fakulte);

    void deleteById(Integer id);

    Optional<Fakulte> findById(Integer id);

}
