package com.udea.proyect.Controllers;

import com.udea.proyect.Entities.Employee;
import com.udea.proyect.Entities.Enterprise;
import com.udea.proyect.Entities.Transaction;
import com.udea.proyect.Entities.User;
import com.udea.proyect.Services.EmployeeServices;
import com.udea.proyect.Services.EnterpriseServices;
import com.udea.proyect.Services.TransactionServices;
import com.udea.proyect.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FrontendController {

    UserService userService;
    @Autowired
    EmployeeServices employeeServices;
    EnterpriseServices enterpriseService;
    TransactionServices transactionServices;

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

    @GetMapping("/NewMovimiento")
    public String newTransaction(){   
        return "newTransaction";
    }

    @GetMapping("/principal")
    public String Principal(){
        return "principal";
    }

    @GetMapping("/prueba")
    public String employees(Model model){
        model.addAttribute("employee", employeeServices.getEmployees());
        return "prueba";
    }
    @GetMapping("/NewEmpresa")
    public String newEnterprise(){
        return "benterprise";
    }
    @GetMapping("/NewUsuario")
    public String newEmploye(){
        return "buser";
    }
    @GetMapping("/Movimiento")
    public String newMovimiento(Model model){
        model.addAttribute("transaction", this.transactionServices.getTransaction());
        return "amovimiento";
    }
    @GetMapping("/Empresa")
    public String newEmpresa(Model model){
        try {
            model.addAttribute("enterprise", this.enterpriseService.getEnterprises());
            return "aenterprise";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }
    @GetMapping("/Usuario")
    public String newUsuario(Model model){
        model.addAttribute("employee", this.employeeServices.getEmployees());
        return "auser";
    }

    @DeleteMapping("/Employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeServices.deleteEmployeeById(id);
        return "redirect:/Usuario";
    }
}
