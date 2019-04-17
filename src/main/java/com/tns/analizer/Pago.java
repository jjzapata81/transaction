package com.tns.analizer;

import javafx.scene.input.DataFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pago {
    private Date fecha_pago;
    private int monto;
    private String descripcion;


    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
