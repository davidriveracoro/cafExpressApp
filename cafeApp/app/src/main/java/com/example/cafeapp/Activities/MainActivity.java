package com.example.cafeapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cafeapp.Activities.ListaProductosActivity;
import com.example.cafeapp.Adapters.MenuAdapter;
import com.example.cafeapp.Models.Menu;
import com.example.cafeapp.Models.Producto;
import com.example.cafeapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    Intent inListaProductos;
    ListView lstMenu;
    static ArrayList<Producto> apDatonLoco;
    Producto pProd;

    /**
     * DESAYUNOS -> 1
     * LIGEROS -> 2
     * BURRITOS -> 3
     * SNACKS -> 4
     * HAMBURGUESAS -> 5
     * TORTAS -> 6
     */
    static Menu[] amDatosLocos = {
            new Menu(R.drawable.burrito,"DESAYUNOS"),
            new Menu(R.drawable.cake,"LIGEROS"),
            new Menu(R.drawable.burrito,"BURRITOS"),
            new Menu(R.drawable.cake,"SNACKS"),
            new Menu(R.drawable.burrito,"HAMBURGUESAS"),
            new Menu(R.drawable.cake,"TORTAS")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inListaProductos = new Intent(this, ListaProductosActivity.class);
        lstMenu = findViewById(R.id.lstMenu);
        lstMenu.setAdapter(
                new MenuAdapter(this,R.layout.menu_row,amDatosLocos)
        );

        lstMenu.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int iVal = ((int) id) + 1;
        inListaProductos.putExtra("idMenu",iVal);
        startActivity(inListaProductos);
    }
}
