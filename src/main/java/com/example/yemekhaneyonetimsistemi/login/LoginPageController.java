package com.example.yemekhaneyonetimsistemi.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginPageController{

    @Value("${user.name}")
    private String userName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String getIndexPage(){
        return new String("Username:" +userName+ "Team name:" +teamName);
    }


}