package com.example.cafeapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cafeapp.Models.Carrito;
import com.example.cafeapp.Models.Producto;
import com.example.cafeapp.R;

public class CartActivity extends AppCompatActivity {
    TextView txtVwListProduct,txtVwTotal,txtVwPriceProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        txtVwListProduct = findViewById(R.id.txtVwListProduct);
        txtVwPriceProduct = findViewById(R.id.txtVwPriceProduct);
        txtVwTotal = findViewById(R.id.txtVwTotal);



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
}
