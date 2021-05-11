package com.example.tcc2;

import android.os.Bundle;
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

public class Home extends Fragment {
    String info;
    public TextView n;

    public Home(String info){
        this.info = info;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        n = view.findViewById(R.id.bemvindo);

        try {
            JSONObject jsonObj = new JSONObject(info);
            n.setText("Bem-Vindo, "+jsonObj.getString("nome") + "!");

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return view;
    }
}
