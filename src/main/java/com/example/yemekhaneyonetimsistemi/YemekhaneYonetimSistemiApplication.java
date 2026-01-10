package com.example.yemekhaneyonetimsistemi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class YemekhaneYonetimSistemiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YemekhaneYonetimSistemiApplication.class, args);
        System.out.println("YemekhaneYonetimSistemiApplication started");

    }

}
