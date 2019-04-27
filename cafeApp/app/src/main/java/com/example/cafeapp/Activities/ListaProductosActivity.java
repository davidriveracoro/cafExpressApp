package com.example.cafeapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cafeapp.Adapters.ListaProductosAdapter;
import com.example.cafeapp.Models.Producto;
import com.example.cafeapp.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaProductosActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    TextView txtVwTitleMenu;
    ListView lstProd;
    int idMenu = 1;

    /**
     * DESAYUNOS -> 1
     * LIGEROS -> 2
     * BURRITOS -> 3
     * SNACKS -> 4
     * HAMBURGUESAS -> 5
     * TORTAS -> 6
     */
    Producto[] apProd = {
            new Producto("Huevos al gusto",35,1),
            new Producto("Quesadillas",25,1),

            new Producto("Ensalada verde con atún",35,2),
            new Producto("Coctel de frutas",25,2),

            new Producto("Burritos",15,3),
            new Producto("Burritos de lomo",16,3),

            new Producto("Nachos",25,4),
            new Producto("Papas a la francesa",20,4),

            new Producto("Haburguesa sencilla",30,5),
            new Producto("Hamburgesa hawaiiana",35,5),

            new Producto("Torta de chile relleno",30,6),
            new Producto("Torta de lomo",35,6)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        idMenu = getIntent().getIntExtra("idMenu",1);

        txtVwTitleMenu = findViewById(R.id.txtVwTitleMenu);
        lstProd = findViewById(R.id.lstProd);
        lstProd.setAdapter(
                new ListaProductosAdapter(this,R.layout.products_row,getProductByMenu(apProd,idMenu))
        );

        lstProd.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //TODO: Cuadro de dialogo para agregar al carrito
        Toast.makeText(getApplicationContext(),"TODO:Cuadro de dialogo",Toast.LENGTH_SHORT).show();
    }

    public Producto[] getProductByMenu(Producto[] apData,int iCategoria){
        ArrayList<Producto> arrayAux = new ArrayList<Producto>();
        for (int i = 0; i<apData.length;i++){
            if(iCategoria == apData[i].getIdMenu()){
                arrayAux.add(apData[i]);
            }
        }

        Object[] objectAux = arrayAux.toArray();
        Producto[] apAux = Arrays.copyOf(objectAux,objectAux.length,Producto[].class);

        return apAux;
    }
}
