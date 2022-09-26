package com.udea.proyect.Controllers;

import com.udea.proyect.Entities.User;
import com.udea.proyect.Services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    UserService userService;

    public FrontendController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexModel (Model model, @AuthenticationPrincipal OidcUser principal){

        if(principal != null){
            User user = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user", user);

        }
        return "index";
    }

    @GetMapping("/NewTransaction")
    public String newTransaction(){
        return "newTransaction";
    }

    @GetMapping("/principal")
    public String Principal(){
        return "principal";
    }
    @GetMapping("/Enterprise")
    public String newEnterprise(){
        return "aenterprise";
    }
    
}
