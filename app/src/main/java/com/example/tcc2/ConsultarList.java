package com.example.tcc2;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class ConsultarList extends Fragment implements AdapterView.OnItemClickListener {
    ListView lv;

    ArrayAdapter<String> adapter;
    String dados;
    String[] dadosArr = null;
//    String[] teste = {"TESTE","TESTE","TESTE","TESTE","TESTE","TESTE"};

    public ConsultarList(String dados){
        this.dados = dados;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.consultar, container, false);
        JSONArray array = null;
        JSONObject jsonObject = null;
        Integer tamanho = null, x = 0;
        String texto = null;

        try {
            JSONObject jsonObj = new JSONObject(this.dados);
            tamanho = Integer.parseInt(jsonObj.getString("tamanho"));
            dadosArr = new String[tamanho];

            array = jsonObj.getJSONArray("docs");

            while (x < tamanho){
                jsonObject = array.getJSONObject(x);
                texto = jsonObject.getString("categoria")+" - Descrição: "+jsonObject.getString("descricao");
                dadosArr[x] = texto;
                x = x+1;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        lv = (ListView) view.findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dadosArr);
        lv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("TEste", String.valueOf(position));
        Toast.makeText(getActivity(),"Teste",Toast.LENGTH_LONG).show();
    }


}
