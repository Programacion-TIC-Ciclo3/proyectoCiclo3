package com.udea.proyect.Controllers;

import com.udea.proyect.Entities.Employee;
import com.udea.proyect.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerTransaction {
    @Autowired
    private TransactionServices transactionServices;

    @GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getEnterprises(){
        return new ResponseEntity<>(enterpriseService.getEnterprises(), HttpStatus.OK);
    }

    @GetMapping("/enterprises/{id}")
    public ResponseEntity<Enterprise> getEnterprise (@PathVariable Integer id){
        try {
            Enterprise enterprise = enterpriseService.getEnterpriseById(id);
            return new ResponseEntity<Enterprise>(enterprise, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Enterprise>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/enterprises")
    public ResponseEntity<Enterprise> saveEnterprise (@RequestBody Enterprise enterprise){
        try{
            enterpriseService.createEnterprise(enterprise);
            return new ResponseEntity<Enterprise>(enterprise,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/enterprises/{id}")
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

    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity<?> deleteEnterprise(@PathVariable Integer id){
        try {
            enterpriseService.deleteEnterpriseById(id);
            return new ResponseEntity<>("Empresa eliminada exitosamente",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}