package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Yemek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IYemekRepository extends JpaRepository<Yemek, Integer> {
}
