package com.udea.proyect;

import com.udea.proyect.Entities.*;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectApplication.class, args);

		//Examples
		Enterprise enterprise = new Enterprise("dwuwd", "82839", "0348340", "892803", 1234, LocalDate.of(2010,8,6), LocalDate.of(2011,8,9));
		System.out.println("Empresa= "+enterprise.toString());
		System.out.println("////////////////////////////////");
		Profile profile = new Profile("Juan", "url", "3124456789", LocalDate.of(2018, 8, 23), LocalDate.of(2020, 9, 18));
		Role role = Role.OPERARIO;
		Employee user = new Employee("Juan", "Juan@juan.com", role, 1234, enterprise, profile, LocalDate.of(2022, 06, 25), LocalDate.of(2022, 8, 17));
		System.out.println("Usuario= " +user.toString());
		System.out.println("////////////////////////");
		Transaction transaction = new Transaction(12345, "Cambio", 56.78, user, enterprise, LocalDate.of(120,5,28), LocalDate.of(123,6,18));
		System.out.println("Transaction = " +transaction.toString());
		System.out.println(transaction.getId());
		enterprise.addUser(user);
		System.out.println(enterprise.getPositionUser(0));
	}

}
 