package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IBolumService;
import com.example.yemekhaneyonetimsistemi.controller.IBolumContoller;
import com.example.yemekhaneyonetimsistemi.entity.Bolum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/rest/api/bolum")
@RestController
public class BolumController implements IBolumContoller {
    @Autowired
    IBolumService bolumService;

    @GetMapping("/getAll")
    @Override
    public List<Bolum> getAllBolum() {
        return bolumService.getAllBolum();
    }
    @PatchMapping("/update/{id}")
    @Override
    public Bolum updateBolum(@PathVariable(name = "id") int id,@RequestBody Bolum bolum) {
        return bolumService.updateBolum(id,bolum);
    }
    @PostMapping("/save")
    @Override
    public Bolum insertBolum(@RequestBody Bolum bolum) {
        return bolumService.insertBolum(bolum);
    }
    @DeleteMapping("/delete/{id}")
    @Override
    public Bolum deleteBolum(@PathVariable(name = "id") int id) {
        return bolumService.deleteBolum(id);
    }
}
