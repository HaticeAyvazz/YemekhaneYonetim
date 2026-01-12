package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Fakulte;

import java.util.List;
import java.util.Optional;

public interface IFakulteRepository {
    List<Fakulte> getAll();

    Fakulte save(Fakulte fakulte);

    void deleteById(Integer id);

    Optional<Fakulte> findById(Integer id);

}
