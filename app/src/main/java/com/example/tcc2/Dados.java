package com.example.tcc2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

public class Dados extends Fragment {
    public String info;
    public TextView n,s,e,c,cp,d;

    public Dados(String info){
        this.info = info;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dados, container, false);

        n = view.findViewById(R.id.dsNome);
        s = view.findViewById(R.id.dsEmail);
        e = view.findViewById(R.id.dsEmail);
        c = view.findViewById(R.id.dsCelular);
        cp = view.findViewById(R.id.dsCPF);
        d = view.findViewById(R.id.dtNasc);

        Log.i("Info", info);

        try {
            JSONObject jsonObj = new JSONObject(info);
            Toast.makeText(getActivity(), "Bem-Vindo "+ jsonObj.getString("nome"), Toast.LENGTH_SHORT).show();
            n.setText(jsonObj.getString("nome"));
            s.setText(jsonObj.getString("sobrenome"));
            e.setText(jsonObj.getString("email"));
            c.setText(jsonObj.getString("celular"));
            cp.setText(jsonObj.getString("cpf"));
            d.setText(jsonObj.getString("dt_nasc"));

        } catch (JSONException ex) {
            ex.printStackTrace();
        }






        return view;
    }
}
