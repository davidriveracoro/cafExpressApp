package com.example.cafeapp;

public class Menu {
    private int img_menu;
    private String title;

    public Menu(int img_menu, String title) {
        this.img_menu = img_menu;
        this.title = title;
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
}
