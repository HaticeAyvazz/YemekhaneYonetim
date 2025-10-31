package com.example.yemekhaneyonetimsistemi.Service.ımpl;

import com.example.yemekhaneyonetimsistemi.Service.IAdminService;
import com.example.yemekhaneyonetimsistemi.entity.Admin;
import com.example.yemekhaneyonetimsistemi.repository.IAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    private IAdminRepository adminRepository;

    public AdminService(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }



    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin insertAdmin(Admin admin) {
        return adminRepository.save(admin);
    }


    @Override
    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }


    @Override
    public Admin updateAdmin(Admin adminDetails, int id) {
        Admin admin=adminRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Admin id not found"));

        if(adminDetails.getKullaniciAdi()!=null){
            admin.setKullaniciAdi(adminDetails.getKullaniciAdi());
        }
        if(adminDetails.getKullaniciSoyadi()!=null){
            admin.setKullaniciAdi(adminDetails.getKullaniciSoyadi());
        }
        if(adminDetails.getSifre()!=null){
            admin.setSifre(adminDetails.getSifre());
        }

        return adminRepository.save(admin);
    }

}
