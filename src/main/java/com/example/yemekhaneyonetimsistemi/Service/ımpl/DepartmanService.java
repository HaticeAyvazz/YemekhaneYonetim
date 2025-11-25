package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IDepartmanRepository;
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
        return departmanRepository.getAll();
    }

    @Override
    public Departman updateDepartman(int id, Departman departman) {
        var departman1 = departmanRepository.findById(id).orElseThrow(()-> new RuntimeException("departman not found"));

            if(departman.getDepartmanAdi()!=null){
                departman1.setDepartmanAdi(departman.getDepartmanAdi());
            }
            return departmanRepository.save(departman1);

    }

    @Override
    public Departman insertDepartman(Departman departman) {
        return departmanRepository.save(departman);
    }

    @Override
    public Departman deleteDepartman(int id) {
        var departman = departmanRepository.findById(id).orElse(null);
        if(departman != null) {
            departmanRepository.deleteById(id);
            return departman;
        }
        return null;
    }
}
