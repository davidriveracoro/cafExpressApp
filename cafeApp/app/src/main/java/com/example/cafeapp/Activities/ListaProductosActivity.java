package com.example.cafeapp.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cafeapp.Adapters.ListaProductosAdapter;
import com.example.cafeapp.Models.Carrito;
import com.example.cafeapp.Models.Producto;
import com.example.cafeapp.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaProductosActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    Intent inCart;
    Intent inDatosCart;
    TextView txtVwTitleMenu;
    ListView lstProd;
    private Carrito myCart;
    private ArrayList<Producto> alProd;
    private ArrayList<Integer> alCant;
    int idMenu = 1;
    Producto[] apDat;
    int[] aCant;

    /**
     * DESAYUNOS -> 1
     * LIGEROS -> 2
     * BURRITOS -> 3
     * SNACKS -> 4
     * HAMBURGUESAS -> 5
     * TORTAS -> 6
     */
    Producto[] arrayProducts = {
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
    Producto[] arrayProductByMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        inCart = new Intent(this,CartActivity.class);
        idMenu = getIntent().getIntExtra("idMenu",1);
        alProd = new ArrayList<>();
        alCant = new ArrayList<>();
        arrayProductByMenu = getProductByMenu(arrayProducts,idMenu);

        myCart = (Carrito) getIntent().getSerializableExtra("myCart");

        if(myCart == null){
            myCart = new Carrito();
        }else{
            addValuesToArray(myCart.getaProd(),myCart.getiCant());
        }


        txtVwTitleMenu = findViewById(R.id.txtVwTitleMenu);
        lstProd = findViewById(R.id.lstProd);
        lstProd.setAdapter(
                new ListaProductosAdapter(this,R.layout.products_row, arrayProductByMenu)
        );

        lstProd.setOnItemClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnAddMore:
                //TODO: Pasar carrito a otros activities
                inDatosCart = new Intent();
                inDatosCart.putExtra("myCart",myCart);
                setResult(Activity.RESULT_OK,inDatosCart);
                finish();
                break;
            case R.id.btnFinalizar:
                //TODO: Agregar fechas
                apDat = convertArray(alProd);
                aCant = convertIntArray(alCant);

                myCart.setaProd(apDat);
                myCart.setiCant(aCant);
                inCart.putExtra("myObj",myCart);
                startActivity(inCart);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        final Dialog dlgMiDialogo;
        dlgMiDialogo = new Dialog(this);
        dlgMiDialogo.setContentView(R.layout.dialog_add_product);
        final EditText edtTxtCant;
        Button btnAddProduct, btnCancelarAddProduct;

        edtTxtCant = dlgMiDialogo.findViewById(R.id.edtTxtCant);
        btnAddProduct = dlgMiDialogo.findViewById(R.id.btnAddProduct);
        btnCancelarAddProduct = dlgMiDialogo.findViewById(R.id.btnCancelarAddProduct);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alProd.add(arrayProductByMenu[position]);
                alCant.add(Integer.parseInt(edtTxtCant.getText().toString()));

                apDat = convertArray(alProd);
                aCant = convertIntArray(alCant);

                myCart.setaProd(apDat);
                myCart.setiCant(aCant);
                Toast.makeText(getApplicationContext(),"Se agregó "+edtTxtCant.getText().toString()+
                        " de "+ arrayProductByMenu[position].getNomProd()+" al carrito",Toast.LENGTH_SHORT).show();
                dlgMiDialogo.dismiss();
            }
        });

        btnCancelarAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlgMiDialogo.dismiss();
            }
        });

        dlgMiDialogo.show();
    }

    /**
     *
     * @param apData Arreglo de productos inicial
     * @param iCategoria id de categoria que se desea agrupar
     * @return regresa un arreglo de productos agrupados por menu
     */
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

    public Producto[] convertArray(ArrayList<Producto> alData){
        Object[] objectAux = alData.toArray();
        Producto[] apAux = Arrays.copyOf(objectAux,objectAux.length,Producto[].class);
        return apAux;
    }

    public int[] convertIntArray(ArrayList<Integer> alData){
        int[] iAux = new int[alData.size()];
        for(int i = 0; i< iAux.length; i++){
            iAux[i] = alData.get(i).intValue();
        }
        return iAux;
    }

    public void addValuesToArray(Producto[] aProd, int[] aCant){
        for(int i = 0; i<aProd.length;i++){
            alProd.add(aProd[i]);
            alCant.add(aCant[i]);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu,menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.opcMirar:
                return true;
            case R.id.opcNew:
                return true;
            case R.id.opcConf:
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}