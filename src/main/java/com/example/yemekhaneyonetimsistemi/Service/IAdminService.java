package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Admin;

import java.util.List;

public interface IAdminService {

    List<Admin> getAll();

    Admin insertAdmin(Admin admin);

    void deleteAdmin(int id);

    Admin updateAdmin(Admin adminDetails,int id);
}
