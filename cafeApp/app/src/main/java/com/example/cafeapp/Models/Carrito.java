package com.example.cafeapp.Models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Carrito implements Serializable {
    private Producto[] aProd;
    private int[] iCant;
    private String fecha;
    private String hour;

    public Carrito(Producto[] aProd, int[] iCant, String fecha, String hour) {
        this.aProd = aProd;
        this.iCant = iCant;
        this.fecha = fecha;
        this.hour = hour;
    }

    public Carrito() {
        this.aProd = null;
        this.iCant = null;
        this.fecha = "";
        this.hour = "";
    }

    public Producto[] getaProd() {
        return aProd;
    }

    public void setaProd(Producto[] aProd) {
        this.aProd = aProd;
    }

    public int[] getiCant() {
        return iCant;
    }

    public void setiCant(int[] iCant) {
        this.iCant = iCant;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
