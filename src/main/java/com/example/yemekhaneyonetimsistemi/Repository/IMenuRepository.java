package com.example.yemekhaneyonetimsistemi.repository;

import com.example.yemekhaneyonetimsistemi.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMenuRepository extends JpaRepository<Menu,Integer> {

    List<Menu> findByTarih(LocalDate tarih);


}
