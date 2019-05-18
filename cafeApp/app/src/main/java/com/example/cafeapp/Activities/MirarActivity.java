package com.example.cafeapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cafeapp.Models.Carrito;
import com.example.cafeapp.Models.Compra;
import com.example.cafeapp.R;

public class MirarActivity extends AppCompatActivity {
    private Compra myCompra;
    TextView txtVwIdStat,txtVwStat,txtVwTimeStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirar);
        txtVwIdStat = findViewById(R.id.txtVwIdStat);
        txtVwStat = findViewById(R.id.txtVwStat);
        txtVwTimeStat = findViewById(R.id.txtVwTimeStat);

        myCompra = (Compra) getIntent().getSerializableExtra("myCompra");

        txtVwIdStat.setText(""+myCompra.getIdCarrito());
        txtVwStat.setText(myCompra.getStatus());
        txtVwTimeStat.setText(myCompra.getFecha()+" "+myCompra.getHour());
    }
}
