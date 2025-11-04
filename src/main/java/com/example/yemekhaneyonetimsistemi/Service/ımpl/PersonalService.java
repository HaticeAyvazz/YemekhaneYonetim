package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IPersonalService;
import com.example.yemekhaneyonetimsistemi.entity.Departman;
import com.example.yemekhaneyonetimsistemi.entity.Personel;
import com.example.yemekhaneyonetimsistemi.Repository.IPersonalRepository;
import org.aspectj.weaver.loadtime.Options;
import org.springframework.stereotype.Service;
import com.example.yemekhaneyonetimsistemi.Repository.IDepartmanRepository;

import java.util.List;

@Service
public class PersonalService implements IPersonalService {

    private IPersonalRepository personalRepository;
    private IDepartmanRepository departmanRepository;


    public PersonalService(IPersonalRepository personalRepository) {

        this.personalRepository = personalRepository;
        this.departmanRepository=departmanRepository;
    }


    @Override
    public List<Personel> getAllPersonal() {
        return personalRepository.getAll();
    }


    @Override
    public Personel insertPersonal(Personel personel) {
        return personalRepository.save(personel);
    }


    @Override
    public void deletePersonal(int id) {
         personalRepository.deleteById(id);
    }


    @Override
    public Personel updatePersonal(Personel personelDetails, int id) {
        Personel personel=personalRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Dont find Personel"));

        if(personelDetails.getKullaniciAdi()!=null){
            personel.setKullaniciAdi(personelDetails.getKullaniciAdi());
        }
        if(personelDetails.getKullaniciSoyadi()!=null){
            personel.setKullaniciSoyadi(personelDetails.getKullaniciSoyadi());
        }
        if(personelDetails.getTelefonNo()!=null){
            personel.setTelefonNo(personelDetails.getTelefonNo());
        }
        if(personelDetails.getEmail()!=null){
            personel.setEmail(personelDetails.getEmail());
        }
        if(personelDetails.getSifre()!=null){
            personel.setSifre(personelDetails.getSifre());
        }
        if(personelDetails.getDepartman()!=null){
           personel.setDepartman(personelDetails.getDepartman());
        }
        return personalRepository.save(personel);

    }
}
