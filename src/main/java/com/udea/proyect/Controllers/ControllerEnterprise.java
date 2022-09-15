package com.udea.proyect.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udea.proyect.Entities.Enterprise;
import com.udea.proyect.Entities.Transaction;
import com.udea.proyect.Services.EnterpriseServices;


@RestController
public class ControllerEnterprise { 

    @Autowired
    private EnterpriseServices enterpriseService;

    @GetMapping("/enterprises")
    public ResponseEntity<?> getEnterprises(){
        try {
            return new ResponseEntity<>(enterpriseService.getEnterprises(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
        
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

    /*El sistema devuelve reponses 200 en la ruta /enterprises/[id]/movements con los siguientes verbos:
    GET -> Obed Rayo*/
    @GetMapping("/enterprises/{id}/movements")
    public ResponseEntity<?> getTransaction (@PathVariable Integer id){
        try {
            return new ResponseEntity<>(enterpriseService.getTransactions(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Enterprise>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/enterprises/{id}/movements")
    public ResponseEntity<?> postTransactions(@PathVariable Integer id, @RequestBody Transaction transactions){
        try {
            int container = enterpriseService.getEnterpriseById(id).getId();
            return new ResponseEntity<>(enterpriseService.setTransaction(id, transactions), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/enterprises/{idmovement}/movements")
    public ResponseEntity<?> deleteMovements(@PathVariable Integer idmovement){
        try {
            enterpriseService.deleteTransactionById(idmovement);
            return new ResponseEntity<>("Eliminado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
}
    @PatchMapping("/enterprises/{id}/movements")
    public ResponseEntity<?> patchMovements(@RequestBody Enterprise enterprise, @PathVariable Integer id) {
        return null;
        }
    }

        




    
