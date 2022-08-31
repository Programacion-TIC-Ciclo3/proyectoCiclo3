package com.udea.proyect;

import com.udea.proyect.Clases.Employee;
import com.udea.proyect.Clases.Enterprise;
import com.udea.proyect.Clases.Transaction;

import java.util.Date;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class ProyectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProyectApplication.class, args);
		Enterprise enterprise = new Enterprise("dwuwd", "82839", "0348340", "892803", 1234, new Date(10,8,6), new Date(11,8,9));
		System.out.println("Empresa= "+enterprise.toString());
		System.out.println("////////////////////////////////");
		Employee user = new Employee("juan", "email", "Administrador", 3456, enterprise, new Date(122,1,1), new Date(120,2,4));
		System.out.println("Usuario= " +user.toString());
		System.out.println("////////////////////////");
		Transaction transaction = new Transaction(12345, "Cambio", 56.78, user, enterprise, new Date(120,5,28), new Date(123,6,18));
		System.out.println("Transaction = " +transaction.toString());
	}

}
 