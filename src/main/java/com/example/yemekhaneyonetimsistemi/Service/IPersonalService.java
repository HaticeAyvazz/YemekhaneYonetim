package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Personel;

import java.util.List;

public interface IPersonalService {
    List<Personel>getAllPersonal();

    Personel insertPersonal(Personel personel);

    void deletePersonal(int id);

    Personel updatePersonal(Personel personelDetails,int id);
}
