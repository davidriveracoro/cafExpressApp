package com.example.cafeapp.Models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Compra implements Serializable {
    private int numPedido;
    private double precio;
    private String fecha;
    private String hour;
    private String status;
    private int idCarrito;

    public Compra(int numPedido, double precio, String fecha, String hour, String status, int idCarrito) {
        this.numPedido = numPedido;
        this.precio = precio;
        this.fecha = fecha;
        this.hour = hour;
        this.status = status;
        this.idCarrito = idCarrito;
    }

    public Compra() {
        this.numPedido = 0;
        this.precio = 0.0;
        this.fecha = "";
        this.hour = "";
        this.status = "";
        this.idCarrito = 0;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }
}
