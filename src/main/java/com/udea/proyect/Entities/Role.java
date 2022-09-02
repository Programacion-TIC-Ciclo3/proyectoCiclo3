package com.udea.proyect.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public enum Role{
	ADMINISTRADOR("Administrador", null), OPERARIO("Operario", null); 
	@Column
	private String role;
    @Column
    private Employee user;
	
	private Role (String roleString, Employee user) {
		this.role = roleString;
        this.user = user;
	}

	public String getRole() {
		return role;
	}

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }
}
