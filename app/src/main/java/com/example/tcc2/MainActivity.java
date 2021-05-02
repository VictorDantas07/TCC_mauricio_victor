package com.example.tcc2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tcc2.ui.login.LoginActivity;
import com.example.tcc2.ui.login.PessoaObj;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


import com.example.tcc2.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String info = null;
        String dados = null;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            info = extras.getString("info");
            dados = extras.getString("dados");
        }

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        sectionsPagerAdapter.setInfo(info);
        sectionsPagerAdapter.setDados(dados);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);




    }
}