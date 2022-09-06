package com.udea.proyect.Repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.udea.proyect.Entities.Enterprise;

public interface RepositoriesEnterpise extends JpaRepository<Enterprise,Integer>{

    
}
