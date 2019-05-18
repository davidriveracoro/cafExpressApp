package com.example.cafeapp.Models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Producto implements Serializable {
    private int idProd;
    private String nomProd;
    private int precio;
    private int idMenu;
    private int tiempo;

    public Producto(String nomProd, int precio) {
        this.nomProd = nomProd;
        this.precio = precio;
    }

    public Producto(String nomProd, int precio, int idMenu) {
        this.nomProd = nomProd;
        this.precio = precio;
        this.idMenu = idMenu;
    }

    public Producto(int idProd, String nomProd, int precio, int idMenu) {
        this.idProd = idProd;
        this.nomProd = nomProd;
        this.precio = precio;
        this.idMenu = idMenu;
    }

    public Producto(int idProd, String nomProd, int precio, int idMenu, int tiempo) {
        this.idProd = idProd;
        this.nomProd = nomProd;
        this.precio = precio;
        this.idMenu = idMenu;
        this.tiempo = tiempo;
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

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
