package com.udea.proyect.Controllers;

import com.udea.proyect.Entities.Transaction;
import com.udea.proyect.Services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerTransaction {
    @Autowired
    private TransactionServices transactionServices;

    @GetMapping("/transaction")
    public ResponseEntity<List<Transaction>> getTransaction(){
        return new ResponseEntity<>(transactionServices.getTransaction(), HttpStatus.OK);
    }

    @PostMapping("/enterprises/{id}/movements")
    public ResponseEntity<?> setTransaction(@PathVariable Integer id, @RequestBody Transaction transaction_update){
        try {
            return new  ResponseEntity<>(transactionServices.setTransaction(id, transaction_update), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/enterprises/{id}/movements")
    public ResponseEntity<?> setTransactionPatch (@PathVariable Integer id, @RequestBody Transaction transaction_update) {
        try {
            return new ResponseEntity<>(transactionServices.setTransactionPatch(id, transaction_update), HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
}
}
