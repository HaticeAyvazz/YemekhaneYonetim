package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IRezervasyonService;
import com.example.yemekhaneyonetimsistemi.controller.IRezervasyonController;
import com.example.yemekhaneyonetimsistemi.entity.Rezervasyon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/api/rezervasyon")
public class RezervasyonController implements IRezervasyonController {

    @Autowired
    IRezervasyonService iRezervasyonService;
    @GetMapping("/getAll")
    @Override
    public List<Rezervasyon> getAllRezervasyon() {
        return iRezervasyonService.getAllRezervasyon();
    }
    @PatchMapping("/update/{id}")
    @Override
    public Rezervasyon updateRezervasyon(@PathVariable(name = "id") int id,@RequestBody Rezervasyon rezervasyon) {
        return iRezervasyonService.updateRezervasyon(id, rezervasyon);
    }
    @PostMapping("/save")
    @Override
    public Rezervasyon insertRezervasyon(@RequestBody Rezervasyon rezervasyon) {
        return iRezervasyonService.insertRezervasyon(rezervasyon);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public Rezervasyon deleteRezervasyon(@PathVariable(name = "id") int id) {
        return iRezervasyonService.deleteRezervasyon(id);
    }
}
