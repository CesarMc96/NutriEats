package com.cesarmc96.nutrieats;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import BaseDatos.ConexionBD;

public class Perfil extends AppCompatActivity {

    TextView editNombre;
    TextView editApellidos;
    String nombre;
    Cursor cursor;
    String email;
    Button btnCerrar, btnDieta, btnObjetivos, btnDireccion, btnPago, btnEditar, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        editNombre = findViewById(R.id.txtNombre);
        editApellidos = findViewById(R.id.txtApellidos);
        btnCerrar = findViewById(R.id.btnCerrar);
        btnDieta = findViewById(R.id.btnDieta);
        btnObjetivos = findViewById(R.id.btnObjetivos);
        btnDireccion = findViewById(R.id.btnDireccion);
        btnEditar = findViewById(R.id.btnEditar);
        btnPago = findViewById(R.id.btnPago);
        btnHome =findViewById(R.id.button8);
        email = getIntent().getStringExtra("email");

        final ConexionBD bd = new ConexionBD(this);
        SQLiteDatabase base = bd.getReadableDatabase();
        cursor = base.rawQuery("Select email, nombre, apellidos from usuarios",null);

        if(cursor.moveToFirst() == true){
            do {
                if (email.equals(cursor.getString(0))){
                    editNombre.setText(cursor.getString(1));
                    editApellidos.setText(cursor.getString(2));
                }
            }
            while(cursor.moveToNext());
        }

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EditarUsuario.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuPrincipal.class);
                i.putExtra("email",email);
                startActivity(i);
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });

        btnDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Dieta.class);
                startActivity(i);
            }
        });

        btnObjetivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Objetivos.class);
                startActivity(i);
            }
        });

        btnDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Direccion.class);
                startActivity(i);
            }
        });

        btnPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListaTarjeta.class);
                startActivity(i);
            }
        });

    }
}




