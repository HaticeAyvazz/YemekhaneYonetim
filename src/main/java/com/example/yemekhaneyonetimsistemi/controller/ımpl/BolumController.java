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

    @PostMapping("/save")
    @Override
    public Bolum insertBolum(@RequestBody Bolum bolum) {
        return bolumService.insertBolum(bolum);
    }

    @PutMapping("/putUpdate/{id}")
    @Override
    public Bolum putUpdate(@PathVariable int id,@RequestBody Bolum bolum) {
        return bolumService.fullUpdate(id, bolum);
    }

    @PatchMapping("/patchUpdate/{id}")
    @Override
    public Bolum patchUpdate(@PathVariable int id,@RequestBody Bolum bolum) {
        return bolumService.partialUpdate(id,bolum);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public Bolum deleteBolum(@PathVariable(name = "id") int id) {
        return bolumService.deleteBolum(id);
    }


}
