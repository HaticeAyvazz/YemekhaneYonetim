package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IFakulteRepository;
import com.example.yemekhaneyonetimsistemi.Service.IFakulteService;
import com.example.yemekhaneyonetimsistemi.entity.Fakulte;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    public Fakulte partialUpdate(int id,Fakulte fakulte) {
        var fakulte1 = fakulteRepository.findById(id).orElseThrow(()->new RuntimeException("Fakulte  not found"));

           if(fakulte.getFakulteAdi()!=null) {
               fakulte1.setFakulteAdi(fakulte.getFakulteAdi());
           }
        return fakulteRepository.save(fakulte1);
    }


    @Override
    @Transactional
    public Fakulte fullUpdate(int id, Fakulte fakulte) {
        var fakulte2=fakulteRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Fakulte not found"));
        fakulte2.setFakulteAdi(fakulte.getFakulteAdi());
        return fakulteRepository.save(fakulte2);
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
