package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IBolumRepository;
import com.example.yemekhaneyonetimsistemi.Service.IBolumService;
import com.example.yemekhaneyonetimsistemi.entity.Bolum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BolumService implements IBolumService {

    private IBolumRepository bolumRepository;

    public BolumService(IBolumRepository bolumRepository) {
        this.bolumRepository = bolumRepository;
    }
    @Override
    public List<Bolum> getAllBolum() {
        return bolumRepository.getAll();
    }

    @Override
    public Bolum updateBolum(int id, Bolum bolum) {
        var bolum1 = bolumRepository.findById(id).orElse(null);
        if (bolum1 != null) {
            bolum1.setBolumAdi(bolum.getBolumAdi());
            bolum1.setFakulte(bolum.getFakulte());
            return bolumRepository.save(bolum1);
        }
        return null;
    }

    @Override
    public Bolum insertBolum(Bolum bolum) {
        return bolumRepository.save(bolum);
    }

    @Override
    public Bolum deleteBolum(int id) {
        var bolum1 = bolumRepository.findById(id).orElse(null);
        if(bolum1 != null) {
            bolumRepository.deleteById(id);
            return bolum1;
        }
        return null;
    }
}
