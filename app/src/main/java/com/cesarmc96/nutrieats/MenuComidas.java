package com.cesarmc96.nutrieats;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import BaseDatos.ConexionBD;

public class MenuComidas extends AppCompatActivity {
    Button btnBuscar;
    RadioButton radioDesayuno;
    RadioButton radioComida;
    RadioButton radioCena;
    TextView comidaU;
    TextView comidaD;
    TextView precioU;
    TextView precioD;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnBuscar = findViewById(R.id.btnBuscarM);
        radioDesayuno = findViewById(R.id.radioD);
        radioComida = findViewById(R.id.radioCo);
        radioCena = findViewById(R.id.radioCe);
        comidaU = findViewById(R.id.textComidaUno);
        comidaD = findViewById(R.id.textComidaDos);
        precioU = findViewById(R.id.textPrecioU);
        precioD = findViewById(R.id.textPrecioD);

        final ConexionBD bd = new ConexionBD(this);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            SQLiteDatabase base = bd.getReadableDatabase();
            Integer contador = 1;
            /*
            String cena = "cena";
            String comida= "comida";
            String desayuno= "desayuno";*/
            @Override
            public void onClick(View v) {
                if (radioDesayuno.isChecked()== true){
                    cursor = base.rawQuery("Select tipo from comidas where tipo = 'desayuno'",null);
                    do {

                        if (contador==1){

                            String nombreR= cursor.getString(0);
                            String precioR = cursor.getString(1);
                            comidaU.setText(nombreR);
                            precioU.setText(precioR);
                        } else {
                            String nombreR= cursor.getString(0);
                            String precioR = cursor.getString(1);
                            comidaD.setText(nombreR);
                            precioD.setText(precioR);
                        }

                        contador = contador +1;
                    } while(cursor.moveToNext());

                } else {
                        if (radioComida.isChecked()==true){
                            cursor = base.rawQuery("Select tipo from comidas where tipo = 'comida'",null);
                            do {

                                if (contador==1){

                                    String nombreRR= cursor.getString(0);
                                    String precioRR = cursor.getString(1);
                                    comidaU.setText(nombreRR);
                                    precioU.setText(precioRR);
                                } else {
                                    String nombreR= cursor.getString(0);
                                    String precioR = cursor.getString(1);
                                    comidaD.setText(nombreR);
                                    precioD.setText(precioR);
                                }

                                contador = contador +1;
                            } while(cursor.moveToNext());
                        } else {
                            cursor = base.rawQuery("Select tipo from comidas where tipo = 'cena'",null);
                            do {

                                if (contador==1){

                                    String nombreR= cursor.getString(0);
                                    String precioR = cursor.getString(1);
                                    comidaU.setText(nombreR);
                                    precioU.setText(precioR);
                                } else {
                                    String nombreR= cursor.getString(0);
                                    String precioR = cursor.getString(1);
                                    comidaD.setText(nombreR);
                                    precioD.setText(precioR);
                                }

                                contador = contador +1;
                            } while(cursor.moveToNext());
                        }
                }
            }
        });
    }
}
