package com.udea.proyect.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.udea.proyect.Entities.Enterprise;
import com.udea.proyect.Entities.Transaction;

public interface RepositoriesEnterpise extends JpaRepository<Enterprise,Integer>{

    List<Transaction> getTransactions(Integer id);

    
}
