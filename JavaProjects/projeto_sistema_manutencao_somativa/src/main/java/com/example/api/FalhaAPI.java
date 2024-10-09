package com.example.api;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Maquina;

public class FalhaAPI {
    public static List<Maquina> getMaquinas() {
        String json = ApiConnection.getData("falhas");
        List<Maquina> maquinas = new ArrayList<>();


        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Maquina maquina = new Maquina(
                    jsonObject.getString("id"),
                    jsonObject.getInt("maquinaId"),
                    jsonObject.getString("data"),
                    jsonObject.getString("problema"),
                    jsonObject.getString("prioridade"),
                    jsonObject.getString("operador")
                );
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }

    public static List<Maquina> getMaquina() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMaquina'");
    }
}
