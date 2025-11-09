package com.example.yemekhaneyonetimsistemi.Login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginPageController {
    @Value("${user.name}")
    private String username;

    @Value("${team.name}")
    private String teamname;

    @GetMapping("/")
    public String GetIndexPage(){
        return new String("username :" +username+"team name :"+teamname);
    }
}
