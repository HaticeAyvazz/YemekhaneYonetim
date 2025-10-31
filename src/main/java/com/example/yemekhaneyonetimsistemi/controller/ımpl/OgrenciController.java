package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IOgrenciService;
import com.example.yemekhaneyonetimsistemi.controller.IOgrenciController;
import com.example.yemekhaneyonetimsistemi.entity.Ogrenci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/rest/api/ogrenci")
@RestController
public class OgrenciController implements IOgrenciController {
    @Autowired
    IOgrenciService service;
    @GetMapping("/getAll")
    @Override
    public List<Ogrenci> getAllOgrenci() {
        return service.getAllOgrenci();
    }
    @PatchMapping("/update/{id}")
    @Override
    public Ogrenci updateOgrenci(@PathVariable(name = "id") int id,@RequestBody Ogrenci ogrenci) {
        return service.updateOgrenci(id, ogrenci);
    }
    @PostMapping("/save")
    @Override
    public Ogrenci insertOgrenci(@RequestBody Ogrenci ogrenci) {
        return service.insertOgrenci(ogrenci);
    }
    @DeleteMapping("/delete/{id}")
    @Override
    public Ogrenci deleteOgrenci(@PathVariable(name = "id") int id) {
        return service.deleteOgrenci(id);
    }
}
