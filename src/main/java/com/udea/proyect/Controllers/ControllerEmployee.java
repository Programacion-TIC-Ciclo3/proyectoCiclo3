package com.udea.proyect.Controllers;

import com.udea.proyect.Entities.Employee;
import com.udea.proyect.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ControllerEmployee {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/users")
    public ResponseEntity<List<Employee>> getEmployee(){
        return new ResponseEntity<>(employeeServices.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Employee> getEmployee (@PathVariable Integer id){
        try {
            Employee employee = employeeServices.getEmployeeById(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveEmployee (@RequestBody Employee employee){
        try{
            employeeServices.createEmployee(employee);
            return new ResponseEntity<Employee>(employee,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<?> putEmployee(@RequestBody Employee usuario_update, @PathVariable Integer id) {
        try {
            Employee usuario_bd = employeeServices.setEmployeeById(usuario_update, id);

            return new ResponseEntity<>(usuario_bd, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteEnterprise(@PathVariable Integer id){
        try {
            employeeServices.deleteEmployeeById(id);
            return new ResponseEntity<>("Empleado eliminado exitosamente",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



    
