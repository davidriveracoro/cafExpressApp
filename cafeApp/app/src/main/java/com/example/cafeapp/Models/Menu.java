package com.example.cafeapp.Models;

import java.util.ArrayList;

public class Menu {
    private int img_menu;
    private String title;
    private ArrayList<Producto> asProd;


    public Menu(int img_menu, String title) {
        this.img_menu = img_menu;
        this.title = title;
    }

    public Menu(int img_menu, String title, ArrayList<Producto> asProd) {
        this.img_menu = img_menu;
        this.title = title;
        this.asProd = asProd;
    }

    public int getImg_menu() {
        return img_menu;
    }

    public void setImg_menu(int img_menu) {
        this.img_menu = img_menu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Producto> getAsProd() {
        return asProd;
    }

    public void setAsProd(ArrayList<Producto> asProd) {
        this.asProd = asProd;
    }
}
