package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.yemekhaneyonetimsistemi.Service.IAnaDashboardService;


@Service
public class AnaDashboardService implements IAnaDashboardService{
 
    private RezervasyonService rezervasyonService;


  public AnaDashboardService(@Lazy RezervasyonService rezervasyonService){
    this.rezervasyonService=rezervasyonService;
  }


    @Override
    public long getToplamRezervasyonSayisi() {
       return rezervasyonService.getAllRezervasyon().size();
    }

    
    
}
