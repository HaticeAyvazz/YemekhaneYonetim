package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Dto.KullaniciKayitDTO;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kullanici;

import java.util.List;

public interface IKullaniciService {
    public List<Kullanici> getAllKullanici();
    public Kullanici updateKullanici(int id, Kullanici kullanici);
    public Kullanici insertKullanici(KullaniciKayitDTO kullaniciKayitDTO);
    public Kullanici deleteKullanici(int id);
    public Kullanici fullUpdate(int id, Kullanici kullanici);
}
