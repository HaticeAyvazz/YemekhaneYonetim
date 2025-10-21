package com.example.yemekhaneyonetimsistemi.Service;

import com.example.yemekhaneyonetimsistemi.entity.Yemek;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.List;

public interface IYemekService {
    public List<Yemek> getAllYemek();
    public Yemek updateYemek(int id,Yemek yemek);
    public Yemek insertYemek(Yemek yemek);
    public Yemek deleteYemek(int id);

}
