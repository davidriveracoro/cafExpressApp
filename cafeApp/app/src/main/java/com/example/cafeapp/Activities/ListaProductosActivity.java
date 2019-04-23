package com.example.cafeapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cafeapp.Adapters.ListaProductosAdapter;
import com.example.cafeapp.Models.Producto;
import com.example.cafeapp.R;

public class ListaProductosActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    TextView txtVwTitleMenu;
    ListView lstProd;

    Producto[] apProd = {
            new Producto("Burrit",15),
            new Producto("Torta",35)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        txtVwTitleMenu = findViewById(R.id.txtVwTitleMenu);
        lstProd = findViewById(R.id.lstProd);
        lstProd.setAdapter(
                new ListaProductosAdapter(this,R.layout.products_row,apProd)
        );

        lstProd.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //TODO: Cuadro de dialogo para agregar al carrito
        Toast.makeText(getApplicationContext(),"TODO:Cuadro de dialogo",Toast.LENGTH_SHORT).show();
    }
}
