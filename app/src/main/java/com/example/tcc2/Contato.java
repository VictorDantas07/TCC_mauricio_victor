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
                .setDescription("TESTE")
                .create();

        setContentView(view);
    }
}