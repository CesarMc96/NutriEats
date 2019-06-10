package com.cesarmc96.nutrieats;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import BaseDatos.ConexionBD;

public class AgregarTarjeta extends AppCompatActivity {

    Button btnGuardar;
    TextView editTarjeta;
    TextView editCVV;
    TextView editFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tarjeta);

        btnGuardar = findViewById(R.id.btnGuardar);
        editTarjeta = findViewById(R.id.txtTarjeta);
        editCVV = findViewById(R.id.txtCVV);
        editFecha = findViewById(R.id.txtFechaV);

        final ConexionBD bd = new ConexionBD(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase base = bd.getWritableDatabase();
                String tarjeta = editTarjeta.getText().toString();
                String fecha = editFecha.getText().toString();
                String codigo = editCVV.getText().toString();

                ContentValues ct = new ContentValues();
                ct.put("tarjeta", tarjeta);
                ct.put("fecha", fecha);
                ct.put("codigo", codigo);
                base.insert("tarjetas", null,ct);

                Toast toast1 = Toast.makeText(getApplicationContext(),"Tarjeta Registrada", Toast.LENGTH_SHORT);
                toast1.show();

                Intent i = new Intent(getApplicationContext(), ListaTarjeta.class);
                i.putExtra("tarjeta", tarjeta);
                startActivity(i);
            }
        });
    }
}
