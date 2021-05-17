package com.example.tcc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mehdi.sakout.aboutpage.AboutPage;

public class Contato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        new AboutPage(this)
                .setImage(R.drawable.logo)
                .create();
    }
}