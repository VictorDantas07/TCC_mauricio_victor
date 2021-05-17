package com.example.tcc2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

public class Home extends Fragment {
    String info;
    public TextView n;

    Button btnConteudo, btnSobre, btnContato;


    public Home(String info){
        this.info = info;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        n = view.findViewById(R.id.bemvindo);
        btnContato = (Button) view.findViewById(R.id.btnContato);
        btnConteudo = (Button) view.findViewById(R.id.btnTextos);
        btnSobre = (Button) view.findViewById(R.id.btnSobre);

        try {
            JSONObject jsonObj = new JSONObject(info);
            n.setText("Bem-Vindo, "+jsonObj.getString("nome") + "!");

            btnConteudo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = new Intent(getContext(), ListadeConteudos.class);
                    startActivity(it);

                }
            });

            btnContato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = new Intent(getContext(), Contato.class);
                    startActivity(it);

                }
            });

            btnSobre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = new Intent(getContext(), Contato.class);
                    startActivity(it);

                }
            });


        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return view;
    }
}
