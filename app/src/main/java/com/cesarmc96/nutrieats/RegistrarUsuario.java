package com.cesarmc96.nutrieats;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLData;

import BaseDatos.ConexionBD;

public class RegistrarUsuario extends AppCompatActivity {

    EditText txtNombre;
    EditText txtContraseña;
    Button btnRegistro;
    EditText txtApellidos;
    EditText txtFecha;
    EditText txtCorreo;
    EditText txtTelefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtFecha = findViewById(R.id.txtFecha);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtContraseña = findViewById(R.id.txtContra);
        btnRegistro = findViewById(R.id.btn);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });
    }

    public void registrarUsuario(){
        final ConexionBD bd = new ConexionBD(this);
        SQLiteDatabase base = bd.getWritableDatabase();

        String nombre = txtNombre.getText().toString();
        String contrasena = txtContraseña.getText().toString();
        String apellidos = txtApellidos.getText().toString();
        String email = txtCorreo.getText().toString();
        String telefono = txtTelefono.getText().toString();

        ContentValues ct = new ContentValues();
        ct.put("nombre", nombre);
        ct.put("apellidos", apellidos);
        ct.put("telefono", telefono);
        ct.put("email", email);
        ct.put("contrasena", contrasena);

        base.insert("usuarios", null,ct);

        Toast toast1 = Toast.makeText(getApplicationContext(),"Usuario Registrado", Toast.LENGTH_SHORT);
        toast1.show();

        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);
    }
}
