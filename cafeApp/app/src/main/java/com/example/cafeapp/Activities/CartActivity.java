package com.example.cafeapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cafeapp.Models.Carrito;
import com.example.cafeapp.Models.Compra;
import com.example.cafeapp.Models.Producto;
import com.example.cafeapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {
    TextView txtVwListProduct,txtVwTotal,txtVwPriceProduct;
    private Compra myCompra;
    Intent inMirar;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        txtVwListProduct = findViewById(R.id.txtVwListProduct);
        txtVwPriceProduct = findViewById(R.id.txtVwPriceProduct);
        txtVwTotal = findViewById(R.id.txtVwTotal);
        inMirar = new Intent(this, MirarActivity.class);
        myCompra = new Compra();



        Intent i = getIntent();
        Carrito myFinalCart = (Carrito) i.getSerializableExtra("myObj");
        printCart(myFinalCart);
    }

    public void printCart(Carrito myCart){
        Producto[] myProduct = myCart.getaProd();
        int[] myCant = myCart.getiCant();
        int iAux;
        int iTotal=0;
        txtVwListProduct.setText("");
        for(int i=0; i<myProduct.length;i++){
            iAux = myProduct[i].getPrecio() * myCant[i];
            txtVwListProduct.append(myCant[i]+" X "+myProduct[i].getNomProd()+"\n");
            txtVwPriceProduct.append("$"+iAux+" MXN \n");
            iTotal += iAux;
        }

        txtVwTotal.setText("TOTAL: $" +iTotal+ " MXN");
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

    public void onClickBtn(View v){
        switch (v.getId()){
            case R.id.btnComprar:
                //TODO: Comprobar pago, insertar  compra en la bd
                myCompra.setFecha(dateFormat.format(date));
                myCompra.setHour(hourFormat.format(date));
                myCompra.setStatus("En proceso..");
                myCompra.setNumPedido(420);

                inMirar.putExtra("myCompra", myCompra);
                startActivity(inMirar);

                break;
            case R.id.btnCanCart:
                break;
        }
    }


}
