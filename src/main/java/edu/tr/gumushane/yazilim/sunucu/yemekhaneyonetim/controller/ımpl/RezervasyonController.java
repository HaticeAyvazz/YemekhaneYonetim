package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IRezervasyonService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller.IRezervasyonController;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Rezervasyon;
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

    @PatchMapping("/patchUpdate/{id}")
    @Override
    public Rezervasyon patchUpdate(@PathVariable(name = "id") int id,@RequestBody Rezervasyon rezervasyon) {
        return iRezervasyonService.partialUpdate(id, rezervasyon);
    }

    @PutMapping("/putUpdate/{id}")
    @Override
    public Rezervasyon putUpdate(@PathVariable int id, @RequestBody Rezervasyon rezervasyon) {
        return iRezervasyonService.fullUpdate(id,rezervasyon);
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
