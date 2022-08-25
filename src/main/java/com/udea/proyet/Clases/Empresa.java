package com.udea.proyet.Clases;

public class Empresa {
    private String nombre, direccion;
    private int telefono, NIT;

    public Empresa(String nombre, String direccion, int telefono, int NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
}

    public String getNombre() {
        return nombre;
        }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        }

    public String getDireccion() {
        return direccion;
        }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
        }
    
    public String getTelefono() {
        return telefono + "";
        }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
        }
    
    public String getNIT(){
        return NIT + "";
        }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public String toString(){
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", NIT=" + NIT +
                '}';
                }

}
    

