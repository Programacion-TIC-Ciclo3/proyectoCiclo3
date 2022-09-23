package com.udea.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udea.proyect.Entities.Transaction;

public interface RepositoriesTransaction extends JpaRepository<Transaction,Integer>{
    
}
