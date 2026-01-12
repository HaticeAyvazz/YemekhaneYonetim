package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Dto.KullaniciKayitDTO;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IBolumRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IDepartmanRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IKullaniciRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Service.IKullaniciService;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Bolum;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Departman;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kullanici;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryMethodInvocationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KullaniciService implements IKullaniciService {
    @Autowired
    private IKullaniciRepository kullaniciRepository;
    @Autowired
    private IBolumRepository bolumRepository;
    @Autowired
    private  IDepartmanRepository departmanRepository;
    @Autowired
    private RepositoryMethodInvocationListener repositoryMethodInvocationListener;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public Kullanici insertKullanici(KullaniciKayitDTO dto) {

        Kullanici kullanici = new Kullanici();

        //TEeml Alanlar
        kullanici.setKullaniciAdi(dto.getKullaniciAdi());
        kullanici.setRol(dto.getRol());
        kullanici.setEmail(dto.getEmail());
        kullanici.setTelefonNo(dto.getTelefonNo());
        kullanici.setKullaniciNo(dto.getKullaniciNo());

        //Şifre hashlenmiş olmalı
        kullanici.setSifre(passwordEncoder.encode(dto.getSifre()));


        // 2. Rol Bazlı Doğrulama ve Alan Ayarlaması (İş Mantığı)
        if (dto.getRol() == Role.OGRENCI) {
            // Öğrenci için zorunlu alan kontrolü
            if (dto.getKullaniciNo() == null ) {
                throw new IllegalArgumentException("Öğrenci kaydı için kullanıcı numrası ve bölüm zorunludur.");
            }
            kullanici.setKullaniciNo(dto.getKullaniciNo());

            // Bölüm entity'sini bulup set etme
            Bolum bolum = bolumRepository.findById((dto.getBolumId()))
                    .orElseThrow(() -> new RuntimeException("Belirtilen Bölüm bulunamadı."));
            kullanici.setBolum(bolum);

            kullanici.setDepartman(null); // Diğer özel alanları temizle

        } else if (dto.getRol() == Role.PERSONEL) {
            // Personel için zorunlu alan kontrolü
            if(dto.getKullaniciNo()==null){
                throw  new IllegalArgumentException("Pernosel kaydı için kullanıcı numrası ve departman zorunludur");
            }

            // Departman entity'sini bulup set etme
            Departman departman = departmanRepository.findById(dto.getDepartmanId())
                    .orElseThrow(() -> new RuntimeException("Belirtilen Departman bulunamadı."));
            kullanici.setDepartman(departman);

            kullanici.setKullaniciNo(null); // Diğer özel alanları temizle
            kullanici.setBolum(null);

        } else if (dto.getRol() == Role.ADMIN) {
            // Admin için özel alanları temizle
            kullanici.setKullaniciNo(null);
            kullanici.setBolum(null);
            kullanici.setDepartman(null);
        }

        // 3. Veritabanına kaydet
        return kullaniciRepository.save(kullanici);
    }

    @Override
    public List<Kullanici> getAllKullanici() {
        /*
        List<Kullanici> kullaniciList = kullaniciRepository.getAll();

        return kullaniciList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
                */
        return kullaniciRepository.getAll();

    }
    /*
    private KullaniciResponseDTO convertToDto(Kullanici kullanici){
        KullaniciResponseDTO dto=new KullaniciResponseDTO();

        dto.setId(kullanici.getId());
        dto.setKullaniciAdi(kullanici.getKullaniciAdi());
        dto.setRol(kullanici.getRol());
        dto.setEmail(kullanici.getEmail());
        dto.setTelefonNo(kullanici.getTelefonNo());
        dto.setKullaniciNo(kullanici.getKullaniciNo());

        if(kullanici.getBolum()!=null){
            dto.setBolumId(kullanici.getBolum().getBolumId());
            dto.setBolumAd(kullanici.getBolum().getBolumAdi());
        }
        if(kullanici.getDepartman()!=null) {
            dto.setDepartmanId(kullanici.getDepartman().getDepartmanId());
            dto.setDepartmanAd(kullanici.getDepartman().getDepartmanAdi());
        }

        return dto;
    }

     */
    @Override
    @Transactional
    public Kullanici updateKullanici(int id, Kullanici guncelKullaniciBilgisi) { // İsim karışıklığını önlemek için parametre adını değiştirdim

        Integer kullaniciId = id;
        Kullanici mevcutKullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı. ID: " + id));


        if (guncelKullaniciBilgisi.getKullaniciAdi() != null) {
            mevcutKullanici.setKullaniciAdi(guncelKullaniciBilgisi.getKullaniciAdi());
        }

        if (guncelKullaniciBilgisi.getEmail() != null) {
            mevcutKullanici.setEmail(guncelKullaniciBilgisi.getEmail());
        }


        if (guncelKullaniciBilgisi.getSifre() != null) {
            mevcutKullanici.setSifre(guncelKullaniciBilgisi.getSifre());
        }


        if (guncelKullaniciBilgisi.getTelefonNo() != null) {
            mevcutKullanici.setTelefonNo(guncelKullaniciBilgisi.getTelefonNo());
        }

        if (guncelKullaniciBilgisi.getRol() != null) {
            mevcutKullanici.setRol(guncelKullaniciBilgisi.getRol());
        }

        if (mevcutKullanici.getRol() == Role.PERSONEL) {

            // Departman güncellemesi: Eğer yeni departman ID gönderilmişse
            if (guncelKullaniciBilgisi.getDepartman() != null) {

                Integer departmanId = guncelKullaniciBilgisi.getDepartman().getDepartmanId();

                Departman yeniDepartman = departmanRepository.findById(departmanId)
                        .orElseThrow(() -> new RuntimeException("Departman bulunamadı. ID: " + departmanId));

                mevcutKullanici.setDepartman(yeniDepartman);
            }

        } else if (mevcutKullanici.getRol() == Role.OGRENCI) {

            if (guncelKullaniciBilgisi.getKullaniciNo() != null) {
                mevcutKullanici.setKullaniciNo(guncelKullaniciBilgisi.getKullaniciNo());
            }

            if (guncelKullaniciBilgisi.getBolum() != null) {

                Integer bolumId = guncelKullaniciBilgisi.getBolum().getBolumId();

                Bolum yeniBolum = bolumRepository.findById(bolumId)
                        .orElseThrow(() -> new RuntimeException("Bölüm bulunamadı. ID: " + bolumId));

                mevcutKullanici.setBolum(yeniBolum);
            }
        }
        return kullaniciRepository.save(mevcutKullanici);
    }


    @Override
    @Transactional
    public Kullanici deleteKullanici(int id) {
        var kullanici=kullaniciRepository.findById(id)
                .orElseThrow(()->new RuntimeException("user is not found"));

        kullaniciRepository.deleteById(id);
        return kullanici;
    }
}


