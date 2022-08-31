package com.udea.proyect.Entities;

import java.util.Date;
import java.util.ArrayList;

public class Employee {
    private String name, email;
    private Role role;
    private int id;
    private Enterprise enterprise;
    private ArrayList<Transaction> transactions;
    private Date updatedAt, createdAt;
    private Profile profile;

    public Employee(String name, String email, Role role, int id, Enterprise enterprise, Profile profile, Date updatedAt, Date createdAt){
        this.name = name;
        this.email = email;
        this.role = role;
        this.id = id;
        this.enterprise = enterprise;
        this.transactions = new ArrayList<Transaction>();
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.profile = profile;
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

    public Role getRol(){
        return role;
    }

    public void setRol(Role role) {
        this.role = role;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String toString() {
        return ("name=" + name + ", createdAt=" + createdAt + ", email=" + email + ", role=" + role + ", id=" + id + ", enterprise" + enterprise + ", updatedAt=" + updatedAt + ")");
        
}
}