package com.udea.proyect.Clases;

public class Empleado {
    private String nombre, correoElectronico, rol;
    private Empresa empresa;

    public Empleado(String nombre, String correoElectronico, String rol, Empresa empresa) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.rol = rol;
        this.empresa = empresa;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRolo() {
        return rol;
    }

    public void setRolo(String rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", rol='" + rol + '\'' +
                ", empresa=" + empresa +
                '}';
                }    
}
