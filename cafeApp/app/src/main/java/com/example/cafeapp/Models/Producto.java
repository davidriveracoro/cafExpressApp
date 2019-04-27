package com.example.cafeapp.Models;

public class Producto {
    private String nomProd;
    private int precio;
    private int idMenu;

    public Producto(String nomProd, int precio) {
        this.nomProd = nomProd;
        this.precio = precio;
    }

    public Producto(String nomProd, int precio, int idMenu) {
        this.nomProd = nomProd;
        this.precio = precio;
        this.idMenu = idMenu;
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

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }
}
