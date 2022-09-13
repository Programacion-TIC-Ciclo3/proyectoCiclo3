package com.udea.proyect.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.proyect.Entities.Enterprise;
import com.udea.proyect.Entities.Transaction;
import com.udea.proyect.Repositories.RepositoriesEnterpise;

@Service
public class EnterpriseServices {
    @Autowired
    private RepositoriesEnterpise repositoryEnterprise;


    public List<Enterprise> getEnterprises(){
        return repositoryEnterprise.findAll();
    }

    public String createEnterprise(Enterprise enterprise){
        repositoryEnterprise.save(enterprise);
        return "Empresa creada exitosamente";
    }

    public Enterprise getEnterpriseById(Integer id){
        return repositoryEnterprise.findById(id).get();
    }

    public String deleteEnterpriseById(Integer id){
        repositoryEnterprise.deleteById(id);
        return "Empresa eliminada correctamente";
    }

    public List<Transaction> getTransactions(Integer id){
        return repositoryEnterprise.getTransactions(id);
    }

}
