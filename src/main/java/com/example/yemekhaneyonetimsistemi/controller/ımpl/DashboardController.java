package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.yemekhaneyonetimsistemi.Service.ımpl.AnaDashboardService;
import com.example.yemekhaneyonetimsistemi.controller.IDashboardController;


@Controller
public class DashboardController implements IDashboardController {

    @Autowired
    private AnaDashboardService dashboardService;


    @GetMapping("/dashboard")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @Override
    public String showDashboard(Model model) {
        long rezervasyonSayisi=dashboardService.getToplamRezervasyonSayisi();

        model.addAttribute("toplamRezervasyon",rezervasyonSayisi);
        model.addAttribute("işlem mesajı:","Dashboard verileri yüklendi.");

        return "dashboard";  //dashboard adındaki HTML sayfasına yönlendirilir.
    
    }

    
}
