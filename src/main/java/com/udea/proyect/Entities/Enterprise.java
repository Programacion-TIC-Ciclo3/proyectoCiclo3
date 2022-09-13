package com.udea.proyect.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Column
    private String name;
    @Column
    private String document;
    @Column
    private String phone;
    @Column
    private String address;
    @Id
    private int id;
    @OneToMany(mappedBy = "enterprise")
    private List<Employee> users;
    @OneToMany(mappedBy = "enterprise")
    private static List<Transaction> transactions;
    @Column
    private LocalDate createdAt;
    @Column
    private LocalDate updatedAt;


    public Enterprise(String name, String document, String phone, String address, int id, LocalDate createdAt, LocalDate updatedAt, List<Transaction> transactions, List<Employee> users) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.id = id;
        this.users = users;
        this.transactions = transactions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
}

    public Enterprise(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public String getDocument() {  
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Employee> getUsers(){
        return users;
    }

    public void setUsers(List<Employee> users) {
        this.users = users;
    }

    public String toString() {
        return ("Enterprise {name=" + name + ", document=" + document + ", phone=" + phone + ", adress=" + address + ", id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "}");

}
}
    
