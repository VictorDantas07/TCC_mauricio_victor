package com.example.tcc2;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class ConsultarList extends Fragment {
    ListView lv;

    ArrayAdapter<String> adapter;
    String dados;
    String[] dadosArr = null;
    JSONArray array = null;


    public ConsultarList(String dados){
        this.dados = dados;
    }

//    @Override
    public void setPopupLayout(JSONObject array) throws JSONException {

        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView =  layoutInflater.inflate(R.layout.popup_layout, null);

        PopupWindow popupWindow = new PopupWindow(popupView, 850, 1200, true);

        TextView tV1 = popupView.findViewById(R.id.popup_details);
        TextView tV2 = popupView.findViewById(R.id.popup_details2);
        TextView tV3 = popupView.findViewById(R.id.popup_details3);
        TextView tV4 = popupView.findViewById(R.id.popup_details4);
        TextView tV5 = popupView.findViewById(R.id.popup_details5);
//        texto = array.getString("categoria");
        tV1.setText("Dados da Conta: "+ array.getString("descricao"));
        tV2.setText("Categoria: "+ array.getString("categoria"));
        tV3.setText("Usuário: "+ array.getString("usuario"));
        tV4.setText("Senha: "+ array.getString("senha"));
        tV5.setText("OBS: "+ array.getString("obs"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popupWindow.setElevation(20);
        }

        popupWindow.showAtLocation(getView(), Gravity.CENTER ,0, 0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.consultar, container, false);

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

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                try {
                    setPopupLayout(array.getJSONObject(position));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }


}
