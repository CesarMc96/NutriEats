package com.cesarmc96.nutrieats;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import BaseDatos.ConexionBD;

public class EditarUsuario extends AppCompatActivity {

    EditText txtNombre;
    EditText txtContraseña;
    Button btnRegistro;
    EditText txtApellidos;
    EditText txtFecha;
    EditText txtCorreo;
    EditText txtTelefono;
    String email;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtFecha = findViewById(R.id.txtFecha);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtContraseña = findViewById(R.id.txtContra);
        btnRegistro = findViewById(R.id.btn);
        email = getIntent().getStringExtra("email");

        final ConexionBD bd = new ConexionBD(this);
        SQLiteDatabase base = bd.getReadableDatabase();
        cursor = base.rawQuery("Select email, nombre, apellidos, telefono, contrasena from usuarios",null);

        if(cursor.moveToFirst() == true){
            do {
                if (email.equals(cursor.getString(0))){
                    txtNombre.setText(cursor.getString(1));
                    txtApellidos.setText(cursor.getString(2));
                    txtCorreo.setText(cursor.getString(0));
                    txtTelefono.setText(cursor.getString(3));
                    txtContraseña.setText(cursor.getString(4));
                }
            }
            while(cursor.moveToNext());
        }

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizar();
            }
        });
    }

    public void actualizar(){
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

        base.update("usuarios", ct, "email='"+ email +"'", null);

        Toast toast1 = Toast.makeText(getApplicationContext(),"Usario Actualizado", Toast.LENGTH_SHORT);
        toast1.show();

        Intent i = new Intent(getApplicationContext(), Perfil.class);
        i.putExtra("email", email);
        startActivity(i);
    }
}