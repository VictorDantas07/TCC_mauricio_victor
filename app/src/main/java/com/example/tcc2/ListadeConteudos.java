package com.example.tcc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tcc2.ConteudosAdicionais.Heranca;

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

        listConteudos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent it = new Intent(ListadeConteudos.this, Heranca.class);
                    startActivity(it);
                }
                if (position == 1){
                    Intent it = new Intent(ListadeConteudos.this, Heranca.class);
                    startActivity(it);
                }
                if (position == 2){
                    Intent it = new Intent(ListadeConteudos.this, Heranca.class);
                    startActivity(it);
                }
            }
        });
    }
}