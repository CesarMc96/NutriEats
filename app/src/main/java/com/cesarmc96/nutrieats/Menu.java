package com.cesarmc96.nutrieats;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import BaseDatos.ConexionBD;

public class Menu extends AppCompatActivity {
    Button btnBuscar;
    RadioButton radioDesayuno;
    RadioButton radioComida;
    RadioButton radioCena;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnBuscar = findViewById(R.id.btnBuscarM);
        radioDesayuno = findViewById(R.id.radioD);
        radioComida = findViewById(R.id.radioCo);
        radioCena = findViewById(R.id.radioCe);

        final ConexionBD bd = new ConexionBD(this);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            SQLiteDatabase base = bd.getReadableDatabase();

            cursor = base.rawQuery("Select tipo from comidas",null);

            @Override
            public void onClick(View v) {
                if (radioDesayuno.isChecked()== true){

                } else {
                        if (radioComida.isChecked()==true){

                        } else {

                        }
                }
            }
        });
    }
}
