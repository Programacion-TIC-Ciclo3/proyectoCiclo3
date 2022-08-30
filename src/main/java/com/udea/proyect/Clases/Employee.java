package com.udea.proyect.Clases;

import java.sql.Date;
import java.util.ArrayList;

public class Employee {
    private String name, email, rol;
    private int id;
    private Enterprise enterprise;
    private ArrayList<Transaction> transactions;
    private Date updatedAt, createdAt;

    public Employee(String name, String email, String rol, int id, Enterprise enterprise, Date updatedAt, Date createdAt){
        this.name = name;
        this.email = email;
        this.rol = rol;
        this.id = id;
        this.enterprise = enterprise;
        this.transactions = new ArrayList<Transaction>();
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol(){
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
 
    public Transaction getPositionTransaction (int posicion) { 
        try {
            if (posicion >= 0 && posicion < transactions.size() ) {
                return transactions.get(posicion); }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public int getTamañoTransactions () { 
        return transactions.size(); 
    }
 
    public void removeTransaction(int posicion) {  
        if (posicion >= 0 && posicion < transactions.size() ) {
            transactions.remove(posicion); }
        else { } 
    } 

    public Date getUpdatedAt(){
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
        
}