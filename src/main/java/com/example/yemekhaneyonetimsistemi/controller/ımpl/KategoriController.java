package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IKategoriService;
import com.example.yemekhaneyonetimsistemi.controller.IKategoriController;
import com.example.yemekhaneyonetimsistemi.entity.Kategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/kategori")
public class KategoriController implements IKategoriController {

    @Autowired
    IKategoriService ikategoriService;

    @GetMapping("/getAll")
    @Override
    public List<Kategori> getAllKategori() {
        return ikategoriService.getAllKategori();
    }


    @PatchMapping("/patchUpdate/{id}")
    @Override
    public Kategori putUpdate(@PathVariable int id, @RequestBody Kategori kategori) {
        return ikategoriService.partialUpdate(id, kategori);
    }

    @PutMapping("/putUpdate/{id}")
    @Override
    public Kategori patchUpdate(@PathVariable int id,@RequestBody Kategori kategori) {
        return ikategoriService.fullUpdate(id,kategori);
    }

    @PostMapping("/save")
    @Override
    public Kategori insertKategori(@RequestBody Kategori kategori) {
        return ikategoriService.insertKategori(kategori);
    }


    @DeleteMapping("/delete/{id}")
    @Override
    public Kategori deleteKategori(@PathVariable (name ="id")int id) {
        return ikategoriService.deleteKategori(id);
    }



}
