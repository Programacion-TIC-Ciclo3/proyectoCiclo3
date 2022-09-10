package com.udea.proyect.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.proyect.Entities.Transaction;
import com.udea.proyect.Repositories.RepositoriesTransaction;

@Service
public class TransactionServices {

    @Autowired
    private RepositoriesTransaction repositoryTransaction;

    public List<Transaction> getTransaction(){
        return repositoryTransaction.findAll();
    }

    public String createTransaction(Transaction transaction){
        repositoryTransaction.save(transaction);
        return "Transaction creada exitosamente";
    }

    public Transaction getTransactionById(Integer id){
        return repositoryTransaction.findById(id).get();
    }

    public String deleteTransactionById(Integer id){
        repositoryTransaction.deleteById(id);
        return "Transacion eliminado correctamente";
    }
    
}
