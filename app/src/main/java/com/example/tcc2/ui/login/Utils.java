package com.example.tcc2.ui.login;

import android.util.Log;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Utils {
//    public PessoaObj getInformacao(String end){
//        String json;
//        PessoaObj retorno;
//        json = NetworkUtils.getJSONFromAPI(end);
//        Log.i("Resultado", json);
//        retorno = parseJson(json);
//
//        return retorno;
//    }

    public String getInformacao(String end){
        String json;
        PessoaObj retorno;
        json = NetworkUtils.getJSONFromAPI(end);

        return json;
    }
    private PessoaObj parseJson(String json){
        try {
            PessoaObj pessoa = new PessoaObj();

            JSONObject jsonObj = new JSONObject(json);
            Log.i("Resultado #######", jsonObj.getString("senha"));

            //Atribui os objetos que estão nas camadas mais altas
            pessoa.setNome(jsonObj.getString("nome"));
            pessoa.setSobrenome(jsonObj.getString("sobrenome"));
            pessoa.setSenha(jsonObj.getString("senha"));
            pessoa.setTelefone(jsonObj.getString("celular"));
            pessoa.setNascimento(jsonObj.getString("dt_nasc"));
            pessoa.setCdUsu(jsonObj.getString("_id"));
            pessoa.setCpf(jsonObj.getString("cpf"));
            pessoa.setEmail(jsonObj.getString("email"));

            return pessoa;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

    public String getDados(String end) {
        String json;
        json = NetworkUtils.getJSONFromAPI(end);
        return json;
    }
}
