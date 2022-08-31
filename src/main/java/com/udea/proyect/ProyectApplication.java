package com.udea.proyect;

import com.udea.proyect.Clases.Employee;
import com.udea.proyect.Clases.Enterprise;
import com.udea.proyect.Clases.Profile;
import com.udea.proyect.Clases.Role;
import com.udea.proyect.Clases.Transaction;

import java.util.Date;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class ProyectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProyectApplication.class, args);

		//Examples
		Enterprise enterprise = new Enterprise("dwuwd", "82839", "0348340", "892803", 1234, new Date(10,8,6), new Date(11,8,9));
		System.out.println("Empresa= "+enterprise.toString());
		System.out.println("////////////////////////////////");
		Profile profile = new Profile("1234", "image", "123456789", new Date(102,5,12), new Date(106,7,16));
		Role role = new Role("admin");
		Employee user = new Employee("Juan", "email", role, 1234, enterprise, profile, new Date(102,5,12), new Date(106,7,16));
		System.out.println("Usuario= " +user.toString());
		System.out.println("////////////////////////");
		Transaction transaction = new Transaction(12345, "Cambio", 56.78, user, enterprise, new Date(120,5,28), new Date(123,6,18));
		System.out.println("Transaction = " +transaction.toString());
		System.out.println(transaction.getId());
		enterprise.addUser(user);
		System.out.println(enterprise.getPositionUser(0));
	}

}
 