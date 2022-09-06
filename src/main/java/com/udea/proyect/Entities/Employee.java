package com.udea.proyect.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Role role;
    @Id
    private int id;
    @ManyToOne
    private Enterprise enterprise;
    @Column
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
    @Column
    private LocalDate updatedAt;
    @Column
    private LocalDate createdAt;
    @OneToOne(mappedBy = "user")
    private Profile profile;

    public Employee(String name, String email, Role role, int id, Enterprise enterprise, Profile profile, LocalDate updatedAt, LocalDate createdAt, List<Transaction> transactions){
        this.name = name;
        this.email = email;
        this.role = role;
        this.id = id;
        this.enterprise = enterprise;
        this.transactions = transactions;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.profile = profile;
    }

    public Employee(){

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    public LocalDate getUpdatedAt(){
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String toString() {
        return ("Employee {name=" + name + ", email=" + email + ", role=" + role + ", id=" + id + ", enterprise= " + enterprise + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "}");
        
}
}