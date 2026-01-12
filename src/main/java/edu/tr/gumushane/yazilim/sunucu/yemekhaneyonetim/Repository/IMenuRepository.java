package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Menu;

import java.util.List;
import java.util.Optional;


public interface IMenuRepository {
    List<Menu>getAll();

    Menu save(Menu menu);

    void deleteById(Integer id);

    Optional<Menu> findById(Integer id);


}
