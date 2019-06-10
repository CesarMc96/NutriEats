package com.cesarmc96.nutrieats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText editaUsuario;
    EditText editaContraseña;
    Button btnEnviar;
    Button btnRegistrarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editaUsuario = findViewById(R.id.editUsuario);
        editaContraseña = findViewById(R.id.editContraseña);
        btnEnviar = findViewById(R.id.btn);
        btnRegistrarme = findViewById(R.id.btnRegistrarse);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = editaUsuario.getText().toString();
                String contra = editaContraseña.getText().toString();

                if (usuario.equals("admin") && contra.equals("123")){
                    /*Toast toast1 = Toast.makeText(getApplicationContext(),"Entro", Toast.LENGTH_SHORT);
                    toast1.show();*/

                    Intent i = new Intent(getApplicationContext(), MenuPrincipal.class);
                    startActivity(i);
                } else {
                    Toast toast1 = Toast.makeText(getApplicationContext(),"Error usuario/contraseña", Toast.LENGTH_SHORT);
                    toast1.show();
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
}