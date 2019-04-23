package com.example.cafeapp.Models;

public class Producto {
    private String nomProd;
    private int precio;

    public Producto(String nomProd, int precio) {
        this.nomProd = nomProd;
        this.precio = precio;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
