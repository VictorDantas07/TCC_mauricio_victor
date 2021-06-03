package com.example.tcc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

public class Contato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription("      ")

                .addGroup("Entre em contato com os desenvolvedores")
                .addEmail("v.silva.v1013@gmail.com", "Envie um e-mail para Victor Dantas")
                .addEmail("", "Envie um e-mail para Maurício Barbosa")

                .addGroup("Redes Sociais")
                .addFacebook("victor.s.dantas","Facebook Victor")
                .addFacebook("mauricio.barbosa.7334", "Facebook Maurício")
                .addGitHub("VictorDantas07", "Github Victor")
                .addGitHub("Barbosa-mc", "Github Maurício")
                .create();

        setContentView(view);
    }
}