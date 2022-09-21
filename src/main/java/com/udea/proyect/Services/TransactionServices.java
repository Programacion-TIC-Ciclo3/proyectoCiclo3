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

    public Transaction createTransaction(Transaction transaction){
        return repositoryTransaction.save(transaction);
    }

    public Transaction getTransactionById(Integer id){
        return repositoryTransaction.findById(id).get();
    }

    public String deleteTransactionById(Integer id){
        repositoryTransaction.deleteById(id);
        return "Transacion eliminado correctamente";
    }

    public Transaction setTransaction(Integer id, Transaction transaction_update){
        Transaction transaction_bd = new Transaction();
        
        transaction_bd.setAmount(transaction_update.getAmount());
        transaction_bd.setConcept(transaction_update.getConcept());
        transaction_bd.setCreatedAt(transaction_update.getCreatedAt());
        transaction_bd.setUpdatedAt(transaction_update.getUpdatedAt());
        transaction_bd.setEnterprise(transaction_update.getEnterprise());
        transaction_bd.setId(transaction_update.getId());
        transaction_bd.setUser(transaction_update.getUser());

        return repositoryTransaction.save(transaction_bd);
    }

    public Transaction setTransactionPatch(Integer id, Transaction transaction_update) throws Exception{
        try {
        
        Transaction transaction_bd = getTransactionById(id);
        
        if (transaction_update.getConcept() != null && !transaction_update.getConcept().equals("")){
            transaction_bd.setConcept(transaction_update.getConcept());
        }

        if (transaction_update.getCreatedAt() != null && !transaction_update.getCreatedAt().equals("")){
            transaction_bd.setCreatedAt(transaction_update.getCreatedAt());
        }

        if (transaction_update.getUpdatedAt() != null && !transaction_update.getUpdatedAt().equals("")){
            transaction_bd.setUpdatedAt(transaction_update.getUpdatedAt());
        }

        if (transaction_update.getEnterprise() != null && !transaction_update.getEnterprise().equals("")){
            transaction_bd.setEnterprise(transaction_update.getEnterprise());
        }

        if (transaction_update.getAmount() != 0){
            transaction_bd.setAmount(transaction_update.getAmount());
        }

        if (transaction_update.getUser() != null && !transaction_update.getUser().equals("")){
            transaction_bd.setUser(transaction_update.getUser());
        }

        return repositoryTransaction.save(transaction_bd);
        } catch (Exception e) {
            throw new Exception("Transaccion NO existe, fallo actualización de datos");
    }

    
}
}
