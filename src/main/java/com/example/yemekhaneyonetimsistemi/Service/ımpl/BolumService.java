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
    public Bolum fullUpdate(int id, Bolum bolum) {
        Bolum bolum1=bolumRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Bolum not founs"));

        bolum1.setBolumAdi(bolum.getBolumAdi());
        bolum1.setFakulte(bolum.getFakulte());
        return bolumRepository.save(bolum1);
    }


    @Override
    public Bolum partialUpdate(int id, Bolum bolum) {
        Bolum mevcut=bolumRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Bolum not found"));
        if (bolum.getBolumAdi() != null) {
            mevcut.setBolumAdi(bolum.getBolumAdi());
        }
        if (bolum.getFakulte() != null) {
            mevcut.setFakulte(bolum.getFakulte());
        }
        return bolumRepository.save(mevcut);
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
