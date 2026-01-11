package com.example.yemekhaneyonetimsistemi.Dto;

import com.example.yemekhaneyonetimsistemi.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KullaniciKayitDTO {
    private String kullaniciAdi;
    private String sifre;
    private Role rol;
    private String email;
    private String telefonNo;

    // Role özel alanlar
    private String kullaniciNo;
    private int bolumId;
    private int departmanId;
}
