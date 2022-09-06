package com.udea.proyect.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udea.proyect.Entities.Enterprise;
import com.udea.proyect.Services.EnterpriseServices;


@RestController
public class ControllerEnterprise { 

    @Autowired
    private EnterpriseServices enterpriseService;

    @GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getEnterprises(){
        return new ResponseEntity<>(enterpriseService.getEnterprises(), HttpStatus.OK);
    }

    @GetMapping("/enterprise/{id}")
    public ResponseEntity<Enterprise> getEnterprise (@PathVariable Integer id){
        try {
            Enterprise enterprise = enterpriseService.getEnterpriseById(id);
            return new ResponseEntity<Enterprise>(enterprise, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Enterprise>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/enterprise")
    public ResponseEntity<Enterprise> saveEnterprise (@RequestBody Enterprise enterprise){
        try{
            enterpriseService.createEnterprise(enterprise);
            return new ResponseEntity<Enterprise>(enterprise,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/enterprise/{id}")
    public ResponseEntity<?> putEnterprise(@RequestBody Enterprise enterprise, @PathVariable Integer id) {
        try {
            Enterprise newEnterprise = enterpriseService.getEnterpriseById(id);
            newEnterprise.setName(enterprise.getName());
            newEnterprise.setAddress(enterprise.getAddress());
            newEnterprise.setDocument(enterprise.getDocument());
            newEnterprise.setCreatedAt(enterprise.getCreatedAt());
            newEnterprise.setUpdatedAt(enterprise.getUpdatedAt());
            newEnterprise.setPhone(enterprise.getPhone());

            enterpriseService.createEnterprise(newEnterprise);

            return new ResponseEntity<>(newEnterprise, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/enterprise/{id}")
    public ResponseEntity<?> deleteEnterprise(@PathVariable Integer id){
        try {
            enterpriseService.deleteEnterpriseById(id);
            return new ResponseEntity<>("Empresa eliminada exitosamente",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



    
