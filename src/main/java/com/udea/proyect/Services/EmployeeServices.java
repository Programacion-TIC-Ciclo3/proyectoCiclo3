package com.udea.proyect.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.proyect.Entities.Employee;
import com.udea.proyect.Repositories.RepositoriesEmployee;

@Service
public class EmployeeServices {
    @Autowired
    private RepositoriesEmployee repositoryEmployee;


    public List<Employee> getEmployees(){
        return repositoryEmployee.findAll();
    }

    public String createEmployee(Employee employee){
        repositoryEmployee.save(employee);
        return "Usuario creado exitosamente";
    }

    public Employee getEmployeeById(Integer id){
        return repositoryEmployee.findById(id).get();
    }

    public String deleteEmployeeById(Integer id){
        repositoryEmployee.deleteById(id);
        return "Usuario eliminado correctamente";
    }

    public Employee setEmployeeById(Employee usuario_update, Integer id) throws Exception{
        try {
        Employee usuario_bd = getEmployeeById(id);
        

        if(usuario_update.getName() != null && !usuario_update.getName().equals("")){
            usuario_bd.setName(usuario_update.getName());
        }
        if(usuario_update.getEmail() != null && !usuario_update.getEmail().equals("")){
            usuario_bd.setEmail(usuario_update.getEmail());
        }
        if(usuario_update.getCreatedAt() != null && !usuario_update.getCreatedAt().equals("")){
            usuario_bd.setCreatedAt(usuario_update.getCreatedAt());    
        }
        if(usuario_update.getEnterprise() != null && !usuario_update.getEnterprise().equals("")){
            usuario_bd.setEnterprise(usuario_update.getEnterprise());
        }
        if(usuario_update.getProfile() != null && !usuario_update.getProfile().equals("")){
            usuario_bd.setProfile(usuario_update.getProfile());
        }
        if(usuario_update.getRol() != null && !usuario_update.getRol().equals("")){
            usuario_bd.setRol(usuario_update.getRol());
        }
        if(usuario_update.getTransactions() != null && !usuario_update.getTransactions().equals("")){
            usuario_bd.setTransactions(usuario_update.getTransactions());
        }
        if(usuario_update.getUpdatedAt() != null && !usuario_update.getUpdatedAt().equals("")){
            usuario_bd.setUpdatedAt(usuario_update.getUpdatedAt());
        }

        return repositoryEmployee.save(usuario_bd);

    } catch (Exception e) {
        throw new Exception("Usuario NO existe, fallo actualización de datos");
    }
}
}


    

