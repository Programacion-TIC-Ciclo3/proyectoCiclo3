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

    @GetMapping("/transaction/{id}")
    public ResponseEntity<Transaction> getTransaction (@PathVariable Integer id){
        try {
            Transaction transaction = transactionServices.getTransactionById(id);
            return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> saveEnterprise (@RequestBody Transaction transaction){
        try{
            transactionServices.createTransaction(transaction);
            return new ResponseEntity<Transaction>(transaction,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/transaction/{id}")
    public ResponseEntity<?> putEnterprise(@RequestBody Transaction transaction, @PathVariable Integer id) {
        try {
            Transaction newTransaction = transactionServices.getTransactionById(id);
            newTransaction.setId(transaction.getId());
            newTransaction.setConcept(transaction.getConcept());
            newTransaction.setAmount(transaction.getAmount());
            newTransaction.setUser(transaction.getUser());
            newTransaction.setCreatedAt(transaction.getCreatedAt());
            newTransaction.setUpdatedAt(transaction.getUpdatedAt());
            newTransaction.setEnterprise(transaction.getEnterprise());

            transactionServices.createTransaction(newTransaction);

            return new ResponseEntity<>(newTransaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/transaction/{id}")
    public ResponseEntity<?> deleteEnterprise(@PathVariable Integer id){
        try {
            transactionServices.deleteTransactionById(id);
            return new ResponseEntity<>("transacion eliminada exitosamente",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
