package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Personel;

import java.util.List;

public interface IPersonalController {

    List<Personel>getAllPersonal();

    Personel insertPersonal(Personel personel);

    void deletePersonal(int id);

    Personel updatePersonal(Personel personalDetails,Integer id);

}
