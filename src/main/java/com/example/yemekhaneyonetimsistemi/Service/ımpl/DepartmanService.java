package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.repository.IDepartmanRepository;
import com.example.yemekhaneyonetimsistemi.Service.IDepartmanService;
import com.example.yemekhaneyonetimsistemi.entity.Departman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmanService implements IDepartmanService {
    @Autowired
    IDepartmanRepository departmanRepository;
    @Override
    public List<Departman> getAllDepartman() {
        return departmanRepository.findAll();
    }

    @Override
    public Departman updateDepartman(int id, Departman departman) {
        var departmna1 = departmanRepository.findById(id).orElse(null);
        if (departmna1 != null) {
            departmna1.setDepartmanAdi((departman.getDepartmanAdi()));
            departmanRepository.save(departmna1);
            return departmna1;
        }
        return null;
    }

    @Override
    public Departman insertDepartman(Departman departman) {
        return departmanRepository.save(departman);
    }

    @Override
    public Departman deleteDepartman(int id) {
        var departman = departmanRepository.findById(id).orElse(null);
        if(departman != null) {
            departmanRepository.delete(departman);
            return departman;
        }
        return null;
    }
}
