package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.ımpl;


import java.util.List;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IKullaniciRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IMenuRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IRezervasyonRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IRezervasyonService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kullanici;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Menu;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Rezervasyon;



@Service
@Lazy
public class RezervasyonService implements IRezervasyonService {


    @Autowired
    IRezervasyonRepository rezervasyonRepository;

    @Autowired
    IKullaniciRepository kullaniciRepository;

    @Autowired
    private IMenuRepository menuRepository;

    @Override
    public List<Rezervasyon> getAllRezervasyon() {
        return rezervasyonRepository.findAll();
    }

    @Override
    @Transactional
    public Rezervasyon partialUpdate(int id, Rezervasyon rezervasyon) {
        // 1. Veritabanındaki orijinal kaydı getir
        var mevcutRez = rezervasyonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rezervasyon bulunamadı: " + id));

        // 2. Tarih güncellemesi
        if (rezervasyon.getTarih() != null) {
            mevcutRez.setTarih(rezervasyon.getTarih());
        }

        // 3. Menü değişimi (Gelen ID ile DB'den çekip bağlamak en güvenlisidir)
        if (rezervasyon.getMenu() != null && rezervasyon.getMenu().getMenuId() != 0) {
            Menu m = menuRepository.findById(rezervasyon.getMenu().getMenuId())
                    .orElseThrow(() -> new RuntimeException("Menü bulunamadı"));
            mevcutRez.setMenu(m);
        }

        // 4. Kullanıcı değişimi
        if (rezervasyon.getKullanici() != null && rezervasyon.getKullanici().getId() != 0) {
            Kullanici k = kullaniciRepository.findById(rezervasyon.getKullanici().getId())
                    .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
            mevcutRez.setKullanici(k);
        }

        // İş mantığı kuralı
        mevcutRez.setOnayDurumu(false);

        return rezervasyonRepository.save(mevcutRez);
    }


    @Override
    @Transactional
    public Rezervasyon fullUpdate(int id, Rezervasyon rezervasyon) {
        Rezervasyon rezervasyon1=rezervasyonRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Rezerasyon not found"));
        rezervasyon1.setTarih(rezervasyon.getTarih());
        rezervasyon1.setMenu(rezervasyon.getMenu());
        rezervasyon1.setKullanici(rezervasyon.getKullanici());
        rezervasyon1.setOnayDurumu(false);
        return rezervasyonRepository.save(rezervasyon1);
    }

    public Rezervasyon insertRezervasyon(Rezervasyon rezervasyon) {

        if (rezervasyon.getKullanici() == null) {
            throw new RuntimeException("Kullanıcı bilgisi boş olamaz!");
        }
        int kullaniciId = rezervasyon.getKullanici().getId();

        Kullanici gercekKullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Veritabanında bu ID ile kullanıcı bulunamadı: " + kullaniciId));

        rezervasyon.setKullanici(gercekKullanici);

        if (rezervasyon.getMenu() != null) {
            Menu gercekMenu = menuRepository.findById(rezervasyon.getMenu().getMenuId())
                    .orElseThrow(() -> new RuntimeException("Menü bulunamadı"));
            rezervasyon.setMenu(gercekMenu);
        }

        rezervasyon.setOnayDurumu(false);
        return rezervasyonRepository.save(rezervasyon);
    }

    @Override
    @Transactional
    public Rezervasyon deleteRezervasyon(int id) {
        var rezervasyon1 = rezervasyonRepository.findById(id).orElse(null);
        if (rezervasyon1 != null) {
            rezervasyonRepository.deleteById(id);
            return rezervasyon1;
        }
        return null;

    }

}


