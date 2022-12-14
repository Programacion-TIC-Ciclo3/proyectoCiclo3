package com.udea.proyect.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="email", unique = true)
    private String email;
    @Column(name="image")
    private String image;
    @Column(name="auth0id", unique = true)
    private String auth0id;

    public User(){
    }

    public User(String email, String image, String auth0id) {
        this.email = email;
        this.image = image;
        this.auth0id = auth0id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuth0id() {
        return auth0id;
    }

    public void setAuth0Id(String auth0id) {
        this.auth0id = auth0id;
    }
}
