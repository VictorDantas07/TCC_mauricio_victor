package com.example.tcc2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

public class Home extends Fragment {
    String info;
    public TextView bemvindo, descricao, conteudo, contato, sobre;

    Button btnConteudo, btnSobre, btnContato;


    public Home(String info){
        this.info = info;
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        bemvindo = view.findViewById(R.id.bemvindo);
        descricao = view.findViewById(R.id.descricaoApp);
        conteudo = view.findViewById(R.id.conteudo);
        sobre = view.findViewById(R.id.sobre);
        contato = view.findViewById(R.id.contato);
        btnContato = (Button) view.findViewById(R.id.btnContato);
        btnConteudo = (Button) view.findViewById(R.id.btnTextos);
        btnSobre = (Button) view.findViewById(R.id.btnSobre);

        try {
            JSONObject jsonObj = new JSONObject(info);
            bemvindo.setText("Olá, "+jsonObj.getString("nome") + "!");
            descricao.setText("O APP do CofreDigital é uma maneira mais acessível para manter a organização do seu Patrimônio Digital!");
            conteudo.setText("Conteúdos de aprofundamento acerca do tema.");
            contato.setText("Contato dos desenvolvedores do projeto.");
            sobre.setText("Maiores detalhes sobre o desenvolvimento, objetivo e atuação do CofreDigital.");

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
                    Intent it = new Intent(getContext(), Sobre.class);
                    startActivity(it);

                }
            });


        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return view;
    }
}
