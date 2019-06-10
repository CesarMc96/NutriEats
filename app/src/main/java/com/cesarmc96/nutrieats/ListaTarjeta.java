package com.cesarmc96.nutrieats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListaTarjeta extends AppCompatActivity {

    Button btnAgregar;
    Button tarjeta1, tarjeta11;
    Button tarjeta2, tarjeta21;
    String tar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarjetas);

        btnAgregar = findViewById(R.id. btnAgregar);
        tarjeta1 = findViewById(R.id. btnTarjeta1);
        tarjeta11 = findViewById(R.id. btnTarjeta12);
        tarjeta2 = findViewById(R.id. btnTarjeta2);
        tarjeta21 = findViewById(R.id. btnTarjeta21);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AgregarTarjeta.class);
                startActivity(i);
            }
        });

        tarjeta21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarTarjeta();
            }
        });

        tarjeta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarTarjeta();
            }
        });

        tarjeta2.setVisibility(View.GONE);
        tarjeta21.setVisibility(View.GONE);

        tar = getIntent().getStringExtra("tarjeta");
        if(tar != null){
            tarjeta2.setVisibility(View.VISIBLE);
            tarjeta21.setVisibility(View.VISIBLE);

            tarjeta21.setText("**** " + tar.substring(12));
        }
    }

    public void editarTarjeta(){
        Intent i = new Intent(getApplicationContext(), AgregarTarjeta.class);
        i.putExtra("tarjeta", tar);
        startActivity(i);
    }
}
