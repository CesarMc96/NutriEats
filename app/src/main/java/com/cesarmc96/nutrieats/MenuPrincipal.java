package com.cesarmc96.nutrieats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {

    Button btnPerfil;
    Button btnComida;
    Button btnPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_acivity);

        btnPerfil = findViewById(R.id.btnPerfil);
        btnComida = findViewById(R.id.btnComidas);
        btnPedidos = findViewById(R.id.btnPedidos);

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Perfil.class);
                startActivity(i);
            }
        });

        btnComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ComidaDelDia.class);
                startActivity(i);
            }
        });

        btnPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TuDieta.class);
                startActivity(i);
            }
        });
    }
}
