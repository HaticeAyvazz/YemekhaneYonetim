package com.example.yemekhaneyonetimsistemi.Repository;

import com.example.yemekhaneyonetimsistemi.entity.Admin;
import java.util.List;
import java.util.Optional;
public interface IAdminRepository {

    List<Admin> getAll();

    Admin save(Admin admin);

    void deleteById(int id);

    Optional<Admin> findById(int id);
}