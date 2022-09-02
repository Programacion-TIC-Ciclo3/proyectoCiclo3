package com.udea.proyect.Entities;

import java.time.LocalDate;



public class Transaction {
    private double amount;
    private int id;
    private String concept;
    private Employee user;
    private Enterprise enterprise;
    private LocalDate updatedAt;
    private LocalDate createdAt;

    public Transaction (int id, String concept, double amount, Employee user, Enterprise enterprise, LocalDate createdAt, LocalDate  updatedAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.user = user;
        this.enterprise = enterprise;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
         this.concept = concept;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Employee user() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public Enterprise enterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String toString() {
        return ("Transaction {id=" + id + ", concept=" + concept + ",amount=" + amount + ", user=" + user +", enterprise=" + enterprise + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt +"}");
    
}
}