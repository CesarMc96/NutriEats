package com.cesarmc96.nutrieats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TuDieta extends AppCompatActivity {

    private ListView lista;
    private ArrayList<String> arreglo;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_dieta);

        lista = findViewById(R.id.list_dieta);
        arreglo = new ArrayList<>();
        arreglo.add("100 gr de Arroz");
        arreglo.add("Pescado");
        arreglo.add("10 Verenjenas");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arreglo);
        lista = (ListView) findViewById(R.id.list_dieta);
        lista.setAdapter(adapter);
    }

}
