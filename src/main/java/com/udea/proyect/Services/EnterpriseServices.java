package com.udea.proyect.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.udea.proyect.Entities.Enterprise;
import com.udea.proyect.Repositories.RepositoriesEnterpise;

public class EnterpriseServices {
    @Autowired
    private RepositoriesEnterpise repositoryEnterprise;


    public List<Enterprise> getEnterprise(){
        return repositoryEnterprise.findAll();
    }

    public String createEnterprise(Enterprise enterprise){
        repositoryEnterprise.save(enterprise);
        return "Empresa creada exitosamente";
    }

    public Enterprise getEnterpriseById(Integer id){
        return repositoryEnterprise.findById(id).get();
    }

    public String deleteEmployeeById(Integer id){
        repositoryEnterprise.deleteById(id);
        return "Usuario eliminado correctamente";
    }

    public String deleteEmployee(Enterprise enterprise){
        repositoryEnterprise.delete(enterprise);
        return "Usuario eliminado correctamente";
    }


    @Transactional
    public Enterprise updateEnterprise(Enterprise enterprise, Integer id) throws Exception{
        repositoryEnterprise.upddate(enterprise.getName(), enterprise.getPhone(), enterprise.getAddress(), enterprise.getCreatedAt(), enterprise.getUpdatedAt(), enterprise.getDocument());
        return getEnterpriseById(id);
    }
}
