package com.example.cafeapp.Adapters;

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

import com.example.cafeapp.Models.Menu;
import com.example.cafeapp.Models.Producto;
import com.example.cafeapp.R;

import java.util.ArrayList;

public class ListaProductosAdapter extends ArrayAdapter<Producto> {
    private Context cApp;
    private int iMyLayout;

//    private Menu[] amDatos;
    private Producto[] apDatos;

    public ListaProductosAdapter(@NonNull Context context, int resource, @NonNull Producto[] objects) {
        super(context, resource, objects);
        cApp = context;
        iMyLayout = resource;
        apDatos = objects;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        TextView txtVwNomProd,txtVwPrecio;

        View vwMyLayout = convertView;

        if(vwMyLayout == null){
            LayoutInflater liCrearLayout = ((Activity) cApp).getLayoutInflater();
            vwMyLayout = liCrearLayout.inflate(iMyLayout,parent,false);

        }

        txtVwPrecio = vwMyLayout.findViewById(R.id.txtVwPrecio);
        txtVwNomProd = vwMyLayout.findViewById(R.id.txtVwNomProd);

        Producto pDato = apDatos[position];
        txtVwPrecio.setText("$"+pDato.getPrecio());
        txtVwNomProd.setText(pDato.getNomProd());

        return vwMyLayout;
    }
}
