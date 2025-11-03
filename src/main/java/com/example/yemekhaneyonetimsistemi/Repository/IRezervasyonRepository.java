package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Rezervasyon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRezervasyonService extends JpaRepository<Rezervasyon, Integer> {
}
