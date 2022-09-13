package com.udea.proyect.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transaction")
public class Transaction {
    public static int size;
    @Column
    private double amount;
    @Id
    private int id;
    @Column
    private String concept;
    @JsonIgnore
    @ManyToOne
    private Employee user;
    @ManyToOne
    private Enterprise enterprise;
    @Column
    private LocalDate updatedAt;
    @Column
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

    public Transaction(){
        
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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }


    public Enterprise getEnterprise() {
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
/*estas clase las cree porque me salia error en el controlador revisar luego 
    public Employee getuser() {
        return null;
    }

    public Enterprise getenterprise() {
        return null;
    }*/
}