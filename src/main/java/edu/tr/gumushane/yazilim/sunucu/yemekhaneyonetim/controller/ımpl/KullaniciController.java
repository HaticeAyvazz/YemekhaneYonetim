package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Dto.KullaniciKayitDTO;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IKullaniciService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.controller.IKullaniciController;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kullanici;
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
