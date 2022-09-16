package com.udea.proyect.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping("/login")
    public String login(){
        return "Login";
    }
    
}
