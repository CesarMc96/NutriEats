package com.cesarmc96.nutrieats;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import BaseDatos.ConexionBD;

public class EditarTarjeta extends AppCompatActivity {
    Button btnGuardar;
    TextView editTarjeta;
    TextView editCVV;
    TextView editFecha;
    Cursor cursor;
    String tarjeta;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_tarjeta);

        btnGuardar = findViewById(R.id.btnGuardar);
        editTarjeta = findViewById(R.id.txtTarjeta);
        editCVV = findViewById(R.id.txtCVV);
        editFecha = findViewById(R.id.txtFechaV);
        tarjeta = getIntent().getStringExtra("email");

        final ConexionBD bd = new ConexionBD(this);
        SQLiteDatabase base = bd.getReadableDatabase();
        cursor = base.rawQuery("Select id, tarjeta, fecha, codigo from tarjetas",null);

        if(cursor.moveToFirst() == true){
            do {
                if (tarjeta.equals(cursor.getString(1))){
                    editTarjeta.setText(cursor.getString(1));
                    editCVV.setText(cursor.getString(3));
                    editFecha.setText(cursor.getString(2));
                    id = cursor.getString(0);
                }
            }
            while(cursor.moveToNext());
        }


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizar();
            }
        });
    }

    public void actualizar(){
        final ConexionBD bd = new ConexionBD(this);
        SQLiteDatabase base = bd.getWritableDatabase();

        String tarjeta = editTarjeta.getText().toString();
        String CVV = editCVV.getText().toString();
        String fecha = editFecha.getText().toString();

        ContentValues ct = new ContentValues();
        ct.put("tarjeta", tarjeta);
        ct.put("CVV", CVV);
        ct.put("fecha", fecha);

        base.update("tarjetas", ct, "id='"+ id +"'", null);

        Toast toast1 = Toast.makeText(getApplicationContext(),"Tarjeta Actualizado", Toast.LENGTH_SHORT);
        toast1.show();

        Intent i = new Intent(getApplicationContext(), Perfil.class);
        i.putExtra("tarjeta", tarjeta);
        startActivity(i);
    }
}
