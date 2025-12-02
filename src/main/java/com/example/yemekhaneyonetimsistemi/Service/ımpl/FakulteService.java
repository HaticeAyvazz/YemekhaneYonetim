package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IFakulteRepository;
import com.example.yemekhaneyonetimsistemi.Service.IFakulteService;
import com.example.yemekhaneyonetimsistemi.entity.Fakulte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FakulteService implements IFakulteService {
    @Autowired
    IFakulteRepository fakulteRepository;
    @Override
    public List<Fakulte> getAllFakulte() {
        return fakulteRepository.getAll();
    }

    @Override
    public Fakulte updateFakulte(int id, Fakulte fakulte) {
        var fakulte1 = fakulteRepository.findById(id).orElseThrow(()->new RuntimeException("Fakulte  not found"));

           if(fakulte.getFakulteAdi()!=null){
               fakulte1.setFakulteAdi(fakulte.getFakulteAdi());
           }

        return fakulteRepository.save(fakulte1);
    }

    @Override
    public Fakulte insertFakulte(Fakulte fakulte) {
        return fakulteRepository.save(fakulte);
    }

    @Override
    public Fakulte deleteFakulte(int id) {
        var fakulte = fakulteRepository.findById(id).orElse(null);
        if(fakulte != null) {
            fakulteRepository.deleteById(id);
            return fakulte;
        }
        return null;
    }
}
