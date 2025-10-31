package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Admin;

import java.util.List;

public interface IAdminController {

    List<Admin> getAllAdmin();

    Admin insertAdmin(Admin admin);

    void deleteAdmin(int id);

    Admin updateAdmin(Admin adminDetails,int id);


}
