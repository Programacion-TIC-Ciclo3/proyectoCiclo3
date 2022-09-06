package com.udea.proyect.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.proyect.Entities.Employee;
import com.udea.proyect.Repositories.RepositoriesEmployee;

import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;


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

    public String deleteEmployee(Employee employee){
        repositoryEmployee.delete(employee);
        return "Usuario eliminado correctamente";
    }


    @Transactional
    public Employee updateEmployee(Employee employee, Integer id) throws Exception{
        repositoryEmployee.upddate(employee.getName(), employee.getEmail(), employee.getCreatedAt(), employee.getUpdatedAt(), employee.getProfile(), employee.getRol(), employee.getEnterprise(), id);
        return getEmployeeById(id);
    }

    }


    

