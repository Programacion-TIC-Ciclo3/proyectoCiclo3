package com.udea.proyect.Clases;

public class MovimientoDinero {
    private int monto, valor;
    private String concepto, tipoMonto;
    private Empleado usuario;

    public MovimientoDinero (int monto, int valor, String concepto, String tipoMonto, Empleado usuario){
        this.monto = monto;
        this.valor = valor;
        this.concepto = concepto;
        this.tipoMonto = tipoMonto;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getTipoMonto() {
        return tipoMonto;
    }

    public void setTipoMonto(String tipoMonto) {
        this.tipoMonto = tipoMonto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "monto='" + monto + '\'' +
                ", valor='" + valor + '\'' +
                ", concepto='" + concepto + '\'' +
                ", tipoMonto=" + tipoMonto +
                ", usuario=" + usuario +
                '}';
                }
    }
               
    

