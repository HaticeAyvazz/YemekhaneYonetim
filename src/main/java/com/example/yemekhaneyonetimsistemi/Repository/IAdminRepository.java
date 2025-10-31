package com.example.yemekhaneyonetimsistemi.repository;

import com.example.yemekhaneyonetimsistemi.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin,Integer> {

}
