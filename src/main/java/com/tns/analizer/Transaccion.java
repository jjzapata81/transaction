package com.tns.analizer;

public class Transaccion {

    private String fecha;
    private long monto;
    private String categoria;

    public Transaccion(String fecha, long monto, String categoria) {
        this.fecha = fecha;
        this.monto = monto;
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
