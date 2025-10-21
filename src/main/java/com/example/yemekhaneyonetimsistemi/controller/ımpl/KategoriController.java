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
    @PatchMapping("/update")
    @Override
    public Kategori updateKategori(int id, Kategori kategori) {
        return ikategoriService.updateKategori(id, kategori);
    }
    @PostMapping("/save")
    @Override
    public Kategori insertKategori(Kategori kategori) {
        return ikategoriService.insertKategori(kategori);
    }
    @DeleteMapping("/delete")
    @Override
    public Kategori deleteKategori(int id) {
        return ikategoriService.deleteKategori(id);
    }
}
