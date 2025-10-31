package com.example.yemekhaneyonetimsistemi.repository;

import com.example.yemekhaneyonetimsistemi.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonalRepository extends JpaRepository<Personel,Integer> {

}
