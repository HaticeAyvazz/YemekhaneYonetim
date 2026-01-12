package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IDepartmanRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IDepartmanService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Departman;
import jakarta.transaction.Transactional;
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

    @Transactional
    @Override
    public Departman partialUpdate(int id, Departman departman) {
        var departman1 = departmanRepository.findById(id).orElseThrow(()-> new RuntimeException("departman not found"));

            if(departman.getDepartmanAdi()!=null){
                departman1.setDepartmanAdi(departman.getDepartmanAdi());
            }
            return departmanRepository.save(departman1);
    }

    @Transactional
    @Override
    public Departman fullUpdate(int id, Departman departman) {
        var departman2=departmanRepository.findById(id)
                .orElseThrow(()->new RuntimeException("departman not found"));
        departman2.setDepartmanAdi(departman.getDepartmanAdi());
        return departmanRepository.save(departman2);
    }

    @Transactional
    @Override
    public Departman insertDepartman(Departman departman) {
        return departmanRepository.save(departman);
    }


    @Override
    @Transactional
    public Departman deleteDepartman(int id) {
        var departman = departmanRepository.findById(id).orElse(null);
        if(departman != null) {
            departmanRepository.deleteById(id);
            return departman;
        }
        return null;
    }
}
