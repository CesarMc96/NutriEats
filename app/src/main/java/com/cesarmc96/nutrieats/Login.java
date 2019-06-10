package com.cesarmc96.nutrieats;

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

public class Login extends AppCompatActivity {

    EditText editaUsuario;
    EditText editaContraseña;
    Button btnEnviar;
    Button btnRegistrarme;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editaUsuario = findViewById(R.id.editUsuario);
        editaContraseña = findViewById(R.id.editContraseña);
        btnEnviar = findViewById(R.id.btn);
        btnRegistrarme = findViewById(R.id.btnRegistrarse);

        final ConexionBD bd = new ConexionBD(this);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase base = bd.getReadableDatabase();
                String email = editaUsuario.getText().toString();
                String contra = editaContraseña.getText().toString();

                cursor = base.rawQuery("Select email, contrasena from usuarios",null);

                if(cursor.moveToFirst() == true){
                    do {
                        if (email.equals(cursor.getString(0)) && contra.equals(cursor.getString(1))){
                            Intent i = new Intent(getApplicationContext(), MenuPrincipal.class);
                            i.putExtra("email",email);
                            startActivity(i);
                        } /*else {
                            Toast toast1 = Toast.makeText(getApplicationContext(),"Error usuario/contraseña", Toast.LENGTH_SHORT);
                            toast1.show();
                        }*/
                    }
                    while(cursor.moveToNext());
                }
            }
        });

        btnRegistrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistrarUsuario.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}