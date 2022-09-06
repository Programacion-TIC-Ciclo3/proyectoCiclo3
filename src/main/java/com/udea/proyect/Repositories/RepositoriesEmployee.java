package com.udea.proyect.Repositories;



import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.udea.proyect.Entities.*;


public interface RepositoriesEmployee extends JpaRepository<Employee,Integer>{

    @Modifying
    @Query("UPDATE Usuario u SET u.nombre = :nombre, u.email = :email, u.createdAt = :createdAt, u.updatedAt = :updated, u.profile = :profile, u.Rol = :Rol , u.enterprise = :enterprise WHERE u.nombreUsuario = :id")
    public int upddate(String nombre, String email, LocalDate createdAt, LocalDate updatedAt, Profile profile, Role role, Enterprise enterprise);

    
}
