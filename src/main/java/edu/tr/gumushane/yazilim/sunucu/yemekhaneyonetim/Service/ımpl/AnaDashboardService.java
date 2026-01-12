package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.ımpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IAnaDashboardService;


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
