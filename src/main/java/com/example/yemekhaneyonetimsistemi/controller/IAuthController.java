package com.example.yemekhaneyonetimsistemi.controller;

import com.example.yemekhaneyonetimsistemi.entity.Kullanici;
import org.springframework.http.ResponseEntity;

public interface IAuthController {
    ResponseEntity<Kullanici> register(Kullanici kullanici);
}
