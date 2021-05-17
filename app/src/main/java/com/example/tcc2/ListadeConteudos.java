package com.example.tcc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListadeConteudos extends AppCompatActivity {

    private ListView listConteudos;
    private String[] conteudos = {"Herança Digital", "O que define um Patrimonio Digital"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listade_conteudos);

        listConteudos = findViewById(R.id.listConteudo);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                conteudos
        );

        listConteudos.setAdapter(adaptador);
    }
}