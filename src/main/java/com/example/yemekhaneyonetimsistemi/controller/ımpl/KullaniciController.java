package com.example.yemekhaneyonetimsistemi.controller.ımpl;

import com.example.yemekhaneyonetimsistemi.Dto.KullaniciKayitDTO;
import com.example.yemekhaneyonetimsistemi.Service.IKullaniciService;
import com.example.yemekhaneyonetimsistemi.controller.IKullaniciController;
import com.example.yemekhaneyonetimsistemi.entity.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/api/kullanici")
public class KullaniciController implements IKullaniciController
{
    @Autowired
    IKullaniciService kullaniciService;
    @GetMapping("/getAll")
    @Override
    public List<Kullanici> getAllKullanici() {
        return kullaniciService.getAllKullanici();
    }
    @PatchMapping("/patch/{id}")
    @Override
    public Kullanici updateKullanici(@PathVariable(name = "id") int id,@RequestBody Kullanici kullanici) {
        return kullaniciService.updateKullanici(id,kullanici);
    }
    @PutMapping("/put/{id}")
    public Kullanici fullUpdate(@PathVariable int id, @RequestBody Kullanici kullanici) {
        Kullanici result = kullaniciService.fullUpdate(id, kullanici);
        return result;
    }
    @PostMapping("/save")
    @Override
    public Kullanici insertKullanici(@RequestBody KullaniciKayitDTO kullaniciKayitDTO) {
        return kullaniciService.insertKullanici(kullaniciKayitDTO);
    }
    @DeleteMapping("/delete/{id}")
    @Override
    public Kullanici deleteKullanici(@PathVariable(name = "id") int id) {
        return kullaniciService.deleteKullanici(id);
    }
}
