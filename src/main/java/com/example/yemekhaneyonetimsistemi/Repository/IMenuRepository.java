package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Menu;
import com.example.yemekhaneyonetimsistemi.entity.Yemek;

import java.util.List;
import java.util.Optional;


public interface IMenuRepository {
    List<Menu>getAll();

    Menu save(Menu menu);

    void deleteById(Integer id);

    Optional<Menu> findById(Integer id);


}
