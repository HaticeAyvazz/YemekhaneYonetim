package com.example.yemekhaneyonetimsistemi.repository;

import com.example.yemekhaneyonetimsistemi.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOgrenciRepository extends JpaRepository<Ogrenci,Integer> {
}
