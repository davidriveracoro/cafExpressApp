package com.example.cafeapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<Menu> {
    private Context cApp;
    private int iMyLayout;

    private Menu[] amDatos;

    public MenuAdapter(@NonNull Context context, int resource, @NonNull Menu[] objects) {
        super(context, resource, objects);
        cApp = context;
        iMyLayout = resource;
        amDatos = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        LinearLayout lytImgMenu;
        TextView txtVwTitle;

        View vwMyLayout = convertView;

        if(vwMyLayout == null){
            LayoutInflater liCrearLayout = ((Activity) cApp).getLayoutInflater();
            vwMyLayout = liCrearLayout.inflate(iMyLayout,parent,false);

        }

        lytImgMenu = vwMyLayout.findViewById(R.id.lytImgMenu);
        txtVwTitle = vwMyLayout.findViewById(R.id.txtVwTitle);

        Menu mDato = amDatos[position];
        lytImgMenu.setBackgroundResource(mDato.getImg_menu());
        txtVwTitle.setText(mDato.getTitle());

        return vwMyLayout;

    }
}

